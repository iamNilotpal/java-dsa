import java.util.Scanner;

public class PrintNumber {

    private static void printNum(int si, int n) {
        if (si == n) {
            System.out.print(n);
            return;
        }

        System.out.print(si + " ");
        printNum(si + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNum(1, n);
        sc.close();
    }
}
