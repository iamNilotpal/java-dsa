public class SumOfDigits {

    private static int sumOfDigits(int n){
        if (n/10 == 0)
            return n;

        int sum = n % 10;
        sum += sumOfDigits(n/10);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(1019));
    }
}
