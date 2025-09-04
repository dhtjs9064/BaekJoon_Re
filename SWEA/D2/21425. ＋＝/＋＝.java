import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int count = 0;

            int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();

            while (A <= N && B <= N) {
                if (A <= B) {
                    A += B;
                } else {
                    B += A;
                }

                count++;
            }

            System.out.println(count);
        }
    }
}
