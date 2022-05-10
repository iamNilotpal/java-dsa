package using.array;

import java.util.ArrayList;

public class QueueClass<T> {
    private final ArrayList<T> array;
    private int size;
    private int top;
    private int topMove;
    private int rear;
    private int rearMove;
    private int tSize;

    QueueClass(int totalSize){
        array = new ArrayList<T>(totalSize);
        size = 0;
        top = -1;
        topMove = -1;
        rearMove = rear = totalSize - 1;
        tSize = totalSize;
    }

    public void insertFront(T elem){
        if (size == tSize){
            System.out.println(-1);
            return;
        }

        if (topMove < rearMove){
            if (top == -1 && topMove == -1)
                top++;

            topMove++;
            array.add(topMove, elem);
            size++;
        }
    }

    public void insertRear(T elem){
        if (size == tSize){
            System.out.println(-1);
            return;
        }

        if (rearMove > topMove){
            array.add(rearMove, elem);
            rearMove--;
            size++;
        }
    }

    public int deleteFront(){
        if (size == 0)
            return -1;
        else{
            T tooElem = array.get(top);
            top++;
            return (int) tooElem;
        }
    }

    public int deleteRear(){
        if (size == 0)
            return -1;
        else{
            T tooElem = array.get(rear);
            rear--;
            return (int) tooElem;
        }
    }

    public void print(){
        if (size == 0) {
            System.out.println(Integer.MIN_VALUE);
            return;
        }

        for (int i = top; i <= rear; i++)
            System.out.print(array.get(i) + " ");
    }
}
