import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://st-lab.tistory.com/125
public class Main {
    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = -1;
        }

        System.out.println(Tile(N));
    }

    static int Tile(int N) {
        if (arr[N] == -1) {
            arr[N] = (Tile(N - 1) + Tile(N - 2)) % 15746;
        }
        return arr[N];
    }
}
// 규칙 : N = N-1 + N-2