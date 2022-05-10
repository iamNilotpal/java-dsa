import java.util.Arrays;

public class MergeSort {
    private static void mergeSort(int[] array, int si, int ei){
        if (si >= ei)
            return;

        int mid = (si + ei) / 2;
        mergeSort(array, si, mid);
        mergeSort(array, mid+1, ei);
        merge(array, si, ei);
    }

    private static void merge(int[] array, int si, int ei){
        int size = ei - si + 1;
        int mid = (si + ei) / 2;
        int[] output = new int[size];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= ei){
            if (array[i] <= array[j]){
                output[k] = array[i];
                i++;
            }
            else{
                output[k] = array[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            output[k] = array[i];
            i++;
            k++;
        }

        while(j <= ei){
            output[k] = array[j];
            j++;
            k++;
        }

        int l = 0;
        for (i = si; i <= ei; i++)
            array[i] = output[l++];
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 86, 23, 3, 7, 1, 56, 9 };
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

//        for (int n = 10; n < 1000000000; n *= 10){
//            int[] array = new int[n];
//
//            for (int i = 0; i < n; i++)
//                array[i] = array.length - i;
//
//            long start = System.currentTimeMillis();
//            mergeSort(array, 0, array.length-1);
//            long end = System.currentTimeMillis();
//            System.out.println("Time taken for input size " + n + " is " + (end - start) + "ms.");
//        }
    }
}
