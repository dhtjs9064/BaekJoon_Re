import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://st-lab.tistory.com/148
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // -로 분리
        String[] sub = br.readLine().split("-");

        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < sub.length; i++) {
            int temp = 0;

            // sub에서 +로 다시 분리
            String[] add = sub[i].split("\\+");

            // 덧셈끼리 먼저 더함
            for (String a : add) {
                temp += Integer.parseInt(a);
            }
            
            // 초기값을 넣은 후 중간 계산과정에서 이 조건문이 다시 true가 되면 안되므로 MAX_VALUE로 잡음
            if (sum == Integer.MAX_VALUE) {
                // 초기값을 처음 수로 넣음
                sum = temp;
                // 이제 남은 식을 전부 뺄셈함 = 최솟값 극대화
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}