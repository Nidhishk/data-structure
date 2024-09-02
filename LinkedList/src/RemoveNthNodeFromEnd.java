import java.util.LinkedList;

/*
Find Nth node from Last + delete Nth node
 */
public class RemoveNthNodeFromEnd {
    static Node head;

    public static void main(String[] args) {
        RemoveNthNodeFromEnd list = new RemoveNthNodeFromEnd();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");

        int n = 2;
        Node start = removeNthNodeFromEnd(head, n);

        while (start != null) {
            System.out.print(start.data + " -> ");
            start = start.next;
        }
        System.out.print("null");
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

    public static Node removeNthNodeFromEnd(Node head, int n) {
        int size = 0;

        // Size
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }

        // Find the nth node from the last
        int indexToSearch = size - n;

        // prev.next = prev.next.next
        Node prevNode = head;
        int i = 1;

        while (i < indexToSearch) {
            prevNode = prevNode.next;
            i++;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }
}
