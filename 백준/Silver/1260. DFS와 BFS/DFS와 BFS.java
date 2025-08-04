import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 참고 : ChatGPT
public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 그래프 입력
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 번호

        // 2. 그래프 리스트 초기화
        // 1번부터 할거니까 N + 1
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 3. 간선 정보로 연결 -> 인접 리스트 사용
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            graph[second].add(first);
        }

        // 4. 각 정점 리스트 정렬 (정점이 작은 것 먼저 방문하라고 했으므로)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 5. 방문 배열 초기화하고 DFS
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(sb);

        // 6. 방문 배열 초기화하고 BFS
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    // 재귀를 사용한 dfs
    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(' ');

        for (int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    // 큐를 사용한 bfs
    static void bfs(int node) {
        sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        visited[node] = true;
        q.offer(node);

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(' ');

            for (int next : graph[num]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}

// 설계 :
// 1. 그래프 입력 받기
// 2. 그래프 리스트 초기화
// 3. 간선 정보로 연결
// 4. 정점 리스트 정렬
// 5. 방문 배열 초기화하고 DFS
// 6. 방문 배열 초기화하고 BFS
