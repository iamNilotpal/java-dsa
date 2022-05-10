package using.array;

import java.util.Stack;

public class MinimumBracketTraversal {

    private static int minimumBracketTraversal(String str){
        if (str.length() % 2 != 0)
            return -1;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '{')
                stack.push(str.charAt(i));
            else if(!stack.isEmpty() && (str.charAt(i) == '}' && stack.peek() == '{'))
                stack.pop();
            else if (stack.isEmpty() && str.charAt(i) == '}')
                stack.push(str.charAt(i));
        }

        int count = 0;
        while (!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();

            if (c1 != c2)
                count += 2;
            else
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumBracketTraversal("{{{{"));
    }
}
