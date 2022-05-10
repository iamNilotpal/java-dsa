package using.array;

import java.util.Stack;

public class StockSpan {

    private static int[] stockSpan(int[] array){
        int length = array.length;
        int[] output = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        output[0] = 1;

        for (int i = 1; i < length; i++){

            while(!stack.isEmpty() && array[stack.peek()] < array[i])
                stack.pop();

            if (stack.isEmpty())
                output[i] = i+1;
            else
                output[i] = i - stack.peek();

            stack.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = { 5, 3, 8, 10, 7, 7, 12, 16};
        int[] output = stockSpan(array);
         for (int i : output)
             System.out.print(i + " ");
    }
}
