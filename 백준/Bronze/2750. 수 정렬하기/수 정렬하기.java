import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        // 수를 담을 배열 (정렬 시 필요함)
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = in.nextInt();
        }

        Arrays.sort(numbers);

        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
