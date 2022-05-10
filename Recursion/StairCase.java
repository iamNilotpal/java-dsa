public class StairCase {

    private static int stairCase(int n){
        if (n <= 0)
            return n;
        int smallAns1 = stairCase(n-1);
        int smallAns2 = stairCase(n-2);
        int smallAns3 = stairCase(n-3);
        return smallAns1 + smallAns2 + smallAns3;
    }

    public static void main(String[] args) {
        System.out.println(stairCase(5));
    }
}
