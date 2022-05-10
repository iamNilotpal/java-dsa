import java.util.Arrays;

public class RotateArray {

//    This is an unoptimized solution
    private static void rotateArray(int[] array, int d){
        int[] temp = new int[d];
        for (int i = 0; i < d; i++)
            temp[i] = array[i];

        for (int i = d; i < array.length; i++)
            array[i - d] = array[i];

        int k = 0;
        for (int i = array.length - d; i < array.length; i++)
            array[i] = temp[k++];
    }

//    This part is optimized solution
    private static void rotateArrayOptimized(int[] array, int d){
        if (array.length < d)
            return;

        reverseArray(array, 0, array.length-1);
        reverseArray(array, 0, array.length - d - 1);
        reverseArray(array, array.length - d, array.length-1);
    }

    private static void reverseArray(int[] array, int si, int ei){
        while(si <= ei){
            int temp = array[si];
            array[si] = array[ei];
            array[ei] = temp;
            si++;
            ei--;
        }
    }

    public static void main(String[] args){
        int[] array = { 4, 9, 8, 3, 2, 6, 1, 5 };
//        rotateArray(array, 3);
        rotateArrayOptimized(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
