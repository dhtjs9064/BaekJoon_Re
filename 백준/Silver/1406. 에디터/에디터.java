import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String initial = br.readLine();
        int count = Integer.parseInt(br.readLine());

        Stack<String> left_stack = new Stack<>();
        Stack<String> right_stack = new Stack<>();

        String[] str = initial.split("");
        for (String s: str) {
            left_stack.push(s);
        }

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L" :
                    if(!left_stack.empty()) {
                        right_stack.push(left_stack.pop());
                    }
                    continue;
                case "D" :
                    if(!right_stack.empty()) {
                        left_stack.push(right_stack.pop());
                    }
                    continue;
                case "B" :
                    if(!left_stack.empty()) {
                        left_stack.pop();
                    }
                    continue;
                case "P" :
                    left_stack.push(st.nextToken());
            }
        }

        while (!left_stack.empty()) {
            right_stack.push(left_stack.pop());
        }

        while (!right_stack.empty()) {
            sb.append(right_stack.pop());
        }
        
        System.out.println(sb);
    }
}
// P = push