import java.util.Scanner;

public class LinkedListUse3 {

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

    private static Node<Integer> evenAfterOdd(Node<Integer> head){
        if (head == null || head.next == null)
            return head;

        Node<Integer> evenHead = null;
        Node<Integer> evenTail = null;
        Node<Integer> oddHead = null;
        Node<Integer> oddTail = null;
        Node<Integer> current = head;

        while (current != null){
            if (current.data % 2 == 0){
                if (evenHead == null){
                    evenHead = current;
                }
                else{
                    evenTail.next = current;
                }
                evenTail = current;
            }
            else{
                if (oddHead == null)
                    oddHead = current;
                else
                    oddTail.next = current;
                oddTail = current;
            }
            current = current.next;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
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

    private static Node<Integer> deleteNMNodes(Node<Integer> head, int m, int n){
        int length = length(head);
        if (n > length || m > length || head == null)
            return head;

        Node<Integer> current = head;
        int count = 0;
        while (current != null){
            count++;
            if (count == m){
                Node<Integer> temp = current.next;
                int pos = 1;
                while (temp != null && pos < n){
                    temp = temp.next;
                    pos++;
                }
                if (temp != null)
                    current.next = temp.next;
                count = 0;
            }
            current = current.next;
        }
        return head;
    }

    private static Node<Integer> swapTwoNodes(Node<Integer> head, int i, int j){
        if ((head == null || head.next == null) && (i > 1 || j > 1))
            return head;

        Node<Integer> current = head;
        Node<Integer> currentPrev = null;
        int count = 1;
        while (current != null){
            count++;
            if (count == i){
                Node<Integer> temp = null;
                Node<Integer> tempNext = current;

                while (tempNext != null && count <= j){
                    tempNext = tempNext.next;
                    temp = tempNext;
                    count++;
                }
                if (tempNext != null && currentPrev != null && temp != null){
                    Node<Integer> temp2 = current.next;
                    Node<Integer> temp3 = tempNext.next;
                    currentPrev.next = tempNext;
                    tempNext.next = temp2;
                    temp.next = current;
                    current.next = temp3;
                }
                count = 1;
            }
            currentPrev = current;
            current = current.next;
        }
        return head;
    }

    private static Node<Integer> kReverse(Node<Integer> head, int k){
        int length = length(head);
        if (head == null || head.next == null || k > length)
            return head;
        int count = 1;
        Node<Integer> current = head;
        Node<Integer> reverseHead = head;
        while (current != null){
            if(count == k){
                reverseHead = current.next;
                Node<Integer> revHead = reverse(reverseHead, current);
                reverseHead.next = current;
                count = 1;
            }
            count++;
            current = current.next;
        }
        return head;
    }

    private static Node<Integer> reverse(Node<Integer> head, Node<Integer> tail){
        if (head == null || tail == null)
            return head;
        Node<Integer> current = head;
        Node<Integer> previous = null;
        Node<Integer> temp = null;

        while (current != tail){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printList(head);
//        head = evenAfterOdd(head);
        System.out.println();
//        head = deleteNMNodes(head, 2, 3);
//        head = swapTwoNodes(head, 2, 4);
        head = kReverse(head, 2);
        printList(head);
    }
}
