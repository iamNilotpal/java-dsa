public class CheckNumber {

    private static boolean checkNumber(int[] array, int si, int key){
        if (si > array.length-1)
            return false;

        if (array[si] == key)
            return true;
        else
            return checkNumber(array, si+1, key);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        System.out.println(checkNumber(array, 0, 5));
    }
}
