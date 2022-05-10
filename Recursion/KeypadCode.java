public class KeypadCode {

    private static String[] digitString(int n){
        if (n == 0 || n == 1)
            return new String[]{" "};
        else if (n == 2)
            return new String[]{"a", "b", "c"};
        else if (n == 3)
            return new String[]{"d", "e", "f"};
        else if (n == 4)
            return new String[]{"g", "h", "i"};
        else if (n == 5)
            return new String[]{"j", "k", "l"};
        else if (n == 6)
            return new String[]{"m", "n", "o"};
        else if (n == 7)
            return new String[]{"p", "q", "r", "s"};
        else if (n == 8)
            return new String[]{"t", "u", "v"};
        else
            return new String[]{"w", "x", "y", "z"};
    }

    private static String[] keypadCode(int n){
        if (n == 0)
            return new String[]{" "};

        int lastDigit = n % 10;
        int nextNum = n / 10;
        String[] smallAns = keypadCode(nextNum);
        String[] options = digitString(lastDigit);
        String[] output = new String[options.length * smallAns.length];

        int k = 0;
        for (int i = 0; i < options.length; i++){
            for (int j = 0; j < smallAns.length; j++)
                output[k++] = options[i] + smallAns[j];
        }
        return output;
    }

    public static void main(String[] args) {
        String[] ans = keypadCode(567);
        for (String str : ans)
            System.out.print(str + " ");
    }
}
