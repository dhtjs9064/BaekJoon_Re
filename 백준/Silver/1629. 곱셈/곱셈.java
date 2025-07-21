import java.util.Scanner;

// B번만큼 곱하면 n^3를 넘어서는 최악의 알고리즘이 됨
// BigInteger를 쓰면 너무 커서 오버플로우 발생
// https://st-lab.tistory.com/237
// -> 지수법칙, 모듈러 연산 사용
public class Main {
    static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(pow(A, B));
    }

    static long pow(long A, long exponent) {


        if (exponent == 1) {
            return A % C;
        }

        // 지수법칙 사용
        long temp = pow(A, exponent / 2);

        // 만약 지수가 홀수라면
        // 모듈러 연산 사용
        // ex. A^9 = A^4 * A^4 * A 임
        if (exponent % 2 == 1) {
            return ((temp * temp % C) * (A % C)) % C;
        }

        // 계속 지수를 반으로 나눈 값을 구하게 된다
        // temp * temp = 2^31-1보다 작기에 모듈러를 굳이 안써도됨
        return (temp % C * temp % C) % C;

    }
}
