import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int N, int start, int end) {
        if (N == 0) {
            return;
        }
        hanoi(N - 1, start, 6 - start - end);
        sb.append(start);
        sb.append(" ");
        sb.append(end);
        sb.append("\n");
        hanoi(N - 1, 6 - start - end, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger num = new BigInteger("2");
        sb.append(num.pow(N).subtract(new BigInteger("1")));
        if (N <= 20) {
            sb.append("\n");
            hanoi(N, 1, 3);
        }
        System.out.println(sb);
    }
}
/* 하노이의 탑 규칙 :
1. 마지막 원반을 제외한 나머지는 모두 2번째로 옮겨야한다.
2. 마지막 원반은 3번째로 옮겨야한다.
3. 2번째에 있던 나머지 원반들을 모두 3번째로 옮겨야한다.
*/