package using.array;

import java.util.Stack;

public class IsBalanced {

    private static boolean balancedParenthesis(String str) throws StackUnderFlowException {
        if (str.length() < 2)
            return false;
        java.util.Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
                stack.push(str.charAt(i));
            else{
                if (stack.isEmpty())
                    return false;

                char c = stack.pop();
                if (str.charAt(i) == ')' && c == '(')
                    continue;
                else if(str.charAt(i) == ']' && c == '[')
                    continue;
                else if(str.charAt(i) == '}' && c == '{')
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws StackUnderFlowException {
        System.out.println(balancedParenthesis("[()]"));
    }
}
