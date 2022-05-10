public class StringToInteger {

    private static int stringToInt(String str){
        if (str.length() < 1)
            return 0;
        int nextDigit = str.charAt(str.length()-1) - '0';
        int smallAns = stringToInt(str.substring(0, str.length()-1));
        return (smallAns * 10) + nextDigit;
    }

    public static void main(String[] args) {
        String str = "1234";
        System.out.println(stringToInt(str));
    }
}
