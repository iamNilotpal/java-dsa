package using.linkedlist;

public class QueueUse {

    public static void main(String[] args) throws QueueEmptyException {

        QueueLL<Integer> queue = new QueueLL<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.print();
        System.out.println(queue.getSize());
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println();
        System.out.println(queue.getFront());
    }
}
