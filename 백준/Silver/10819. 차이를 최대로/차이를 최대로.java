import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] visit;
    static int[] num;
    static int[] perm;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visit = new boolean[N];
        num = new int[N];
        perm = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth) {
        if(depth == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(perm[i - 1] - perm[i]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                perm[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}

// 1. 최대값 구하기
/*
        int max = 0;
        int sum = 0;

        for (int i = 1; i < n; i++) {
        sum += Math.abs(arr[k - 1] - arr[k]);
        }
        if (max < sum) {
           max = sum;
        }*/

// 2. 순서 바꾸기
/*
        int term = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
        term = j;
        j = i;
        i = term;
        } -> 불가 */
