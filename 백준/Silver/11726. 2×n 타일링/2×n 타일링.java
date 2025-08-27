import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int first = 1;
        int second = 2;
        int sum = 0;

        if (n == 1) {
            System.out.println(first);
        } else if (n == 2) {
            System.out.println(second);
        } else {
            for (int i = 2; i < n; i++) {
                sum = (first + second) % 10007;
                first = second;
                second = sum;
            }
            System.out.println(sum);
        }

    }
}
// 점화식 (n-1)
// 모듈러 공식