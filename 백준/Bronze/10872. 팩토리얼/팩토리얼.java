import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 재귀를 사용하지 않았을 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int sum = number;
        for (int i = 1; i < number; i++) {
            sum *= number - i;
        }
        if (number == 0) {
            sum = 1;
        }
        System.out.println(sum);
    }
}
