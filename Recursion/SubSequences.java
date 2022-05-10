public class SubSequences {
    private static String[] subSequences(String str){
        if (str.length() == 0)
            return new String[]{" "};

        String[] smallAns = subSequences(str.substring(1, str.length()));
        String[] output = new String[2 * smallAns.length];

        for (int i = 0; i < smallAns.length; i++)
            output[i] = smallAns[i];

        for (int i = 0; i < smallAns.length; i++)
            output[i + smallAns.length] = str.charAt(0) + smallAns[i];

        return output;
    }

    public static void main(String[] args) {
        String[] output = subSequences("abcd");
        for (String str : output)
            System.out.print(str + " ");
    }
}
