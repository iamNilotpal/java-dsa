public class CheckPalindrome {
    private static boolean checkPalindrome(String str) {
        if (str.length() < 2)
            return true;

        if (str.charAt(0) == str.charAt(str.length() - 1))
            return checkPalindrome(str.substring(1, str.length() - 1));
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abcddcba"));
    }
}
