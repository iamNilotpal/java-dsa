import java.util.Scanner;

public class HighestOccChar {

    private static char highestOccChar(String str){
        int[] frequency = new int[256];
        int maxFrequency = 0;
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
            maxFrequency = Math.max(maxFrequency, frequency[str.charAt(i)]);
        }

        char c = '\0';
        for (int i = 0; i < str.length(); i++){
            if (frequency[str.charAt(i)] == maxFrequency){
                c = str.charAt(i);
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.next();
        System.out.println(highestOccChar(str));
    }
}
