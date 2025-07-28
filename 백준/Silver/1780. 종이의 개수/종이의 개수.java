import java.util.Scanner;

public class Main {
    static int negative = 0;
    static int zero = 0;
    static int positive = 0;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        triplePartition(0, 0, N);

        System.out.println(negative);
        System.out.println(zero);
        System.out.println(positive);
    }

    static void triplePartition(int x, int y, int size) {

        // 1. 다 같은 부호인지 체크
        // 2. 더 이상 나누지 못하더라도 여기서 해결됨
        if(dataCheck(x, y, size)) {
            if(arr[x][y] == -1) {
                negative++;
            } else if(arr[x][y] == 0) {
                zero++;
            } else {
                positive++;
            }
            return;
        }

        int dividedSize = size / 3;

        triplePartition(x, y, dividedSize); // 1구역
        triplePartition(x, y + dividedSize, dividedSize); // 2구역
        triplePartition(x, y + dividedSize * 2, dividedSize); // 3구역
        triplePartition(x + dividedSize, y, dividedSize); // 4구역
        triplePartition(x + dividedSize, y + dividedSize, dividedSize); // 5구역
        triplePartition(x + dividedSize, y + dividedSize * 2, dividedSize); // 6구역
        triplePartition(x + dividedSize * 2, y, dividedSize); // 7구역
        triplePartition(x + dividedSize * 2, y + dividedSize, dividedSize); // 8구역
        triplePartition(x + dividedSize * 2, y + dividedSize * 2, dividedSize); // 9구역
    }

    static boolean dataCheck(int x, int y, int size) {
        int firstData = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != firstData) {
                    return false;
                }
            }
        }

        return true;
    }
}
