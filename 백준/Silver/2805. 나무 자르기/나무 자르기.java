import java.util.Scanner;

public class Main {
    // 최선으로 자를 수도 있겠지만 어쩔 수 없이 최악으로 자를 수도 있음 = 이분 탐색 적절

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] tree = new int[N];

        // 각각 나무가 10억이 넘어가면 int범위가 초과하므로 long
        // 절단기 최대 길이
        long max = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        // 나무 길이가 1이어도 절단기는 0이어야 잘리니 필요없음
/*        max++;*/

        //절단기 최소 길이
        long min = 0;
        //절단기 중간 길이
        long mid = 0;

        // 구해야하는것 : 절단기 길이
        while (min < max) {
            // 절단기 중간 길이
            mid = (min + max) / 2;

            // 잘린 길이
            long cutLength = 0;

            for (int i = 0; i < tree.length; i++) {
                if (mid < tree[i]) {
                    cutLength += tree[i] - mid;
                }
            }

            // 잘린길이가 잘라야하는 길이보다 작음 = 더 많이 잘라야함 = 절단기의 길이를 줄여야 더 많이 잘림
            if (cutLength < M) {
                max = mid;
            } else {
                // 그 외 = 너무 많이 자름 = 절단기 길이를 늘려 적게 잘라야함
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
