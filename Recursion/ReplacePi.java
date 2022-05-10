public class ReplacePi {

    private static String replacePi(String str){
        if (str.length() < 2)
            return str;

//        Calling Recursion after
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i')
            return "3.14" + replacePi(str.substring(2, str.length()));
        else
            return str.charAt(0) + replacePi(str.substring(1, str.length()));


//      Calling Recursion before
//        String smallAns = replacePi(str.substring(1, str.length()));
//        if (str.charAt(0) == 'p' && smallAns.charAt(0) == 'i')
//            return "3.14" + smallAns.substring(1);
//        else
//            return str.charAt(0) + smallAns;
    }

    public static void main(String[] args) {
        String str = "piabcdpipii";
        System.out.println(replacePi(str));
    }
}
