import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String word = br.readLine();

        boolean tag = false;

        for (int i = 0; i < word.length(); i++) {
            // 3. '<'가 들어오면 태그모드로 전환
            if (word.charAt(i) == '<') {
                tag = true;
                // 3-1. 그 전까지 push한 값들을 pop후 저장
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                //3-2. '<'는 그대로 따로 저장
                sb.append(word.charAt(i));
                // 5. '>'가 들어오면 태그 모드 해제
            } else if (word.charAt(i) == '>') {
                tag = false;
                // 5-1. '>'는 그대로 따로 저장
                sb.append(word.charAt(i));
                // 4. 태그 모드일때는 그대로 출력
            } else if (tag == true) {
                sb.append(word.charAt(i));
                // 6. 태그 모드가 아닐때
            } else if (tag == false) {
                // 1. (공백이 들어오면 + tag가 아닐때)
                if (word.charAt(i) == ' ') {
                    // 1-1.그전까지 쌓아둔 stack 전부 출력
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    // 1-2.그 공백은 따로 저장함
                    sb.append(word.charAt(i));
                    // 2. 공백이 아니면 그대로 stack에 push ((공백이 들어올때 + tag가 아닐때) 전부 출력하니까 문제없음)
                } else {
                    stack.push(word.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
// 규칙 : "<"가 오면 ">"가 올때까지 단어를 뒤집지 않는다 끝나면 계속 뒤집는다
/* 핵심 : 
1. charAt()으로 하나하나 검사하는 방식
2. stack을 활용해서 거꾸로 출력하는 방식
3. tag로 구분하는 방식
 */