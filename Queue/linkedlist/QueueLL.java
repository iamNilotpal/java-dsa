package using.linkedlist;

public class QueueLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public T getFront() throws QueueEmptyException{
        if (front == null)
            throw new QueueEmptyException();
        else
            return front.data;
    }

    public void enqueue(T elem){
        Node<T> newNode = new Node<>(elem);
        if (front == null && rear == null)
            front = rear = newNode;
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() throws QueueEmptyException{
        if (front == null)
            throw new QueueEmptyException();
        else{
            T data = front.data;
            front = front.next;
            size--;
            return data;
        }
    }

    public void print() throws QueueEmptyException{
        if (front == null && rear == null)
            throw new QueueEmptyException();
        else{
            Node<T> temp = front;
            while (temp != rear){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data);
        }
    }
}
