package using.array;

public class ReverseStack {

    private static Stack<Integer> reverseStack(Stack<Integer> s) throws StackUnderFlowException {
        int[] array = new int[s.getSize()];
        int i = 0;
        while (!s.isEmpty())
            array[i++] = s.pop();

        for (i = 0; i < array.length; i++)
            s.push(array[i]);
        return s;
    }

    public static void main(String[] args) throws StackUnderFlowException {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++)
            stack.push(i+1);

        stack.print();
        stack = reverseStack(stack);
        stack.print();
    }
}
