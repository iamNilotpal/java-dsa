public class BinarySearch {

    private static int binarySearchRecursive(int[] array, int si, int ei, int key){
        if (si > ei)
            return -1;

        int mid = (si + ei) / 2;

        if (array[mid] == key)
            return mid;
        else if(array[mid] < key)
            return binarySearchRecursive(array, mid+1, ei, key);
        else
            return binarySearchRecursive(array, si, mid-1, key);
    }

    private static int binarySearch(int[] array, int key){
        int si =0, ei = array.length - 1;

        while(si <= ei){
            int mid = (si + ei) / 2;
            if (array[mid] == key)
                return mid;
            else if(array[mid] > key)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 4, 9, 11, 19, 23, 54, 79, 99, 101 };
        System.out.println(binarySearchRecursive(array, 0, array.length-1, 40));
        System.out.println(binarySearch(array, 23));
    }
}
