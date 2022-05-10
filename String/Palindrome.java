public class Palindrome {

    private static boolean checkPalindrome(String str){
        int j = str.length() - 1;
        for (int i = 0; i <= j; i++){
            if (str.charAt(i) != str.charAt(j))
                return false;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcdeedcba";
        System.out.println(checkPalindrome(str));
    }
}
