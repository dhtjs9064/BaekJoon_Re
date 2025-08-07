import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고 : https://st-lab.tistory.com/121
public class Main {
    static int N;
    static int[] operator;
    static int[] number;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 주어진 숫자
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int idx) {
        // N이랑 같아야 하는 이유는 idx는 다음 연산자를 더하기 위함인데 그 끝은 N이랑 같아야하니까
        if (idx == N) {
            MAX = Math.max(num, MAX);
            MIN = Math.min(num, MIN);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 해당 연산자 개수가 1개 이상이면 로직 실행
            if (operator[i] > 0) {
                operator[i]--;

                // 갹 케이스에 따라 연산 수행
                // 연산방법: 처음 수와 그 다음 수를 연산함, 다음 수도 연산해야하기에 인덱스를 추가해서 넘김
                switch (i) {
                    case 0:
                        // 연산하고 그 다음수를 계산하기 위해 idx + 1
                        dfs(num + number[idx], idx + 1);
                        break;

                    case 1:
                        dfs(num - number[idx], idx + 1);
                        break;

                    case 2:
                        dfs(num * number[idx], idx + 1);
                        break;

                    case 3:
                        dfs(num / number[idx], idx + 1);
                }

                // 호출을 다 끝냄 = 연산이 끝남 = 연산자 개수 복구 후 다음 경우의 수때 다시 사용
                operator[i]++;
            }
        }

    }

}
// 1. 연산자를 배열로 표현하자
// 2. dfs로 연산자의 가짓수를 줄여나가자