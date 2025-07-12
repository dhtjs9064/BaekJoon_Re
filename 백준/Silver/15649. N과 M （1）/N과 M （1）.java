import java.util.Scanner;

public class Main {
    static boolean[] visit;
    static int[] arr, perm;
    // 수 범위
    static int N;
    // 수열 길이
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        // arr배열의 방문을 표시하는 용도
        visit = new boolean[N];
        arr = new int[N];
        perm = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(perm[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                perm[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
