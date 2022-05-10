import java.util.Scanner;

public class LinkedListUse2 {
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
        if (head != null){
            Node<Integer> temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    private static int findNode(Node<Integer> head, int data){
        if (head == null)
            return -1;

        Node<Integer> temp = head;
        int index = 0;
        while (temp != null){
            if (temp.data == data)
                return index;
            index++;
            temp = temp.next;
        }
        return -1;
    }

    private static Node<Integer> appendLastN(Node<Integer> head, int n){
        if (head == null || n == 0)
            return head;

        Node<Integer> current = head;
        Node<Integer> nextNode = null;
        int count = 1;
        while (current != null && count < n){
            current = current.next;
            count++;
        }
        if (current != null) {
            nextNode = current.next;
            current.next = null;
            Node<Integer> temp = nextNode;
            while (temp.next != null)
                temp = temp.next;
            temp.next = head;
            head = nextNode;
        }
        return head;
    }

    private static Node<Integer> removeDuplicates(Node<Integer> head){
        if (head == null || head.next == null)
            return head;

        Node<Integer> temp = head;
        while(temp.next != null){
            if (temp.data.equals(temp.next.data))
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }

    private static Node<Integer> removeDupRec(Node<Integer> head){
        if (head == null || head.next == null)
            return head;

        Node<Integer> newHead = removeDuplicates(head.next);
        if (head.data.equals(newHead.data))
            return newHead;
        else{
            head.next = newHead;
            return head;
        }
    }

    private static void printReverse(Node<Integer> head){
        if (head == null)
            return;
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    private static int length(Node<Integer> head){
        if (head == null)
            return 0;

        Node<Integer> temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    private static Node<Integer> reverse(Node<Integer> head){
        if (head == null || head.next == null)
            return head;

        Node<Integer> lastNode = head.next;
        Node<Integer> newHead = reverse(head.next);
        lastNode.next = head;
        head.next = null;
        return newHead;
    }

    private static boolean isPalindrome(Node<Integer> head){
        if (head == null || head.next == null)
            return true;

        int length = length(head);
        int mid = length / 2;
        Node<Integer> current = head;
        int count = 0;
        while (current != null && count < mid){
            current = current.next;
            count++;
        }
        current = reverse(current);
        Node<Integer> temp = head;
        while (temp != current && current != null){
            if (!temp.data.equals(current.data))
                return false;
            temp = temp.next;
            current = current.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printList(head);
        System.out.println();
//        System.out.println("Pos : " + findNode(head, 8));
//        head = appendLastN(head, 3);
//        printList(head);
//        head = removeDuplicates(head);
//        head = removeDupRec(head);
//        printReverse(head);
//        printList(head);
        System.out.println(isPalindrome(head));
    }
}
