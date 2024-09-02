public class ReverseLLRecursion {
    Node head;

    public static void main(String[] args) {

    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public Node reverseRecursive(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
