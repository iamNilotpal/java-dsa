import java.util.Arrays;

public class HeapSort {

    private static void insertIntoHeap(int i, int[] array) {
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;
        array[i] = array[childIndex];

        while (childIndex > 0) {
            if(array[childIndex] > array[parentIndex]) {
                int temp = array[childIndex];
                array[childIndex] = array[parentIndex];
                array[parentIndex] = temp;

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else
                return;
        }
    }

    private static int removeFromHeap(int[] array, int size) {
        int removedElem = array[0];
        size--;
        array[0] = array[size];

        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < size) {
            int maxIndex = parentIndex;

            if(array[leftChildIndex] > array[maxIndex])
                maxIndex = leftChildIndex;

            if(rightChildIndex < size && array[rightChildIndex] > array[maxIndex])
                maxIndex = rightChildIndex;

            if(maxIndex == parentIndex)
                break;

            int temp = array[maxIndex];
            array[maxIndex] = array[parentIndex];
            array[parentIndex] = temp;

            parentIndex = maxIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return removedElem;
    }

//    public static void heapSort(int[] array) {
//        for (int i = 0; i < array.length; i ++) {
//            int childIndex = i;
//            int parentIndex = (childIndex - 1) / 2;
//
//            while(childIndex > 0) {
//                if(array[childIndex] > array[parentIndex]) {
//                    int temp = array[childIndex];
//                    array[childIndex] = array[parentIndex];
//                    array[parentIndex] = temp;
//
//                    childIndex = parentIndex;
//                    parentIndex = (childIndex - 1) / 2;
//                }
//                else
//                    break;
//            }
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            int parentIndex = 0;
//            int leftChildIndex = 1;
//            int rightChildIndex = 2;
//
//            int temp = array[0];
//            array[0] = array[array.length - 1 - i];
//            array[array.length - i - 1] = temp;
//
//            while (leftChildIndex < array.length - 1) {
//                int maxIndex = parentIndex;
//
//                if(array[maxIndex] < array[leftChildIndex])
//                    maxIndex = leftChildIndex;
//
//                if(array[rightChildIndex] > array[maxIndex])
//                    maxIndex = rightChildIndex;
//
//                if(maxIndex == parentIndex)
//                    break;
//
//                int max = array[maxIndex];
//                array[maxIndex] = array[parentIndex];
//                array[parentIndex] = max;
//
//                parentIndex = maxIndex;
//                leftChildIndex = 2 * parentIndex + 1;
//                rightChildIndex = 2 * parentIndex + 2;
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] array = {9, 10, 1, 3, 8, 0, 3, 4, 13, 11, 7, 2, 19};

        for (int i = 0; i < array.length; i++)
            insertIntoHeap(i, array);

        for (int i = 0; i < array.length; i++)
            array[array.length - i - 1] = removeFromHeap(array, array.length - i);

        System.out.println(Arrays.toString(array));
    }
}
