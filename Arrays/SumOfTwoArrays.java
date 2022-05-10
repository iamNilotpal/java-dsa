import java.util.Arrays;

public class SumOfTwoArrays {

    private static int[] sumOfArray(int[] array1, int[] array2){
        int size = array1.length + array2.length;
        int[] output = new int[size];
        int carry = 0;
        int i = 0;
        int j = 0;
        int k = size-1;

        while(i < array1.length && j < array2.length){
            int sum = array1[i] + array2[j] + carry;
            int lastDigit = sum % 10;
            output[k] = lastDigit;
            carry = sum - lastDigit;
            i++;
            j++;
            k--;
        }

        while(i < array1.length){
            int sum = array1[i] + carry;
            int lastDigit = sum % 10;
            output[k] = lastDigit;
            carry = sum - lastDigit;
            i++;
            k--;
        }

        while(j < array2.length){
            int sum = array1[j] + carry;
            int lastDigit = sum % 10;
            output[k] = lastDigit;
            carry = sum - lastDigit;
            j++;
            k--;
        }
        output[k] = carry;
        return output;
    }

    public static void main(String[] args) {
        int[] array1 = { 5, 1, 6, 2, 3, 8, 9 };
        int[] array2 = { 9, 6, 3, 4, 7 };
        int[] output = sumOfArray(array1, array2);
        int sum = 0;
        for (int i : output)
            sum += i;
        System.out.println(sum);
        System.out.println(Arrays.toString(output));
    }
}
