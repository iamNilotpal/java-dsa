public class LinearSearch {

    private static int linearSearch(int[] array, int  key){
        for (int i = 0; i < array.length; i++){
            if (array[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = { 10, 3, 1, 50, 3, 6, 7, 8, 3 };
        System.out.println(linearSearch(array, 50));
    }
}
