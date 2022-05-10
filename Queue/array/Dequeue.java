package using.array;

public class Dequeue {

    public static void main(String[] args) {
        QueueClass<Integer> queue = new QueueClass<>(10);

        int i = 0;
        for (; i < 5; i++)
            queue.insertFront(i+5);

        for (; i < 10; i++)
            queue.insertRear(i + 5);

        queue.print();
    }
}
