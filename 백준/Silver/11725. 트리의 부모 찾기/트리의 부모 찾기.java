import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        // 1부터 체크
        graph = new ArrayList[N + 1];

        // 그래프 리스트 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 인접 리스트로 간선 연결
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            graph[second].add(first);
        }

        //최대 인덱스 7까지 있으므로


        visited = new boolean[N + 1];
        dfs(1,  0);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);
    }


    // dfs로 원하는 노드 찾기
    static void dfs(int node, int p) {
        visited[node] = true;
        parent[node] = p;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, node);
            }
        }
    }
}
/* 설계 :
1. 그래프 리스트 초기화
2. 인접 리스트로 간선 연결
3. dfs로 원하는 노드를 찾기
-> 각 층마다 방문 체크하고 visited-1일때 그 노드의 값 출력
*/