import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 참고 : https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-18352-%ED%8A%B9%EC%A0%95-%EA%B1%B0%EB%A6%AC%EC%9D%98-%EB%8F%84%EC%8B%9C-%EC%B0%BE%EA%B8%B0-java
public class Main {

    static boolean[] visited;
    static int N;
    static int K;
    static List<Integer>[] edges;
    // 거리를 모르거나 무한대 = -1
    static int INF = -1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로(간선) 개수
        K = Integer.parseInt(st.nextToken()); // 최단 거리
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        edges = new ArrayList[N + 1];

        // 배열 리스트 초기화
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        // 단방향 간선 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }

        bfs(X);
        System.out.println(sb);
    }

    static void bfs(int X) {
        // 삽입, 삭제가 필요 없으므로 arraydeque사용
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);

        // 각 정점마다 가진 간선의 거리
        int[] dist = new int[N + 1];
        // 방문 전 모두 초기화
        Arrays.fill(dist, INF);
        // 초기 노드는 시작이므로 0
        dist[X] = 0;

        LinkedList<Integer> answer = new LinkedList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();

            // K를 넘으면 더이상 볼 필요 없으니 종료
            if (dist[cur] > K) {
                break;
            }
            // 거리가 K가 되면 그 도시번호를 추가
            if (dist[cur] == K) {
                answer.add(cur);
            }

            // 방문 안했을경우
            for (int next : edges[cur]) {
                // 이전에 방문했으면 이미 최단거리가 아니니까 넘어감
                if (dist[next] != INF) {
                    continue;
                }
                // 그 다음 노드에 현재거리 + 1
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        // 오름차순 정렬
        Collections.sort(answer);
        if (answer.isEmpty()) {
            sb.append(INF);
        } else {
            for (int city : answer) {
                sb.append(city).append('\n');
            }
        }


    }
}
