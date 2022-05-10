import java.util.Arrays;

public class ArrayIntersection {

    private static void arrayIntersection(int[] array1, int[] array2){
        for (int i = 0; i < array1.length; i++){
            for (int j = 0; j < array2.length; j++){
                if (array1[i] == array2[j])
                    System.out.print("(" + array1[i] + "," + array2[j] + ")" + ", ");
            }
//            System.out.println();
        }
    }

    private static void arrayIntersectionOptimized(int[] array1, int[] array2){
        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0, j = 0;
        while (i < array1.length && j < array2.length){
            if (array1[i] > array2[j])
                j++;
            else if(array2[j] > array1[i])
                i++;
            else {
                System.out.print("(" + array1[i] + "," + array2[j] + ")" + ", ");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args){
        int[] array1 = { 2, 1, 7, 4, 3 };
        int[] array2 = { 4, 9, 8, 3, 1 };

//        arrayIntersection(array1, array2);
        arrayIntersectionOptimized(array1, array2);
    }
}
