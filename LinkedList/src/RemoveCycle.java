public class RemoveCycle {
    static Node head;

    public static void main(String[] args) {
        RemoveCycle list = new RemoveCycle();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("3");

        // Create a cycle
        Node lastNode = list.getLastNode();
        lastNode.next = list.head.next.next; // Point to 3

        System.out.println("Before removing cycle:");
        // 1 -> 2 -> 3 -> 4 -> 5 -> 3 -> 4 -> 5 -> 3 -> 4 -> ...
        //list.printList(); // This will print indefinitely if uncommented

        removeCycle(head);
        System.out.println("After removing cycle:");
        list.printList();
    }

    private static void removeCycle(Node head) {
        if (head == null) {
            return;
        }

        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle) {
                break;
            }
        }

        // If no loop exist
        if (hare == null || hare.next == null) {
            return;
        }

        // Move turtle to head, keep hare at meeting point
        turtle = head;

        // If loop starts at head
        if (turtle == hare) {
            while (hare.next != turtle) {
                hare = hare.next;
            }
        } else {
            // Find the start of the loop
            while (turtle.next != hare.next) {
                turtle = turtle.next;
                hare = hare.next;
            }
        }

        // Remove the loop
        hare.next = null;
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
