import java.util.Arrays;

public class PushZeros {

    private static void pushZerosToEnd(int[] array){
        int nextZeroPos = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != 0){
                int temp = array[i];
                array[i] = array[nextZeroPos];
                array[nextZeroPos] = temp;
                nextZeroPos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 0, 12, 33, 1, 0, 0, 3, 5, 0, 1, 0 };
        pushZerosToEnd(array);
        System.out.println(Arrays.toString(array));
    }
}
