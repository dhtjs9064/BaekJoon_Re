import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[][] member = new String[count][2];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            member[i][0] = st.nextToken();
            member[i][1] = st.nextToken();
        }

        Arrays.sort(member, Comparator.comparingInt(e -> Integer.parseInt(e[0])));


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(member[i][0]).append(" ").append(member[i][1]).append('\n');
        }

        System.out.println(sb);
    }
}
