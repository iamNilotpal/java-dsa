public class DeleteNode {
    BinaryTreeNode<Integer> node;
    boolean isDeleted;

    DeleteNode(BinaryTreeNode<Integer> root, boolean isDeleted){
        node = root;
        this.isDeleted = isDeleted;
    }
}
