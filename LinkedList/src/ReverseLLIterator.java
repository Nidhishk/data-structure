import java.util.LinkedList;

/**
 * Time Complexity :: O(n)
 * Space Complexity :: O(1)
 */
public class ReverseLLIterator {
    Node head;

    public static void main(String[] args) {
        ReverseLLIterator ll = new ReverseLLIterator();
        ll.addLast("1");
        ll.addLast("2");
        ll.addLast("3");
        ll.addLast("4");
        ll.addLast("5");

        ll.reverseList();
        ll.printList();
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

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // Update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("null");
    }
}
