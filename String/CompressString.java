import java.util.Scanner;

public class CompressString {

    private static String compressString(String str){
//        int[] frequency = new int[256];

        if (str.length() < 2)
            return str;

//        int count = 1;
//        String ans = str.charAt(0) + "";
//        for (int i = 1; i< str.length(); i++){
//            if (str.charAt(i) == str.charAt(i-1))
//                count++;
//            else{
//                if (count > 1) {
//                    ans += count;
//                    count = 1;
//                }
//                ans += str.charAt(i);
//            }
//        }
//        ans += count;
//        return ans;

        int count = 1;
        String output = "";
        for (int i = 0; i < str.length()-1; i++){
            if (str.charAt(i) == str.charAt(i+1))
                count++;
            else{
                output += str.charAt(i);
                if (count > 1)
                    output += count;
                count = 1;
            }
        }
        output += str.charAt(str.length()-1);
        if (count > 1)
            output += count;
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.next();
        System.out.println(compressString(str));
    }
}
