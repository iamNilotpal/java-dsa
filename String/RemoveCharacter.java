import java.util.Scanner;

public class RemoveCharacter {

    private static String removeChar(String str, char c){
        String output = "";

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != c)
                output += str.charAt(i);
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.next();

        System.out.println("Enter the character you want to remove");
        char c = sc.next().charAt(0);

        System.out.println(removeChar(str, c));
    }
}
