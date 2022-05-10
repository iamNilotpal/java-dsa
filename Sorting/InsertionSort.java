import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int j = i - 1;
            int temp = array[i];
            while(j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 86, 23, 3, 7, 1, 56, 9 };
        insertionSort(array);
        System.out.println(Arrays.toString(array));

//        for (int n = 10; n < 1000000000; n *= 10){
//            int[] array = new int[n];
//
//            for (int i = 0; i < n; i++)
//                array[i] = array.length - i;
//
//            long start = System.currentTimeMillis();
//            insertionSort(array);
//            long end = System.currentTimeMillis();
//            System.out.println("Time taken for input size " + n + " is " + (end - start));
//        }
    }
}
