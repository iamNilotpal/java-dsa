public class TripletSum {

    private static void tripletSum(int[] array, int key){
        for (int i : array) {
            for (int j : array) {
                for (int k : array) {
                    if (i + j + k == key)
                        System.out.print("(" + i + "," + j + "," + k + ")" + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 9, 8, 3, 2, 6, 1, 5, 4};
        tripletSum(array, 9);
    }
}
