import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int lastCard = queue.poll();

            if (queue.isEmpty()) {
                System.out.println(lastCard);
                break;
            }

            int topCard = queue.poll();
            
            queue.offer(topCard);
        }
    }
}
