import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String word[] = new String[N];

        // 단어 입력
        for (int i = 0; i < word.length; i++) {
            word[i] = br.readLine();
        }

        // 단어 길이 비교
        Arrays.sort(word, (e1, e2) -> {
            if(e1.length() == e2.length()) {
                return e1.compareTo(e2);
            } else {
                return e1.length() - e2.length();
            }
        });

        // 단어 중복 방지
        for (int i = 0; i < word.length - 1; i++) {
            // 정렬된 상태이므로 앞 뒤 비교 가능
            if(!word[i].equals(word[i + 1])) {
                sb.append(word[i]).append('\n');
            }
        }
        System.out.println(sb + word[N - 1]);
    }
}
