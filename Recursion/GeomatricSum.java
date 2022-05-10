public class GeomatricSum {

    private static double geomatricSum(int n){
        if (n == 0)
            return 1;
        return (1 / Math.pow(2, n)) + geomatricSum(n-1);
    }

    public static void main(String[] args) {
        System.out.println(geomatricSum(3));
    }
}
