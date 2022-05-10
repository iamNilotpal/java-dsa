public class ReplaceCharacter {

    private static String replaceCharacter(String str, char c1, char c2){
        if (str.length() < 1)
            return str;

        if (str.charAt(0) == c1)
            return c2 + replaceCharacter(str.substring(1, str.length()), c1, c2);
        else
            return str.charAt(0) + replaceCharacter(str.substring(1, str.length()), c1, c2);
    }

    public static void main(String[] args) {
        String str = "abcdaadefaa";
        System.out.println(replaceCharacter(str, 'a', 'x'));
    }
}
