package using.array;

import java.util.Stack;

public class CheckRedundantBracket {

    private static boolean checkRedundant(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ')')
                stack.push(str.charAt(i));
            else{
                char c = stack.peek();
                if (str.charAt(i) == ')' && c == '(')
                    return true;

                while (stack.peek() != '(')
                    stack.pop();
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkRedundant("(a+b)*c+(d+e)"));
    }
}
