import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String st_number = br.readLine();
        int[] digit = new int[11];

        int number = Integer.parseInt(st_number);

        while (number > 0) {
            int temp = number % 10;
            // 오름차순으로 정렬
            digit[temp]++;
            number /= 10;
        }

        for (int i = digit.length - 1; i > 0; i--) {
            while (digit[i] > 0) {
                sb.append(i);
                digit[i]--;
            }
        }

        System.out.print(sb);

        if (st_number.length() != sb.length()) {
            for (int i = 0; i < st_number.length() - sb.length(); i++) {
                System.out.print(0);
            }
        }
    }
}
/*  설계 :
1. 각 자릿수를 분리함
2. 분리한 자릿수를 인덱스로 하는 배열을 생성과 동시에 개수를 셈
3. 그 인덱스가 나오면 그 값을 출력하고 이때 붙여서 출력
4. 또한, 출력 시 내림차순으로 출력 */