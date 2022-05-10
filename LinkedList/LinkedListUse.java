import java.util.Scanner;

public class LinkedListUse {

    private static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements");
        int n = sc.nextInt();
        Node<Integer> head = null;
        int i = 1;

        while (i <= n){
            System.out.println("Enter element " + i);
            int data = sc.nextInt();
            Node<Integer> newNode = new Node<>(data);

            if (head == null)
                head = newNode;
            else{
                Node<Integer> temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = newNode;
            }
            i++;
        }
        return head;
    }

    private static void printList(Node<Integer> head){
        if (head == null) {
            return;
        }
        else{
            Node<Integer> temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    private static void incrementData(Node<Integer> head){
        if (head == null)
            return;

        Node<Integer> temp = head;
        while (temp != null){
            temp.data++;
            temp = temp.next;
        }
    }

    private static int length(Node<Integer> head){
        if (head == null)
            return 0;
        else{
            int count = 0;
            Node<Integer> temp = head;
            while(temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    private static void printIthNode(Node<Integer> head, int i){

        if (head != null && i != 0) {
            Node<Integer> temp = head;
            int count = 1;
            while(temp != null && count < i){
                temp = temp.next;
                count++;
            }
            if (temp != null)
                System.out.println(temp.data);
        }
    }

    private static void printIthNodeRec(Node<Integer> head, int i){
        if (head == null || i == 0)
            return;

        if (i == 1)
            System.out.println(head.data);
        else
            printIthNode(head.next, i-1);
    }

    private static Node<Integer> insertNode(Node<Integer> head, int data, int pos){
        if (head == null || pos == 0)
            return head;

        Node<Integer> temp = head;
        int count = 1;
        Node<Integer> newNode = new Node<>(data);

        while(temp != null && count < pos-1){
            temp = temp.next;
            count++;
        }

        if (temp != null){
            newNode.next = temp.next;
            temp.next =newNode;
        }
        return head;
    }

    private static Node<Integer> insertNodeRec(Node<Integer> head, int pos, int data){
        if (head == null || pos == 0)
            return head;

        Node<Integer> newNode = new Node<>(data);
        if (pos == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }
        head.next = insertNodeRec(head.next, pos-1, data);
        return head;
    }

    private static Node<Integer> deleteNode(Node<Integer> head, int pos){
        if (head == null || pos == 0)
            return head;

        Node<Integer> temp = head;
        int count = 1;
        while(temp != null && count < pos-1){
            temp = temp.next;
            count++;
        }

        if (temp != null && temp.next != null)
            temp.next = temp.next.next;
        return head;
    }

    private static Node<Integer> deleteNodeRec(Node<Integer> head, int pos){
        if (head == null || pos == 0)
            return head;

        if (pos == 1) {
            head = head.next;
            return head;
        }
        head.next = deleteNodeRec(head.next, pos-1);
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printList(head);
//        incrementData(head);
        System.out.println();
//        printList(head);
//        System.out.println(length(head));
//        printIthNode(head, 4);
//        printIthNodeRec(head, 5);
//        head = insertNode(head, 10, 5);
//        head = insertNodeRec(head, 5, 10);
//        head = deleteNode(head, 3);
        head = deleteNodeRec(head, 5);
        printList(head);
    }
}
