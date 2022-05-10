public class PairSum {

    private static void pairSum(int[] array, int key){
        for (int j : array) {
            for (int k : array) {
                if (j + k == key)
                    System.out.print("(" + j + "," + k + ")" + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 9, 8, 3, 2, 6, 1, 5 };
        pairSum(array, 9);
    }
}
