import java.util.Scanner;

public class Main {
    static long max = 0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int neededLine;
        arr = new int[K];
        neededLine = sc.nextInt();

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(binarySearch(neededLine));
    }
    static int binarySearch(int neededLine) {
        long min = 0;
        long mid = 0;

        // max 0 방지
        max++;
        
        while (min < max) {

            mid = (min + max) / 2;

            long count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            // max 줄이기
            if(count < neededLine) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int) min - 1;
    }
}
