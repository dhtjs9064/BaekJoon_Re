import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고 : https://velog.io/@originxh/%EB%B0%B1%EC%A4%80-14940-%EC%89%AC%EC%9A%B4-%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC.Java
public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int goalX = 0;
        int goalY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    map[i][j] = 0;
                    goalX = i;
                    goalY = j;
                }
            }
        }

        visited = new boolean[n][m];
        bfs(goalX, goalY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1).append(' ');
                    continue;
                }
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                // 가려는 범위를 벗어나면 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                
                // 방문했거나 다음가려는 곳이 0이면(막혀있으면) 건너뛰기
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                visited[nextX][nextY] = true;
                q.offer(new Node(nextX, nextY));

                map[nextX][nextY] = map[now.x][now.y] + 1;
            }
        }
    }
}

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// 0. 모든 노드를 방문, 최단 거리 문제이므로 BFS사용
// (이중 for문을 쓰더라도 n값이 작으므로 문제x)
// 1. 거리를 더하면서 출력노드 저장
// 2. 0을 만나면 그대로 0 저장
// + 상하좌우 쓰기

