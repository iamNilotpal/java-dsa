import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] array, int si, int ei){
        int pivot = array[si];
        int count = 0;
        for (int i = si+1; i <= ei; i++){
            if (array[i] < pivot)
                count++;
        }

        int pivotIndex = si + count;
        array[si] = array[pivotIndex];
        array[pivotIndex] = pivot;

        int i = si;
        int j = ei;

        while(i < pivotIndex && ei > pivotIndex){
            if (array[i] <= pivot)
                i++;
            else if(array[j] > pivot)
                j--;
            else{
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    private static void quickSort(int[] array, int si, int ei){
        if (si >= ei)
            return;

        int pivot = partition(array, si, ei);
        quickSort(array, si, pivot-1);
        quickSort(array, pivot+1, ei);
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 86, 23, 3, 7, 1, 56, 9 };
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
