package using.linkedlist;

public class StackLL<T> {
    private Node<T> head;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null)
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T pop() throws StackUnderFlowException{
        if(head == null)
            throw new StackUnderFlowException();
        else{
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    public void print() throws StackUnderFlowException{
        if(head == null)
            throw new StackUnderFlowException();
        else{
            Node<T> temp = head;
            while (temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public int getSize(){
        return size;
    }

    public T peek() throws StackUnderFlowException{
        if (size == 0)
            throw new StackUnderFlowException();
        else
            return head.data;
    }
}
