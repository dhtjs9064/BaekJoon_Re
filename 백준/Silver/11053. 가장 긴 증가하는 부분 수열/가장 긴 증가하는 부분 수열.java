import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[] arr;

    // 방법 2 : 이분탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }

    // 이분탐색
    static int binarySearch() {
        int[] lis = new int[N];

        // 이분탐색을 위해 앞 원소를 넣고 시작
        lis[0] = arr[0];
        // 최소 0~1탐색이 가능하므로 1로 초기화
        int idx = 1;
        for (int i = 1; i < N; i++) {
            // 뒷 원소가 앞 원소보다 크면
            if(lis[idx - 1] < arr[i]) {
                // 그대로 뒤에 추가
                lis[idx++] = arr[i];
                // 맨 앞 원소가 뒷 원소보다 큰 상황이면
            } else if (lis[0] > arr[i]) {
                // 맨 앞 원소는 작아야 최장 길이가 될 확률이 높으므로 교체
                lis[0] = arr[i];
            } else {
                // 0~idx범위 내에서 arr[i]값이 있는지 찾기 (자리 탐색)
                int temp = Arrays.binarySearch(lis, 0, idx, arr[i]);
                // temp가 음수가 나오면 그 앞자리에 넣어야하니까 반환값 특성을 이용해 반대로 해서 넣음
                // 양수가 나왔다는 뜻은 그 자리에 같은 값이 있다는 것이니까 그대로 덮어씌움
                lis[temp < 0 ? -(temp + 1) : temp] = arr[i];
            }
        }

        // idx는 끝 범위이므로 전체 길이를 의미하니까 그대로 반환
        return idx;
    }
}

// 방법 1 : DP
/* static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(lis());
    }

    static int lis() {
        // 각 원소마다 가지는 최장 길이
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            // 1(자기자신) 초기화
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 뒷 원소가 앞 원소보다 크다면
                if (arr[i] > arr[j]) {
                    // 최장 길이를 구하는데 이때, 가장 큰 최장 길이만 남겨놓도록함
                    // dp[j]는 이전 최장 길이를 뜻함 여기에 앞 조건이 맞다면 자기 자신의 원소도 붙일 수 있으므로 +1
                    // 근데 dp[i]가 만약에 더 크다면 이전 최장 길이와 지금 원소를 합쳐도 적다는 뜻이니까 dp[i]길이로 유지
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int j : dp) {
            max = Math.max(max, j);
        }

        return max;
    }*/