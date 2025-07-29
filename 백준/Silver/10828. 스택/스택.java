import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// switch문으로 해결
// 각 문자열마다 기능이 있으므로 메서드 만들기
public class Main {
    static int[] stack;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        stack = new int[count];

        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void push(int x) {
        stack[size] = x;
        size++;
    }

    static int pop() {
        if (size == 0) {
            return -1;
        }

        int res = stack[size - 1];
        size--;
        return res;
    }

    static int size() {
        return size;
    }

    static int empty() {
        if (size == 0) {
            return 1;
        }

        return 0;
    }

    static int top() {
        if (size == 0) {
            return -1;
        }

        // top = peek 즉, 그 정수는 없앨 필요가 없음
        return stack[size - 1];
    }
}
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack.pop()).append('\n');
                    }
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack.peek()).append('\n');
                    }
            }

        }

        System.out.println(sb);
    }*/