import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();

        int[][] coordinate = new int[count][2];

        // 이중배열에서 각 x, y에 입력을 넣음
        for (int i = 0; i < count; i++) {
            coordinate[i][0] = in.nextInt();
            coordinate[i][1] = in.nextInt();
        }
        
        // 여기서 e1, e2 = 각각 (x1, y1)과 (x2, y2)를 동시에 비교하는 느낌
        // 조건은 {}에 따라 달라짐
        Arrays.sort(coordinate, (e1, e2) -> {
            // x좌표가 같으면 y값끼리 비교
            if(e1[0] == e2[0]) {
                // Math.max()같은 느낌
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < count; i++) {
            System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
        }
    }
}