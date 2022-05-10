public class checkAB {

    private static boolean checkAb(String str){
        if (str.length() == 0)
            return true;

        if (str.charAt(0) == 'a'){
            if (str.substring(1).length() > 1 && str.substring(1, 3).contains("bb")){
                return checkAb(str.substring(3, str.length()));
            }
            else
                return checkAb(str.substring(1, str.length()));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkAb("abbabbabb"));
    }
}
