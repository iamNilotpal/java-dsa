public class PrintLikeWave {

    private static void printWave(int[][] array){
       if (array.length == 0)
           return;

       for (int i = 0; i < array[0].length; i++){
           if (i % 2 == 0){
               for (int[] ints : array) System.out.print(ints[i] + " ");
           }
           else{
               for (int j = array.length -1; j >= 0; j--)
                   System.out.print(array[j][i] + " ");
           }
           System.out.println();
       }
    }

    public static void main(String[] args) {
        int[][] array = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        printWave(array);
    }
}
