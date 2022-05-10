
import java.util.Arrays;

public class Sort01 {

    private static void sort01(int[] array){
        int zero = 0;
        int one = 0;

        for (int i : array){
            if (i == 0)
                zero++;
            else
                one++;
        }
        int  k = 0;
        while(zero > 0){
            array[k] = 0;
            k++;
            zero--;
        }

        while(one > 0){
            array[k] = 1;
            k++;
            one--;
        }
    }

    private static void sort01Optimized(int[] array){
        int nextZeroPos = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == 0){
                int temp = array[i];
                array[i] = array[nextZeroPos];
                array[nextZeroPos] = temp;
                nextZeroPos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 1, 0, 0, 1, 0, 0, 1 };
        sort01(array);
//        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
    }
}
