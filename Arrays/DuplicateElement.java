import java.util.Arrays;

public class DuplicateElement {

    private static int duplicateElement(int[] array){
        Arrays.sort(array);
        for (int i = 0; i < array.length-1; i++){
            if (array[i] == array[i+1])
                return array[i];
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] array = { 10, 2, 1, 7, 4, 10, 90 };
        System.out.println(duplicateElement(array));
    }
}
