public class FirstIndex {

    private static int firstIndex(int[] array, int si, int x){
        if (si > array.length-1)
            return -1;

        if (array[si] == x)
            return si;
        else
            return firstIndex(array, si+1, x);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 6 };
        System.out.println(firstIndex(array, 0, 6));
    }
}
