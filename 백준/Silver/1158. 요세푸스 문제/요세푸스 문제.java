import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int person = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= person; i++) {
            queue.add(i);
        }

        sb.append('<');

        while (queue.size() > 1) {

            // (keypoint) 3번째 사람이 나올때까지 계속 꺼내서 뒷 자리로 집어넣음
            for (int i = 0; i < order - 1; i++) {
                int val = queue.poll();
                queue.offer(val);
            }

            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}
// 제거되고 다시 셀 때 제거된 다음 사람이 첫번째임