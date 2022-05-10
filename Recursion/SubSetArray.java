public class SubSetArray {

    private static int[][] subsetArray(int[] array, int si) {
        if (si == array.length) {
            return new int[1][0];
        }

        int[][] smallAns = subsetArray(array, si + 1);
        int[][] output = new int[2 * smallAns.length][];

        int k = 0;
        for (int i = 0; i < smallAns.length; i++) {
            output[k] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++)
                output[k][j] = smallAns[i][j];
            k++;
        }

        for (int i = 0; i < smallAns.length; i++) {
            output[k] = new int[smallAns[i].length + 1];
            output[k][0] = array[si];
            for (int j = 1; j < smallAns[i].length; j++)
                output[k][j] = smallAns[i][j - 1];
            k++;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        int[][] output = subsetArray(array, 0);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++)
                System.out.print(output[i][j] + " ");
            System.out.println();
        }
    }
}
