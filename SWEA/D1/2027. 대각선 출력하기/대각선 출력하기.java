public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    System.out.print("#");
                }
                System.out.print("+");
            }
            if (i == 4) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
