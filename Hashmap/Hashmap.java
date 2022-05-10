import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hashmap {

    public static ArrayList<Integer> removeDuplicates(int[] array){
        HashMap<Integer, Boolean> map =  new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int j : array) {
            if (!map.containsKey(j)) {
                map.put(j, true);
                ans.add(j);
            }
        }
        return ans;
    }

    public static void maxFrequency(int[] array) {
        HashMap<Integer, Integer> map =  new HashMap<>();

        for (int j : array) {
            if (map.containsKey(j)) {
                int value = map.get(j);
                map.put(j, value + 1);
            } else
                map.put(j, 1);
        }

        int maxFrequency = Integer.MIN_VALUE;
        int elem = Integer.MIN_VALUE;
        for (int j : array) {
            int currentMax = map.get(j);
            if (currentMax > maxFrequency) {
                maxFrequency = currentMax;
                elem = j;
            }
        }
        System.out.println("Max Frequency element is " + elem + " and the Frequency is " + maxFrequency);
    }

    public static void arrayIntersection(int[] array1, int[] array2) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        for (int i : array1) {
            if (map.containsKey(i)){
                int value = map.get(i);
                map.put(i, value+1);
            }
            else
                map.put(i, 1);
        }

        for (int j : array2) {
            if (map.containsKey(j)){
                int value = map.get(j);
                if (value != 0) {
                    System.out.print(j + " ");
                    map.put(j, value-1);
                }
            }
        }
    }

//    public static void pairSum(int[] array) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i : array){
//            if (map.containsKey(i)){
//                int value = map.get(i);
//                map.put(i, value+1);
//            }
//            else
//                map.put(i, 1);
//        }
//
//        for (int j : array) {
//
//        }
//    }

    public static void main(String[] args) {

        Map<String, Integer> map = new Map<>();

        for (int i = 0; i < 35; i++) {
            map.insert(("abc" + i), i + 1);
            System.out.println("Load Factor : " + map.loadFactor());
        }

//        for (int i = 0; i < map.capacity(); i++)
//            System.out.println(("abc" + i) + ": "+ (map.getValue("abc" + i)));
//
//        String str = "abc";
//        System.out.println(str.hashCode() % 20);


//        int[] array = {1, 3, 5, 9, 6, 1, 3, 3, 9, 1, 7, 10, 10, 11, 9, 13, 11, 3, 90};
//        ArrayList<Integer> ans =  removeDuplicates(array);
//        System.out.println(ans);
//        maxFrequency(array);
//
//        int[] array1 = { 2, 5, 3, 2, 6, 3, 7, 1 };
//        int[] array2 = { 4, 5, 2, 1, 9, 8, 6, 2 };
//        arrayIntersection(array1, array2);

//        HashMap<String, Integer> map = new HashMap<>();
//
////        Insert
//        map.put("abc", 10);
//        map.put("def", 5);
//
////        Is Present
//        if (map.containsKey("abc"))
//            System.out.println("abc is present");
//
//        if (map.containsKey("abc1"))
//            System.out.println("abc1 is present");
//
////        Getting value
//        int v = map.get("abc");
//        System.out.println(v);
//
////        int v2 = map.get("abcd1"); // Bad Practice
////        System.out.println(v2);
//        int value = 0;
//        if (map.containsKey("abc1"))
//            value = map.get("abc1");
//        System.out.println(value);
//
////        Remove
////        map.remove("abc");
////        if (map.containsKey("abc"))
////            System.out.println("abc");
//
//        Set<String> sets = map.keySet();
//        System.out.println(sets);
//        for (String s : sets)
//            System.out.print(s + " ");
    }
}
