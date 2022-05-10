public class PairStar {

    private static String pairStar(String str){
        if (str.length() < 2)
            return str;

        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1, str.length()));
        else
            return str.charAt(0) + pairStar(str.substring(1, str.length()));
    }

    public static void main(String[] args) {
        String str = "aaaaahelloo";
        System.out.println(pairStar(str));
    }
}
