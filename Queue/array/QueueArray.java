package using.array;

import java.util.ArrayList;

public class QueueArray<T> {
    private ArrayList<T> data;
    private int front;
    private int rear;
    private int size;

    public QueueArray(){
        data = new ArrayList<>();
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() { return size; }

    public T front() throws QueueEmptyException{
        if (size == 0)
            throw new QueueEmptyException();
        else
            return data.get(front);
    }

    public void enqueue(T elem){
        if (front == -1)
            front++;

        rear++;
        size++;
        data.add(rear, elem);
    }

    public T dequeue() throws QueueEmptyException{
        if (size == 0)
            throw new QueueEmptyException();
        else{
            T elem = data.get(front);
            front++;
            size--;
            return elem;
        }
    }

    public void print() throws QueueEmptyException{
        if (size == 0)
            throw new QueueEmptyException();
        else{
            for (int i = 0; i < size; i++)
                System.out.print(data.get(i) + " ");
        }
    }
}
