import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] numbers = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            numbers[i] = in.nextInt();
            sum += numbers[i];
        }

        int average = sum / 5;

        Arrays.sort(numbers);

        System.out.println(average);
        System.out.println(numbers[2]);
    }
}
