import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int[] number = new int[10001];

        // 입력이 오면 각 배열의 인덱스마다 개수를 세서 넣음
        for (int i = 0; i < count; i++) {
            number[Integer.parseInt(br.readLine())]++;
        }

        // 해당 인덱스의 값은 개수가 0이 될때까지 다른 저장소에 그 값을 저장함
        for (int i = 1; i < 10001; i++) {
            // ex) number[5] = 5가 입력때 있었다는 뜻 -> 개수가 0이 될 때까지 계속 저장
            // 이때 sb.append 특성상 자동으로 빈 옆칸에 저장하므로 저장소를 ++ 안해도됨
            while (number[i] > 0) {
                sb.append(i).append("\n");
                number[i]--;
            }
        }
        System.out.println(sb);
    }
}
// 중복이 있어서 boolean 사용 불가