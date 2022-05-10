public class PriorityQueueUse {

    public static void main(String[] args) throws PriorityQueueEmptyException {
        PriorityQueueMin<String> map = new PriorityQueueMin<>();
//        PriorityQueueMax<String> map = new PriorityQueueMax<>();
        map.insert("1", 4);
        map.insert("2", 3);
        map.insert("3", 10);
        map.insert("3", 13);
        map.insert("5", 18);
        map.insert("6", 5);
        map.insert("7", 20);
        map.insert("8", 32);

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.getMin());
//        map.print();
//        map.removeMin();
        System.out.println(map.removeMin());
        map.print();
    }
}
