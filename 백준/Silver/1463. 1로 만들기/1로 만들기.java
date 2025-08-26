import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://st-lab.tistory.com/133
public class Main {
    // null체크로 바로 구분하기 위해서 참조형으로 선언
    // int즉 기본형으로 선언하면 초기값이 0이므로 -1로 전부 초기화하고 구분해야하기에 번거롭다.
    // dp배열 선언 이유 : 값을 저장하면서 만약 중복 호출하게되면 계산하지 않고 바로 저장된 값을 주기위해서
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // dp[N]을 알기위해 한칸 늘림
        dp = new Integer[N + 1];
        // dp[0]은 사용되지 않을 것이지만 편의를 위해 방문한 것으로 적용
        dp[0] = dp[1] = 0;
        System.out.println(recur(N));
    }

    static int recur(int N) {
        // 최솟값을 구하고 + 1을 하는 이유는 현재 단계에서 한 번의 연산을 수행했다는 의미로,
        // 하위 단계에서 연산을 하고 현재 단계까지의 연산을 더하면 전체 연산의 횟수를 알 수 있다.
        while (dp[N] == null) {
            // 모든 경우의 수를 고려한다
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // /3 만된다는거니까 /3과 -1만 고려한다
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // /2만 된다는거니까 /2와 -1만 고려한다
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // -1만 된다는거니까 -1해준다.
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }

        return dp[N];
    }

}
/*
 사고과정 :
 왜 dp를 사용해야할까?
 -> 어떤 특정한 규칙이 없기 때문에 중복을 제거한 모든 연산의 경우의 수를 다 고려해봐야하기 때문
 dp를 사용한다 = 재귀를 이용하여 하위 문제가 해결되었을때를 가정하며 설계한다.
 추가로 2와 3 공통의 배수인 6의 경우도 고려해야한다.
 6으로 나눠짐 = 2, 3 둘 다 나눠짐 = 어느쪽이 최솟값인지 모름
 -1은 모든 경우의 수에서 다 가능하니까 전부 고려해야됨
*/
