// https://st-lab.tistory.com/230 참고버전
import java.util.Scanner;

public class Main {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N][N];

        // 배열을 생성하지 않으므로 메모리가 효율적
        for (int i = 0; i < N; i++) {
            String data = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = data.charAt(j) - '0';
            }
        }
/*        for (int i = 0; i < N; i++) {
            String[] data = sc.next().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(data[j]);
            }
        }*/
        partition(0, 0, N);

        System.out.println(sb);
    }

    static void partition(int x, int y, int size) {

        // 1. 만약 다 같은 색깔이라면
        // 2. N = 1이어도 여기서 해결
        if (colorCheck(x, y, size)) {
            if(arr[x][y] == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            // 처리했으니 그 함수는 종료
            return;
        }

        int dividedSize = size / 2;

        // 나누기 전에 괄호 열음
        sb.append('(');

        partition(x, y, dividedSize); // 2사분면
        partition(x, y + dividedSize, dividedSize); // 1사분면
        partition(x + dividedSize, y, dividedSize); // 3사분면
        partition(x + dividedSize, y + dividedSize, dividedSize); // 4사분면

        // 다 나눴으면 괄호 닫기
        sb.append(')');
    }

    static boolean colorCheck(int x, int y, int size) {
        // 시작 좌표의 색깔 기준
        int color = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        // 다 색깔이 같으면 통과
        return true;
    }
}
