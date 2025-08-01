import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            switch (sc.nextInt()) {
                case 1:
                    stack.push(sc.nextInt());
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    } else {
                        sb.append(-1);
                    }

                    sb.append('\n');
                    break;

                case 3:
                    sb.append(stack.size());
                    sb.append('\n');
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append('\n');
                    break;

                case 5:
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek());
                    } else {
                        sb.append(-1);
                    }
                    sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
