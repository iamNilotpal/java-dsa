import java.util.Scanner;

public class Multiplication {

    private static int multiplication(int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        return n + multiplication(n, m - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(multiplication(n, m));
        sc.close();
    }
}
