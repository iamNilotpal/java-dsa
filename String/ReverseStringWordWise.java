public class ReverseStringWordWise {

//    private static String reverseString(String str){
//        String output = "";
//        int previousWordEnd = str.length() - 1;
//        for (int i = previousWordEnd; i >= 0; i--){
//            if (str.charAt(i) == ' '){
//                int wordStart = i + 1;
//                for (int j = wordStart; j <= previousWordEnd; j++)
//                    output += str.charAt(j);
//                output += " ";
//            }
//            previousWordEnd = i - 1;
//            i = previousWordEnd;
//        }
//
//        for (int i = 0; i<= previousWordEnd; i++)
//            output += str.charAt(i);
//
//        str = output;
//        return str;
//    }

    private static String reverse(String str){
        String ans = "";
        for (int i = 0; i < str.length(); i++){
            ans = str.charAt(i) + ans;
        }
        return ans;
    }

    private static String reverseString(String str){
        str = reverse(str);
        String reversedString = "";
        int wordStart = 0;
        int i = 0;
        for (; i < str.length(); i++){
            String reverseWord = "";
            if (str.charAt(i) == ' '){
                int wordEnding = i-1;
                for (int j = wordStart; j <= wordEnding; j++)
                    reverseWord = str.charAt(j) + reverseWord;
                reversedString += reverseWord + " ";
                wordStart = i + 1;
            }
        }
        String reverseWord = "";
        int wordEnding = i-1;
        for (int j = wordStart; j <= wordEnding; j++)
            reverseWord = str.charAt(j) + reverseWord;
        reversedString += reverseWord;

        return reversedString;
    }

    private static String reverseString_2(String str){
        int end = str.length();
        int i = str.length() - 1;
        String output = "";
        while (i >= 0){
            if (str.charAt(i) == ' '){
                output = output + str.substring(i+1, end) + " ";
                end = i;
            }
            i--;
        }
        return output;
    }

    public static void main(String[] args) {
        String str = "abc def ghijk lmn op";
//        String ans = reverseString(str);
//        System.out.println(reverseString(str));

        System.out.println(reverseString_2(str));
    }
}
