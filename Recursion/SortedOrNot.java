public class SortedOrNot {

    private static boolean sorted(int[] array, int si){
        if (array.length < 2 || si >= array.length-1)
            return true;

        if (array[si] > array[si+1])
            return false;

        return sorted(array, si+1);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        System.out.println(sorted(array, 0));
    }
}
