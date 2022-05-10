public class MaximizeSum {

    private static int maximizeSum(int[] array1, int[] array2){
        int maxSum = 0;
        int sum1 = 0, sum2= 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length){
            if (array1[i] < array2[j]) {
                sum1 += array1[i];
                i++;
            }
            else if(array2[j] < array1[i]){
                sum2 += array2[j];
                j++;
            }
            else{
                sum1 += array1[i];
                sum2 += array2[j];
                maxSum += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        if (maxSum == 0){
            maxSum = Math.max(sum1, sum2);
        }

        while (i < array1.length){
            sum1 += array1[i];
            maxSum += sum1;
            i++;
        }

        while (j < array2.length){
            sum2 += array2[j];
            maxSum += sum2;
            j++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 6, 10, 17, 20, 25};
        int[] array2 = {2, 4, 5, 9, 15};
        System.out.println(maximizeSum(array1, array2));
    }
}
