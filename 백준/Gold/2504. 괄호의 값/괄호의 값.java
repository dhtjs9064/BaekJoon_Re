import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 참고 : https://ilmiodiario.tistory.com/27
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int tmp = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push('(');
                tmp *= 2;
            } else if (c == '[') {
                stack.push('[');
                tmp *= 3;
            } else if (c == ')') {
                // ex.([]) 이렇더라도 pop하면 (만 남기때문에 문제없음
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;

                } else {
                    if (s.charAt(i - 1) == '(') {
                        result += tmp;
                    }

                    tmp /= 2;
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;

                } else {
                    if (s.charAt(i - 1) == '[') {
                        result += tmp;
                    }

                    tmp /= 3;
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
// 1. result, tmp로 나눔
// 2. 여는 괄호가 나오면 곱셈 (분배법칙)
// 3. 닫는 괄호가 나오면 직전 괄호가 여는 괄호인지 확인 후 맞다면 result에 더함 아니면 더하지 않음
// 4. 동시에 tmp는 그 괄호의 수(2or 3)만큼 나눔