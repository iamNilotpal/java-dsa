
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse2 {
    private static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, boolean isLeft, int parentData){
        Scanner sc = new Scanner(System.in);
        if (isRoot)
            System.out.println("Enter root data");
        else {
            if (isLeft)
                System.out.println("Enter left child of " + parentData);
            else  System.out.println("Enter right child of " + parentData);
        }
        int rootData = sc.nextInt();
        if (rootData == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInputBetter(false, true, rootData);
        root.right = takeInputBetter(false, false, rootData);

        return root;
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

    private static boolean isPresent(BinaryTreeNode<Integer> root, int x){
        if (root == null)
            return false;

        if (root.data == x)
            return true;
        boolean isInLeft = isPresent(root.left, x);
        boolean isInRight = isPresent(root.right, x);
        return isInLeft || isInRight;
    }

    private static void printNoSiblings(BinaryTreeNode<Integer> root){
        if (root == null)
            return;

        if (root.left == null && root.right != null)
            System.out.print(root.right.data + " ");
        else if(root.left != null && root.right == null)
            System.out.print(root.left.data + " ");

        printNoSiblings(root.left);
        printNoSiblings(root.right);
    }

    private static void printAtDepthK(BinaryTreeNode<Integer> root, int k){
        if (root == null)
            return;
        if (k == 0)
            System.out.print(root.data + " ");
        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);
    }

    private static BinaryTreeNode<Integer> replaceDepth(BinaryTreeNode<Integer> root, int level){
        if (root == null)
            return null;

        root.data = level;
        root.left = replaceDepth(root.left, level + 1);
        root.right = replaceDepth(root.right, level + 1);
        return root;
    }

    private static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return null;
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }

    private static void mirrorTree(BinaryTreeNode<Integer> root){
        if (root == null)
            return;

        BinaryTreeNode<Integer> temp = root.right;
        root.right = root.left;
        root.left = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    private static boolean isBalanced(BinaryTreeNode<Integer> root){
        if (root == null)
            return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isLeftBalanced && isRightBalanced;
    }

    private static DoubleNode isBalancedBetter(BinaryTreeNode<Integer> root){
        if (root == null){
            DoubleNode ans = new DoubleNode();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }

        DoubleNode leftTree = isBalancedBetter(root.left);
        DoubleNode rightTree = isBalancedBetter(root.right);
        int height = 1 + Math.max(leftTree.height, rightTree.height);
        boolean isBalanced = Math.abs(leftTree.height - rightTree.height) <= 1;

        if (!leftTree.isBalanced || !rightTree.isBalanced)
            isBalanced = false;

        DoubleNode ans = new DoubleNode();
        ans.height = height;
        ans.isBalanced = isBalanced;
        return ans;
    }

    private static int diameter(BinaryTreeNode<Integer> root){
        if (root == null)
            return 0;

        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return 1 + Math.max(option1, Math.max(option2, option3));
    }

    private static DiameterNode diameterOptimized(BinaryTreeNode<Integer> root){
        if (root == null){
            DiameterNode ans = new DiameterNode();
            ans.height = 0;
            ans.diameter = 0;
            return ans;
        }

        DiameterNode left = diameterOptimized(root.left);
        DiameterNode right = diameterOptimized(root.right);
        int overallHeight = 1 + Math.max(left.height, right.height);

        int option1 = left.height + right.height;
        int option2 = left.height;
        int option3 = right.height;
        int output = Math.max(option1, Math.max(option2, option3));

        DiameterNode ans = new DiameterNode();
        ans.height = overallHeight;
        ans.diameter = output;
        return ans;
    }

    private static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = sc.nextInt();

        if (rootData == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

            System.out.println("Enter left child of " + frontNode.data);
            int leftData = sc.nextInt();

            if (leftData != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftData);
                frontNode.left = leftChild;
                pendingNodes.add(leftChild);
            }

            System.out.println("Enter right child of " + frontNode.data);
            int rightData = sc.nextInt();

            if (rightData != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightData);
                frontNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }
        return root;
    }

    private static void printLevelWise(BinaryTreeNode<Integer> root){
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
            System.out.print(frontNode.data + " : ");

            if (frontNode.left != null){
                System.out.print("L" + frontNode.left.data + ", ");
                pendingNodes.add(frontNode.left);
            }

            if (frontNode.right != null){
                System.out.print("R" + frontNode.right.data);
                pendingNodes.add(frontNode.right);
            }
            System.out.println();
        }
    }

    private static BinaryTreeNode<Integer> buildUsingInPreTreeHelper(int[] inOrder, int[] preOrder, int siIn, int eiIn, int siPre, int eiPre){
        if (siIn > eiIn)
            return null;

        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for (int i = 0; i <= eiIn; i++){
            if (rootData == inOrder[i]){
                rootIndex = i;
                break;
            }
        }

        int siLeftIn = siIn;
        int eiLeftIn = rootIndex - 1;
        int siRightIn = rootIndex + 1;
        int eiRightIn = eiIn;


        int siLeftPre = siPre + 1;
        int eiRightPre = eiPre;

        int leftSubTreeLength = eiLeftIn - siLeftIn + 1;
        int eiLeftPre = siLeftPre + leftSubTreeLength - 1;
        int siRightPre = eiLeftPre + 1;

        BinaryTreeNode<Integer> leftTree = buildUsingInPreTreeHelper(inOrder, preOrder, siLeftIn, eiLeftIn, siLeftPre, eiRightPre);
        BinaryTreeNode<Integer> rightTree = buildUsingInPreTreeHelper(inOrder, preOrder, siRightIn, eiRightIn, siRightPre, eiRightPre);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    private static BinaryTreeNode<Integer> buildUsingInPreTree(int[] inOrder, int[] preOrder){
        return buildUsingInPreTreeHelper(inOrder, preOrder, 0, inOrder.length-1, 0, preOrder.length - 1);
    }

    private static BinaryTreeNode<Integer> buildTreeHelper(int[] inOrder, int siIn, int eiIn, int[] postOrder, int siPost, int eiPost){
        if (siIn > eiIn || siPost > eiPost)
            return null;

        int rootData = postOrder[eiPost];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for (int i = 0; i <= eiIn; i++){
            if (rootData == inOrder[i]){
                rootIndex = i;
                break;
            }
        }

        int leftInSi = siIn;
        int leftInEi = rootIndex - 1;
        int rightInSi = rootIndex + 1;
        int rightInEi = eiIn;

        int leftPostSi = siPost;
        int rightPostEi = eiPost - 1;

        int leftSubTreeLength = leftInEi - leftInSi + 1;
        int leftPostEi = leftSubTreeLength + leftPostSi - 1;
        int rightPostSi = leftPostEi + 1;

        BinaryTreeNode<Integer> left = buildTreeHelper(inOrder, leftInSi, leftInEi, postOrder, leftPostSi, leftPostEi);
        BinaryTreeNode<Integer> right = buildTreeHelper(inOrder, rightInSi, rightInEi, postOrder, rightPostSi, rightPostEi);

        root.left = left;
        root.right = right;
        return root;
    }

    private static BinaryTreeNode<Integer> buildTreeUsingInPost(int[] inOrder, int[] postOrder){
        return buildTreeHelper(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1);
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = takeInputBetter(true, false, 0);
        printTreeDetailed(root);
        System.out.println(isPresent(root, 12));
        printNoSiblings(root);
        System.out.println();
        printAtDepthK(root, 2);
        root = replaceDepth(root, 0);
        printTreeDetailed(root);
        System.out.println();
        root = removeLeafNodes(root);
        printTreeDetailed(root);
        mirrorTree(root);
        printTreeDetailed(root);
        System.out.println(isBalanced(root));
        System.out.println("Is Balanced : " + isBalancedBetter(root).isBalanced);
        System.out.println("Diameter : " + diameter(root));

        BinaryTreeNode<Integer> newRoot = takeInputLevelWise();
//        printTreeDetailed(root);
        printLevelWise(newRoot);
        System.out.println("Diameter : " + diameterOptimized(root).diameter);

        int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] preOrder = { 1, 2, 4, 5, 3, 6, 7 };
//        BinaryTreeNode<Integer> root = buildUsingInPreTree(inOrder, preOrder);
        printLevelWise(root);

//        int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
//        int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };


//        int[] inOrder = { 10, 8, 14, 11, 16, 15, 17, 7, 12, 9, 13 };
        int[] postOrder = { 10, 14, 16, 17, 15, 11, 8, 12, 13, 9, 7 };

        BinaryTreeNode<Integer> rootNew = buildTreeUsingInPost(inOrder, postOrder);
        printLevelWise(rootNew);
    }
}

