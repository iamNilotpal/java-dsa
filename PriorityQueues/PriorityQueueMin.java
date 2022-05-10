import java.util.ArrayList;

public class PriorityQueueMin<T> {
    private final ArrayList<Node<T>> map;

    PriorityQueueMin() {
        map = new ArrayList<>();
    }

    public void insert(T data, int priority) {
        Node<T> newNode = new Node<>(data, priority);
        map.add(newNode);

        int childIndex = map.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if(map.get(childIndex).priority < map.get(parentIndex).priority) {
                Node<T> temp = map.get(parentIndex);
                map.set(parentIndex, map.get(childIndex));
                map.set(childIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else
                return;
        }
    }

    public T removeMin() throws PriorityQueueEmptyException{
        if(isEmpty())
            throw new PriorityQueueEmptyException();

        Node<T> temp = map.get(0);
        map.set(0, map.get(map.size() - 1));
        map.remove(map.size() - 1);

        int parentIndex = 0;
        int leftIndex = 1;  // (2 * parentIndex + 1)
        int rightIndex = 2; // (2 * parentIndex + 2)

        while (leftIndex < map.size()) {
            int minIndex = parentIndex;

            if(map.get(leftIndex).priority < map.get(minIndex).priority )
                minIndex = leftIndex;

            if(rightIndex < map.size() && map.get(rightIndex).priority < map.get(minIndex).priority)
                minIndex = rightIndex;

            if(minIndex == parentIndex)
                break;

            Node<T> parent = map.get(parentIndex);
            map.set(parentIndex, map.get(minIndex));
            map.set(minIndex, parent);

            parentIndex = minIndex;
            leftIndex =  2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
        return temp.data;
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getMin() throws PriorityQueueEmptyException{
        if(isEmpty())
            throw new PriorityQueueEmptyException();

        Node<T> temp = map.get(0);
        return temp.data;
    }

    public void print() throws PriorityQueueEmptyException{
        if(isEmpty())
            throw new PriorityQueueEmptyException();

        for (int i = 0; i < map.size(); i++) {
            Node<T> temp = map.get(i);

            System.out.print(temp.data + "(" + temp.priority + ")" + ": ");
            int leftChildIndex = 2 * i + 1;
            if (leftChildIndex < map.size()) {
                Node<T> leftData = map.get(leftChildIndex);
                System.out.print(leftData.data + "(" + leftData.priority + ")" + ", ");
            }

            int rightChildIndex = 2 * i + 2;
            if (rightChildIndex < map.size()) {
                Node<T> rightData = map.get(rightChildIndex);
                System.out.print(rightData.data + "(" + rightData.priority + ")");
            }
            System.out.println();
        }
    }
}
