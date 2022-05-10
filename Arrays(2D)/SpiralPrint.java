public class SpiralPrint {

    private static void spiralPrint(int[][] array){
        if (array.length == 0)
            return;

        int rowStart = 0;
        int rowEnd = array.length-1;
        int colStart = 0;
        int colEnd = array[0].length-1;
        int count = 0;
        int  i = 0;
         while(count < (array.length * array[0].length)){
             for (i = colStart; i < colEnd; i++){
                 System.out.print(array[rowStart][i] + " ");
                 count++;
             }
//             System.out.println();
             rowStart++;

             for (i = rowStart; i <= rowEnd; i++){
                 System.out.print(array[i][colEnd] + " ");
                 count++;
             }
             colEnd--;
//             System.out.println();

             for (i = colEnd; i >= colStart; i--){
                 System.out.print(array[i][colStart] + " ");
                 count++;
             }
             rowEnd--;
//             System.out.println();

             for (i = rowEnd; i >= rowStart; i--){
                 System.out.print(array[i][rowStart] + " ");
                 count++;
             }
             colStart++;
//             System.out.println();
         }
    }

    public static void main(String[] args) {
        int[][] array = { {1, 2, 3}, {3, 4, 5}, {6, 7, 8} };
        spiralPrint(array);
    }
}
