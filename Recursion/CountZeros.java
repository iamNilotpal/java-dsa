public class CountZeros {

    private static int countZeros(int n){
        if (n/10 == 0){
            if (n == 0)
                return 1;
            else
                return 0;
        }

        int count = 0;
        if (n % 10 == 0)
            count++;
        return count + countZeros(n/10);
    }

    public static void main(String[] args) {
        System.out.println(countZeros(1050));
    }
}
