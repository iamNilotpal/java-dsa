import java.util.Arrays;

public class SecondLargest {

    private static int secondLargestOptimized(int[] array){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int j : array) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j > secondLargest && j < largest)
                secondLargest = j;
        }
        return secondLargest;
    }

    private static int secondLargest(int[] array){
        Arrays.sort(array);
        return array[array.length - 2];
    }

    public static void main(String[] args) {
        int[] array = { 4, 9, 8, 3, 2, 6, 1, 5, 4};
        System.out.println(secondLargestOptimized(array));
        System.out.println(secondLargest(array));
    }
}
