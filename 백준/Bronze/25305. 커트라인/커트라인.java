import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int candidate = in.nextInt();
        int winner = in.nextInt();

        int[] score = new int[candidate];

        for (int i = 0; i < score.length; i++) {
            score[i] = in.nextInt();
        }

        Arrays.sort(score);

        System.out.println(score[candidate - winner]);
    }
}
