import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고 : https://st-lab.tistory.com/143
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 오름차순으로 주어진다고 했고 큰 지폐먼저 골라야하므로 뒤에서부터 찾음
        for (int i = coin.length - 1; i >= 0; i--) {
            if(coin[i] <= K) {
                // 그 지폐 개수만큼 추가
                count += K / coin[i];
                // 거스름돈을 다시 넣고 탐색
                K %= coin[i];
            }
        }

        System.out.println(count);
    }
}
