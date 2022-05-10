public class RemoveDuplicates {

    private static String removeDuplicates(String str){
        if (str.length() < 2)
            return str;

//        Calling Recursion after
        if (str.charAt(0) == str.charAt(1))
            return removeDuplicates(str.substring(1, str.length()));
        else
            return str.charAt(0) + removeDuplicates(str.substring(1, str.length()));

//        Calling recursion before
//        String ans = removeDuplicates(str.substring(1, str.length()));
//        if (str.charAt(0) == ans.charAt(0))
//            return ans;
//        else
//            return str.charAt(0) + ans;
    }

    public static void main(String[] args) {
        String str = "aaxxbbcxbbdededdfxxxaxbx";
        System.out.println(removeDuplicates(str));
    }
}
