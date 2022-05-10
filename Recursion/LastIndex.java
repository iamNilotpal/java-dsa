public class LastIndex {

    private static int lastIndex(int[] array, int ei, int x){
        if (ei < 0)
            return -1;

        if (array[ei] == x)
            return ei;
        else
            return lastIndex(array, ei-1, x);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 3, 4, 5, 6, 6, 5 };
        System.out.println(lastIndex(array, array.length-1, 3));
    }
}
