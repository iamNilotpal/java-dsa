public class SumOfArray {

    private static int sum(int[] array, int si){
        if (si == array.length-1)
            return array[si];

        int sum = array[si];
        sum += sum(array, si+1);
        return sum;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        System.out.println(sum(array, 0));
    }
}
