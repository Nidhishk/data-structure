public class DetectCycle {
    static Node head;

    public static void main(String[] args) {
        DetectCycle list = new DetectCycle();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("3");
        
        // Create a cycle
        Node lastNode = list.getLastNode();
        lastNode.next = list.head.next.next; // Point to 3

        // 1 -> 2 -> 3 -> 4 -> 5 -> 3 -> 4 -> 5 -> 3 -> 4 -> ...
        //list.printList(); // This will print indefinitely if uncommented

        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node hare = head;
        Node turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle) {
                return true;
            }
        }
        return false;
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

    private Node getLastNode() {
        if (head == null) {
            return null;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    public void printList() {
        Node currNode = head;
        int count = 0;
        while (currNode != null && count < 10) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
            count++;
        }
        System.out.println(count == 10 ? "..." : "null");
    }
}
