package using.array;

import java.util.ArrayList;

public class Stack<T> {
    private int top;
    private final ArrayList<T> array;

    public Stack(){
        array = new ArrayList<>();
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T data){
        top++;
        array.add(top, data);
    }

    public T pop() throws StackUnderFlowException{
        if (top == -1)
            throw new StackUnderFlowException();
        else{
            T data = array.get(top);
            array.remove(top);
            top--;
            return data;
        }
    }

    public void print() throws StackUnderFlowException{
        if (top == -1)
            throw new StackUnderFlowException();
        else{
            for (int i = top; i >= 0; i--)
                System.out.print(array.get(i) + " ");
            System.out.println();
        }
    }

    public int getSize(){
        return array.size();
    }
}
