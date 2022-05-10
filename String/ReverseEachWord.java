public class ReverseEachWord {
    private static String reverseEachWord(String str){
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

    public static void main(String[] args) {
        String str = "abc def ghi";
        System.out.print(reverseEachWord(str));
    }
}
