import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] words = new String[count];

        for (int i = 0; i < count; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (e1, e2) -> {
            // 길이가 같으면 단어 사전 비교
            if (e1.length() == e2.length()) {
                return e1.compareTo(e2);
                // 길이가 다르면 짧은 순
            } else {
                return e1.length() - e2.length();
            }
        });

        StringBuilder sb = new StringBuilder();

        // Arrayindexoutofboundsexception 방지
        System.out.println(words[0]);

        for (int i = 1; i < count; i++) {
            // 중복 제거
            if(!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
