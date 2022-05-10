import java.util.Scanner;

public class BinaryTreeUse {
    private static BinaryTreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = sc.nextInt();

        if (rootData == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput();
        root.right = takeInput();
        return root;
    }

    private static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, boolean isLeft, int parentData){
        Scanner sc = new Scanner(System.in);
        if (isRoot)
            System.out.println("Enter root data");
        else {
            if (isLeft)
                System.out.println("Enter left child of " + parentData);
            else
                System.out.println("Enter right child of " + parentData);
        }
        int rootData = sc.nextInt();
        if (rootData == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInputBetter(false, true, rootData);
        root.right = takeInputBetter(false, false, rootData);
        return root;
    }

    private static void printTree(BinaryTreeNode<Integer> root){
        if (root == null)
            return;

        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    private static void printTreeDetailed(BinaryTreeNode<Integer> root){
        if (root == null)
            return;
        System.out.print(root.data + " : ");

        if (root.left != null)
            System.out.print("L" + root.left.data + ", ");

        if (root.right != null)
            System.out.print("R" + root.right.data);

        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    private static int countNodes(BinaryTreeNode<Integer> root){
        if (root == null)
            return 0;
        int count  = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }

    private static int sumOfNodes(BinaryTreeNode<Integer> root){
        if (root == null)
            return 0;

        int sum = root.data;
        sum += sumOfNodes(root.left);
        sum+= sumOfNodes(root.right);
        return sum;
    }

    private static int largestNode(BinaryTreeNode<Integer> root){
        if (root == null)
            return Integer.MIN_VALUE;

        int largestLeft = largestNode(root.left);
        int largestRight = largestNode(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }

    private static int nodesGreaterThanX(BinaryTreeNode<Integer> root, int x){
        if (root == null)
            return 0;
         int count = 0;
         if (root.data > x)
             count++;
         count += nodesGreaterThanX(root.left, x);
         count += nodesGreaterThanX(root.right, x);
         return count;
    }

    private static int height(BinaryTreeNode<Integer> root){
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static int countLeafNodes(BinaryTreeNode<Integer> root){
        if (root == null)
            return 0;

        int count = 0;
        if (root.left == null && root.right == null)
            count++;
        count += countLeafNodes(root.left);
        count += countLeafNodes(root.right);
        return count;
    }

    public static void main(String[] args) {

//        BinaryTreeNode<Integer> root = takeInput();
        BinaryTreeNode<Integer> root = takeInputBetter(true, false, 0);
//        printTree(root);
        printTreeDetailed(root);
        System.out.println("Num Nodes " + countNodes(root));
        System.out.println("Sum of nodes " + sumOfNodes(root));
        System.out.println("Largest Node " + largestNode(root));
        System.out.println("Num Nodes Greater than 5 are " + nodesGreaterThanX(root, 5));
        System.out.println("Height " + height(root));
        System.out.println("Num Leaf Nodes " + countLeafNodes(root));
    }
}
