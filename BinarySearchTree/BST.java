public class BST<T> {
    private BinaryTreeNode<Integer> root;
    private int size;

    //    Inserting Element
    public void insert(int data) {
        root = insertHelper(root, data);
        size++;
    }

    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            root = new BinaryTreeNode<>(data);
            return root;
        }

        if (root.data >= data)
            root.left = insertHelper(root.left, data);
        else
            root.right = insertHelper(root.right, data);

        return root;
    }

    // Searching Element
    public boolean isPresent(int data) {
        return isPresentHelper(root, data);
    }

    private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null)
            return false;

        if (root.data == data)
            return true;
        else if (root.data < data)
            return isPresentHelper(root.right, data);
        else
            return isPresentHelper(root.left, data);
    }

    public void printTree() {
        printTreeHelper(root);
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.data + ": ");

        if (root.left != null)
            System.out.print("L" + root.left.data + ", ");

        if (root.right != null)
            System.out.print("R" + root.right.data);
        System.out.println();

        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }

    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public boolean delete(int data) {
        DeleteNode node = deleteHelper(root, data);
        root = node.node;
        if (node.isDeleted)
            size--;
        return node.isDeleted;
    }

    private static DeleteNode deleteHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null)
            return new DeleteNode(null, false);

        if (root.data > data){
            DeleteNode ansLeft = deleteHelper(root.left, data);
            root.left = ansLeft.node;
            ansLeft.node = root;
            return ansLeft;
        }
        else if (root.data < data){
            DeleteNode ansRight =  deleteHelper(root.right, data);
            root.right = ansRight.node;
            ansRight.node = root;
            return ansRight;
        }
        else {
            if (root.left == null && root.right == null)
                return new DeleteNode(null, true);
            else if(root.left != null && root.right == null)
                return new DeleteNode(root.left, true);
            else if(root.right != null && root.left == null)
                return new DeleteNode(root.right, true);
            else{
                int rightMin = minimum(root.right);
                root.data = rightMin;
                DeleteNode ans = deleteHelper(root.right, rightMin);
                root.right = ans.node;
                ans.node = root;
                return ans;
            }
        }
    }

    public int size(){
        return size;
    }
}
