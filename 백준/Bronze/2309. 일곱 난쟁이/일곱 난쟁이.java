import java.util.Arrays;
import java.util.Scanner;

// https://propercoding.tistory.com/28
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] height = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }

        // 원리 : 난쟁이 2명씩 골라서 도합 100이 되는 경우를 찾음
        // i가 7이면 j는 8 즉, 자연스럽게 마지막 2개를 선택하게됨
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - height[i] - height[j] == 100) {
                    height[i] = 0;
                    height[j] = 0;
                    Arrays.sort(height);
                    // k=0,1은 오름차순대로 0이므로 제외
                    for (int k = 2; k < 9; k++) {
                        sb.append(height[k]).append('\n');
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }

    }
}
