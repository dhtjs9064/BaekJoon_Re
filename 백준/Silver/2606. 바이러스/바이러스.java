import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> computer = new HashSet<>();
    static List<Integer>[] computerPair;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        computerPair = new ArrayList[count + 1];

        // 각 배열의 리스트 초기화
        for (int i = 1; i <= count; i++) {
            computerPair[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            computerPair[first].add(second);
            computerPair[second].add(first);
        }

        visited = new boolean[count + 1];
        dfs(1);

        computer.remove(1);

        System.out.println(computer.size());
    }

    static void dfs(int com) {

        if (!visited[com]) {
            for (int next : computerPair[com]) {
                computer.add(next);
                visited[com] = true;
                dfs(next);
            }
        }
    }
}


// 인접리스트로 각 노드 연결 가능
// DFS로 탐색?