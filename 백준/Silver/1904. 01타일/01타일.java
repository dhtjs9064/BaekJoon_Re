import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://st-lab.tistory.com/125
public class Main {
    // 방법 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(Tile(N));
    }

    static int Tile(int N) {

        int first = 1;
        int second = 2;
        int sum = 0;

        if (N == 1) {
            return first;
        } else if (N == 2) {
            return second;
        } else {
            for (int i = 2; i < N; i++) {
                sum = (first + second) % 15746;
                first = second;
                second = sum;
            }
            return sum;
        }
    }
}
// 규칙 : N = N-1 + N-2

// 방법 1
/*    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = -1;
        }

        System.out.println(Tile(N));
    }

    static int Tile(int N) {
        if (arr[N] == -1) {
            // 모듈러 공식 사용
            arr[N] = (Tile(N - 1) + Tile(N - 2)) % 15746;
        }
        return arr[N];
    }*/