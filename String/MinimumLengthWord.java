public class MinimumLengthWord {

    private static String minLengthWord(String str){
        int si = 0, ei = 0;
        int minLength = str.length();
        int minLengthStart = 0;
        int charCount = 0;

        while (ei < str.length()){
            if (str.charAt(ei) != ' ')
                ei++;
            else{
                charCount = ei - si;
                if (charCount < minLength){
                    minLength = charCount;
                    minLengthStart = si;
                }
                ei++;
                si = ei;
            }
        }

        charCount = str.length() - si;
        if (charCount < minLength){
            minLength = charCount;
            minLengthStart = si;
        }

        return str.substring(minLengthStart, minLengthStart+minLength);
    }

    public static void main(String[] args) {
        String str = "JavaScript was weird programming language is Lol";
        System.out.println(minLengthWord(str));
    }
}
