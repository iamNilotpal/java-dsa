import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j] > array[j+1])
                    swap(array, j, j+1);
            }
        }
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 876, 23, 3, 7, 1, 56, 9 };
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
