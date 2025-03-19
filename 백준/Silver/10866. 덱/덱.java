import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 1~10000이라 했으니 배열의 개수는 10000개가 되어야함
    public static int[] deque = new int[10000];
    public static int front = 0;
    public static int back = 0;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push_front(int item) {
        deque[front] = item;
        front = ((front - 1) + 10000) % 10000;
        size++;
    }

    public static void push_back(int item) {
        back = (back + 1) % 10000;
        deque[back] = item;
        size++;
    }

    // +) 이미 return 으로 함수를 종료시키기 때문에 else가 필요없음
    public static int pop_front() {
        if (size == 0) {
            return -1;
        }
        front = (front + 1) % 10000;
        int front_res = deque[front];
        size--;
        return front_res;
    }

    public static int pop_back() {
        if (size == 0) {
            return -1;
        }
        int back_res = deque[back];
        back = ((back - 1) + 10000) % 10000;
        size--;
        return back_res;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }

    public static int front() {
        if (size == 0) {
            return -1;
        }
        return deque[(front + 1) % 10000];
    }

    public static int back() {
        if (size == 0) {
            return -1;
        }
        return deque[back];
    }
}
