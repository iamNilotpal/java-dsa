public class TowerOfHanoi {

    private static void towerOfHanoi(int numDisk, char source, char auxiliary, char destination){
        if (numDisk == 0)
            return;

        towerOfHanoi(numDisk-1, source, destination, auxiliary);
        System.out.println(source + " to " + destination);
        towerOfHanoi(numDisk-1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        towerOfHanoi(4, 'A', 'B', 'C');
    }
}
