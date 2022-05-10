import java.util.Scanner;

public class Pattern_3 {
    public static void printPattern1(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(i + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void printPattern2(int n) {
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(j + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void printPattern3(int n) {
        int i = 1;
        while (i <= n) {
            int j = n;
            while (j > 0) {
                System.out.print(j + " ");
                j--;
            }
            System.out.println();
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern1(n);
        System.out.println();
        printPattern2(n);
        System.out.println();
        printPattern3(n);
    }
}
