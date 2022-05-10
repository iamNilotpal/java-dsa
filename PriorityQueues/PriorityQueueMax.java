import java.util.ArrayList;

public class PriorityQueueMax<T> {
    private final ArrayList<Node<T>> map;

    public PriorityQueueMax() {
        map = new ArrayList<>();
    }

    public T getMax() throws PriorityQueueEmptyException{
        if(isEmpty())
            throw new PriorityQueueEmptyException();

        return map.get(0).data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return map.size();
    }

    public void insert(T data, int priority) {
        Node<T> newNode = new Node<>(data, priority);
        map.add(newNode);

        int childIndex = map.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while(childIndex > 0) {
            if(map.get(childIndex).priority > map.get(parentIndex).priority) {
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

    public T removeMax() throws PriorityQueueEmptyException{
        if(isEmpty())
            throw new PriorityQueueEmptyException();

        Node<T> removeNode = map.get(0);
        map.set(0, map.get(map.size() - 1));
        map.remove(map.size() - 1);

        int parentIndex = 0;
        int leftChildIndex = 1;  // (2 * parentIndex + 1)
        int rightChildIndex = 2; // (2 * parentIndex + 2)

        while (leftChildIndex < map.size()) {
            int currenMaxIndex = parentIndex;

            if(map.get(leftChildIndex).priority > map.get(currenMaxIndex).priority)
                currenMaxIndex = leftChildIndex;

            if(rightChildIndex < map.size() && map.get(rightChildIndex).priority > map.get(currenMaxIndex).priority)
                currenMaxIndex = rightChildIndex;

            if(currenMaxIndex == parentIndex)
                break;

            Node<T> temp = map.get(parentIndex);
            map.set(parentIndex, map.get(currenMaxIndex));
            map.set(currenMaxIndex, temp);

            parentIndex = currenMaxIndex;
            leftChildIndex = 2 * parentIndex + 1;  // (2 * parentIndex + 1)
            rightChildIndex = 2 * parentIndex + 2; // (2 * parentIndex + 2)
        }
        return removeNode.data;
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
