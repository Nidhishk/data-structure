import java.util.LinkedList;

public class Pallindrome {
    static Node head;

    public static void main(String[] args) {
        Pallindrome list = new Pallindrome();
        list.addLast("1");
        list.addLast("2");
        list.addLast("2");
        list.addLast("1");

        System.out.println(isPallindrome(list));
    }

    private static boolean isPallindrome(Pallindrome list) {
        if (head == null) {
            return true;
        }

        Node middleNode = findMiddle(head);
        Node secondHalfStart = reverseNode(middleNode.next);
        Node firstHalfStart = head;

        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    private static Node findMiddle(Node head) {
        Node hare = head;
        Node tutle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tutle = tutle.next;
        }
        return tutle;
    }

    private static Node reverseNode(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }
}
