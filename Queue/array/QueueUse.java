package using.array;

public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException {

        QueueArray<Integer> queue = new QueueArray<>();

        for (int i = 1; i <= 10; i++)
            queue.enqueue(i+1);
        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        System.out.println(queue.getSize());
        queue.print();
    }
}
