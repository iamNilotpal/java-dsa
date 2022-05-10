public class RemoveDuplicates {

    private static String removeDuplicates(String str){
        int start = 0;
        String output = str.charAt(start) + "";

        for (int j = 1; j < str.length(); j++){
            if(output.charAt(start) != str.charAt(j)) {
                output += str.charAt(j);
                start++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String str = "aaaaabbbabbbcadddaabb";
        System.out.println(removeDuplicates(str));
    }
}
