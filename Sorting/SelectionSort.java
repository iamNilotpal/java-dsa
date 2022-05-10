import java.util.Arrays;

public class SelectionSort {

    private static void selectionSort(int[] array){
        for (int i = 0; i < array.length-1; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++){
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 23, 3, 7, 1, 56, 9 };
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
