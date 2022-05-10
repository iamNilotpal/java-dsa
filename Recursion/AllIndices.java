public class AllIndices {

    private static void printIndices(int[] array, int si, int x){
        if (si > array.length-1)
            return;

        if (array[si] == x)
            System.out.print(si + " ");
        printIndices(array, si+1, x);
    }

    public static void main(String[] args) {
        int[] array = { 3, 1, 2, 3, 3, 4, 5, 6, 6, 5 };
        printIndices(array, 0, 3);
    }
}
