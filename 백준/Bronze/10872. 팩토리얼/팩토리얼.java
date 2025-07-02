import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 재귀 함수 + 객체 지향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        Factorial fac = new Factorial();
        System.out.println(fac.factorial(number));
    }
}

class Factorial {
    public int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        // 현재 함수가 값을 반환하기만 하므로 굳이 누적시키지 않아도 되므로 *=를 쓰지 않아도 됨
        return number * factorial(number - 1);
    }
}
/*    // 재귀를 사용했을 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());


        System.out.println(factorial(number));
    }

     public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number *= factorial(number - 1);
    }*/
/*
    // 재귀를 사용하지 않았을 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int sum = number;
        for (int i = 1; i < number; i++) {
            sum *= number - i;
        }
        if (number == 0) {
            sum = 1;
        }
        System.out.println(sum);
    }*/