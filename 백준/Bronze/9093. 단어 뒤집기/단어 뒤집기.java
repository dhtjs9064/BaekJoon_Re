import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] words = br.readLine().split(" ");
            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                // sout내부에서 toString()을 자동으로 호출하지만 가독성을 위해 씀
                System.out.print(sb.reverse().toString() + " ");
            }
            System.out.println();
        }
    }
}
