import java.util.Scanner;

public class Main {
    static boolean[] visit;
    static int[] perm;
    static int[] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N];
        perm = new int[N];
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == N) {
            for (int i = 0; i < N; i++) {
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
