import java.util.Scanner;

public class NumberOfDigits {

    private static int numDigit(int n) {
        if (n / 10 == 0)
            return 1;
        return 1 + numDigit(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numDigit(n));
        sc.close();
    }
}
