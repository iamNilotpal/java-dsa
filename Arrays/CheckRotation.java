public class CheckRotation {

    private static int checkRotation(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return array.length - i - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 4, 6, 9, 10, 11, 15, 1, 2, 3 };
        System.out.println(checkRotation(array));
    }
}
