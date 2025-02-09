import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // -1,000,000부터 1,000,000까지의 수 (배열은 음수를 가질 수 없음)
        boolean[] arr = new boolean[2000001];

        int N = Integer.parseInt(br.readLine());

        // 입력값 처리
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true; // 해당 값의 인덱스를 true로 설정
        }

        // 0부터 확인하면서 true인 값만 출력 (주어진 범위에 맞게 다시 백만을 뺌)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                sb.append(i - 1000000).append('\n');
            }
        }
        System.out.print(sb);
    }
}
