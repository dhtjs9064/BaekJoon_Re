import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] house = new int[N];

        // 공유기 최대 거리
        int max = 0;

        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
            if (max < house[i]) {
                max = house[i];
            }
        }

        // 거리 1 방지
        max++;
        
        // 가장 앞집부터 차례대로 설치할꺼니까 정렬 필요
        Arrays.sort(house);
        // 공유기 최소 거리
        int min = 0;

        while (min < max) {
            // 공유기 설치 간격
            int mid = (min + max) / 2;
            int count = 1;
            int lastLocate = house[0];

            for (int i = 1; i < house.length; i++) {
                int locate = house[i];
                if (locate - lastLocate >= mid) {
                    lastLocate = locate;
                    count++;
                }
            }
            
            // 설치를 적게함 = 간격을 길게 잡음 = 간격을 줄여야함
            if(count < C) {
                max = mid;
                // 설치를 같거나 많이함 = 간격을 적게 잡음 = 간격을 늘려야함
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
