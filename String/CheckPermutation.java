public class CheckPermutation {

    private static boolean checkPermutation(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        int[] frequency = new int[256];
        for (int i = 0; i < str1.length(); i++)
            frequency[str1.charAt(i)] += 1;

        for (int i = 0; i < str2.length(); i++)
            frequency[str2.charAt(i)]-= 1;

        for (int i : frequency){
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abca";
        String str2 = "cbaa";
        System.out.println(checkPermutation(str1, str2));
    }
}
