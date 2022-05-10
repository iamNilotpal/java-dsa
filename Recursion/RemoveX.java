public class RemoveX {

    private static String removeX(String str){
        if (str.length() < 1 )
            return str;

        if (str.charAt(0) == 'x')
            return removeX(str.substring(1, str.length()));
        else
            return str.charAt(0) + removeX(str.substring(1, str.length()));
    }

    public static void main(String[] args) {
        String str = "axxbcxdefxxxaxbx";
        System.out.println(removeX(str));
    }
}
