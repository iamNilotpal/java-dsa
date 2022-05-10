package using.array;

public class StackUse {

    public static void main(String[] args) throws StackUnderFlowException {


        Stack<Integer> stack1 = new Stack<>();
        System.out.println(stack1.isEmpty());

        stack1.pop();

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);
        stack1.push(50);
        try {
            stack1.print();
        } catch (StackUnderFlowException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(stack1.pop());
        } catch (StackUnderFlowException e) {
            e.printStackTrace();
        }
        System.out.println(stack1.pop());
    }
}
