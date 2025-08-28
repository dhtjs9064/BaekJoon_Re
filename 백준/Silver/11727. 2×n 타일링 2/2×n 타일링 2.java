import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://comain.tistory.com/304#google_vignette
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int first = 1;
        int second = 3;
        int sum = 0;

        if (n == 1) {
            System.out.println(first);
        } else if (n == 2) {
            System.out.println(second);
        } else {
            for (int i = 2; i < n; i++) {
                sum = (second + 2 * first) % 10007;
                first = second;
                second = sum;
            }
            System.out.println(sum);
        }
    }
}
// 1, 3, 5, 11, 21
// 식 : (n-1) + (2 * (n-2))