
import java.util.Arrays;

public class UniqueElement {

    private static int uniqueElement(int[] array){
        Arrays.sort(array);
        for (int i = 0; i < array.length-1; i += 2){
            if (array[i] != array[i+1])
                return array[i];
        }
        return Integer.MIN_VALUE;
    }

    private static int uniqueElementOptimized(int[] array){
        int ans = 0;
        for (int i = 0; i < array.length; i++)
            ans = ans ^ array[i];
        return ans;
    }

    public static void main(String[] args) {
        int[] array = { 3, 1, 5, 3, 1, 98, 6, 6, 98 };
//        System.out.println(uniqueElement(array));
        System.out.println(uniqueElementOptimized(array));
    }
}
