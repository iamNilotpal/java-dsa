package using.linkedlist;

import java.util.ArrayList;

public class StackUse {

    public static StackLL<Integer> sortStack(StackLL<Integer> s) throws StackUnderFlowException {
        if (s.getSize() == 0)
            return null;

        StackLL<Integer> temp = new StackLL<>();
        StackLL<Integer> output = new StackLL<>();

        while(!s.isEmpty()){
            int popElem = s.pop();
            if (output.isEmpty())
                output.push(popElem);
            else{
                while (!output.isEmpty() && popElem > output.peek()){
                    int outPop = output.pop();
                    temp.push(outPop);
                }
                output.push(popElem);
                while(!temp.isEmpty()){
                    int tempPop = temp.pop();
                    output.push(tempPop);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) throws StackUnderFlowException {

        StackLL<Integer> stack = new StackLL<>();
        for (int i = 0 ; i <= 30; i++)
            stack.push(i);

        System.out.println("Stack  before Sorting : ");
        stack.print();

        System.out.println("\nStack After Sorting : ");
        stack = sortStack(stack);
        stack.print();
//        stack1.pop();
//        stack1.pop();
//        stack1.pop();
//        stack1.print();
//        System.out.println(stack1.isEmpty());
//        System.out.println(stack1.getSize());


    }
}
