import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int value = sc.nextInt();

            if (value == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append('\n');
            } else {
                pq.offer(value);
            }
        }

        System.out.println(sb);
    }
}
