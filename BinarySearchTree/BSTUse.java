import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BSTUse {

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

    public static BinaryTreeNode<Integer> takeInput(BinaryTreeNode<Integer> root, int data){

        if (root == null){
            root = new BinaryTreeNode<>(data);
        }
        else{

            if (data >= root.data)
                root.right = takeInput(root.right, data);
            else
                root.left = takeInput(root.left, data);
        }
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null)
            return;

        System.out.print(root.data  + ": ");
        if (root.left != null)
            System.out.print("L" + root.left.data + ", ");

        if (root.right != null)
            System.out.print("R" + root.right.data);
        System.out.println();

        printTree(root.left);
        printTree(root.right);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

            System.out.print(frontNode.data + ": ");

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

    public static boolean search(BinaryTreeNode<Integer> root, int searchElem){
        if (root == null)
            return false;
        else if(root.data == searchElem)
            return true;
        else if(searchElem > root.data)
            return search(root.right, searchElem);
        else
            return search(root.left, searchElem);
    }

    public static void printBetweenK1K2(BinaryTreeNode<Integer> root, int k1, int k2){
        if (root == null)
            return;
        else if (root.data <= k2 && root.data >= k1) {
            System.out.print(root.data + " ");
            printBetweenK1K2(root.left, k1, k2);
            printBetweenK1K2(root.right, k1, k2);
        }
        else if(root.data < k1)
            printBetweenK1K2(root.right, k1, k2);
    }

    public static BinaryTreeNode<Integer> constructBSTHelper(int[] array, int si, int ei){
        if (si > ei)
            return null;
        int mid = (ei + si) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(array[mid]);
        root.left = constructBSTHelper(array, si, mid-1);
        root.right = constructBSTHelper(array, mid+1, ei);
        return root;
    }

    public static BinaryTreeNode<Integer> constructBST(int[] array){
        return constructBSTHelper(array, 0, array.length-1);
    }

    public static int maximum(BinaryTreeNode<Integer> root){
        if (root == null)
            return Integer.MIN_VALUE;

        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int minimum(BinaryTreeNode<Integer> root){
        if (root == null)
            return Integer.MAX_VALUE;

        int leftMin = maximum(root.left);
        int rightMin = maximum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    private static boolean isBST(BinaryTreeNode<Integer> root){
        if (root == null)
            return true;

        int leftMaximum = maximum(root.left);
        if (leftMaximum >= root.data)
            return false;

        int rightMinimum = minimum(root.right);
        if(rightMinimum < root.data)
            return false;

        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);

        return isLeftBST && isRightBST;
    }

    public static DoubleNodeLL<Integer> bstToLL(BinaryTreeNode<Integer> root){
        if (root == null)
            return new DoubleNodeLL<>();

        DoubleNodeLL<Integer> leftList = bstToLL(root.left);
        DoubleNodeLL<Integer> rightList = bstToLL(root.right);
        LinkedListNode<Integer> rootNode = new LinkedListNode<>(root.data);

        DoubleNodeLL<Integer> ans = new DoubleNodeLL<>();
        if (leftList.tail != null)
            leftList.tail.next = rootNode;

        rootNode.next = rightList.head;
        if (leftList.head != null)
            ans.head = leftList.head;
        else
            ans.head = rootNode;

        if (rightList.tail != null)
            ans.tail = rightList.tail;
        else
            ans.tail = rootNode;

        return ans;
    }

    public static void printLinkedList(LinkedListNode<Integer> head){
        if (head == null)
            return;

        LinkedListNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static void traveller(LinkedListNode<Integer> head, LinkedListNode<Integer> node){
        LinkedListNode<Integer> temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    public static LinkedListNode<Integer> levelWiseLL(BinaryTreeNode<Integer> root){
        if (root == null)
            return null;

        LinkedListNode<Integer> head = new LinkedListNode<>(root.data);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode =  pendingNodes.poll();

            if (frontNode.left != null){
                LinkedListNode<Integer> leftNode = new LinkedListNode<>(frontNode.left.data);
                traveller(head, leftNode);
                pendingNodes.add(frontNode.left);
            }

            if (frontNode.right != null){
                LinkedListNode<Integer> rightNode = new LinkedListNode<>(frontNode.right.data);
                traveller(head, rightNode);
                pendingNodes.add(frontNode.right);
            }
        }
        return head;
    }

    public static ArrayList<LinkedListNode<Integer>> linkedListLevelWise(BinaryTreeNode<Integer> root){
        if (root == null)
            return null;

        Queue<BinaryTreeNode<Integer>> pendingNodes =  new LinkedList<>();
        pendingNodes.add(root);

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        ArrayList<LinkedListNode<Integer>> output =  new ArrayList<>();

        int currentLevelNodeRemaining = 1;
        int nextLevelNodeCount = 0;

        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
            LinkedListNode<Integer> node = new LinkedListNode<>(frontNode.data);

            if (head == null){
                head = node;
                tail = node;
            }
            else{
                tail.next = node;
                tail = tail.next;
            }

            if (frontNode.left != null){
                nextLevelNodeCount++;
                pendingNodes.add(frontNode.left);
            }
            if (frontNode.right != null){
                nextLevelNodeCount++;
                pendingNodes.add(frontNode.right);
            }

            currentLevelNodeRemaining--;
            if (currentLevelNodeRemaining == 0){
                output.add(head);
                head = null;
                tail = null;
                currentLevelNodeRemaining = nextLevelNodeCount;
                nextLevelNodeCount = 0;
            }
        }
        return output;
    }

    public static LargestBSTNode largestBST(BinaryTreeNode<Integer> root){
        if (root == null)
            return new LargestBSTNode(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);

        LargestBSTNode leftTree = largestBST(root.left);
        LargestBSTNode rightTree = largestBST(root.right);

        int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));
        int max = Math.max(root.data, Math.max(leftTree.max, rightTree.max));
        boolean isBST = false;
        int height = 0;

        if (leftTree.isBST && rightTree.isBST && root.data > leftTree.max && root.data <= rightTree.min){
            height = 1 + Math.max(leftTree.height, rightTree.height);
            isBST = true;
        }
        else
            height = Math.max(leftTree.height, rightTree.height);

        return new LargestBSTNode(min, max, isBST, height);
    }

//    public static void pairSumBST(BinaryTreeNode<Integer> root, int s){
//        if (root == null)
//            return;
//
//        int remainder =  root.data - s;
//        boolean isPresent = false;
//        if(remainder >=  root.data)
//            isPresent =  search(root.right, remainder);
//        else
//            isPresent =  search(root.left, remainder);
//
//        if (isPresent)
//            System.out.println(root.data + " " +  remainder);
//
//        pairSumBST(root.left, s);
//        pairSumBST(root.right, s);
//    }

//    public static int countNodes(BinaryTreeNode<Integer> root){
//        if (root == null)
//            return 0;
//
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
//
//    public static int[] pairSumBSTHelper(BinaryTreeNode<Integer> root){
//        if (root == null)
//            return new int[1];
//
//        int[] array = pairSumBSTHelper(root.left);
//        int[] ans = new int[array.length + 1];
//        int i = 0;
//        for (; i < array.length; i++)
//            ans[i] = array[i];
//        ans[i] = root.data;
//        ans = pairSumBSTHelper(root.right);
//        return ans;
//    }

//    public static void pairSumBST(BinaryTreeNode<Integer> root, int s) {
//        int[] array = pairSumBSTHelper(root);
//
//        int i = 0;
//        int j = array.length-1;
//
//        while(i < j) {
//            if (array[i] + array[j] > s)
//                j--;
//            else if(array[i] + array[j] < s)
//                i++;
//            else{
//                System.out.println(array[i] + ", " + array[j]);
//                i++;
//                j--;
//            }
//        }
//    }

    public static void main(String[] args) {

//        BinaryTreeNode<Integer> root = takeInput(null, 10);
//        root = takeInput(root, 15);
//        root = takeInput(root, 19);
//        root = takeInput(root, 14);
//        root = takeInput(root, 6);
//        root = takeInput(root, 9);
//        root = takeInput(root, 4);

//        int[] inOrder = { 3, 4, 5, 6, 7, 9, 10 };
//        int[] preOrder = { 6, 4, 3, 5, 9, 7, 10 };
//
//        BinaryTreeNode<Integer> root = buildUsingInPreTree(inOrder, preOrder);
////        printLevelWise(root);
////        System.out.println(search(root, 8));
////        printBetweenK1K2(root, 6, 16);
//
////        BinaryTreeNode<Integer> root = takeInputLevelWise();
////        printLevelWise(root);
//
////        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
////        BinaryTreeNode<Integer> root = constructBST(array);
//
//        printLevelWise(root);
////        System.out.println(isBST(root));
//
//        DoubleNodeLL<Integer> linkedList = bstToLL(root);
//        printLinkedList(linkedList.head);
//
//        BST<Integer> root =  new BST<>();
//        System.out.println(root.size());
//        System.out.println(root.isPresent(10));
//        root.insert(10);
//        root.insert(7);
//        root.insert(13);
//        root.insert(5);
//        root.insert(15);
//        root.insert(11);
//        root.insert(9);
//        root.printTree();
//        System.out.println();
//        System.out.println(root.delete(19));
//        System.out.println(root.delete(13));
//        System.out.println();
//        root.printTree();
//        System.out.println(root.isPresent(11));

        BinaryTreeNode<Integer> root =  takeInputLevelWise();
//        LinkedListNode<Integer> head = levelWiseLL(root);
//        ArrayList<LinkedListNode<Integer>> ans = linkedListLevelWise(root);
//        for (LinkedListNode<Integer> head : ans) {
//            printLinkedList(head);
//            System.out.println();
//        }

//        LargestBSTNode ans = largestBST(root);
//        System.out.println("Min: " + ans.min + " Max: " + ans.max + " IsBST: " + ans.isBST + " Height: " + ans.height);

//        pairSumBST(root, 25);
//        pairSumBST(root, 25);
    }
}
