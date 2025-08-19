import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://st-lab.tistory.com/94
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fib(n));

    }

    static long fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}