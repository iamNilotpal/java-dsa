import java.util.ArrayList;

public class Map<K, V> {
    private ArrayList<MapNode<K, V>> bucketArray;
    private int size;
    private int count;

    public Map() {
        bucketArray = new ArrayList<>();
        size = 5;
        for (int i = 0; i < size; i++)
            bucketArray.add(i, null);
    }

    public int capacity() {
        return size;
    }

    public int count() {
        return count;
    }

    public double loadFactor() {
        return (1.0 * count) / size;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % size;
    }

    private void reHash() {
//        Just for testing purpose
//        System.out.println("Load Factor : " + loadFactor());

        ArrayList<MapNode<K, V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        for (int i = 0; i < 2 * size; i++)
            bucketArray.add(i, null);

        count = 0;
        size *= 2;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucketArray.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        count++;

        double loadFactor = (1.0 * count) / size;
        if (loadFactor >= 0.7)
            reHash();
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketArray.get(bucketIndex);
        MapNode<K, V> previous = null;
        while (head != null) {
            if (head.key.equals(key)){
                if (previous != null)
                    previous.next = head.next;
                else
                    bucketArray.set(bucketIndex, null);
                count--;
                return head.value;
            }
            previous = head;
            head = head.next;
        }
        return null;
    }
}
