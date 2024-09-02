public class ElementManipulation {
    Node head;
    private int size;

    public static void main(String[] args) {
        ElementManipulation list = new ElementManipulation();
        list.addFirst("a");
        list.addFirst("b");
        list.addLast("c");
        list.removeLast();
        list.addElementInMiddle(0, "c");
        list.getSize();
        list.printList();
        System.out.println(list.getSize());
    }

    ElementManipulation() {
        size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
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

    public void addElementInMiddle(int index, String data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index");
            return;
        }

        Node newNode = new Node(data);
        if (index == 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node newNode1 = head;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                Node nextNode = newNode1.next;
                newNode1.next = newNode1;
                newNode1.next = nextNode;
                break;
            }
            newNode1 = newNode1.next;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List if Empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List if Empty");
            return;
        }
        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        Node newNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            newNode = newNode.next;
            lastNode = lastNode.next;
        }
        newNode.next = null;
    }

    public void printList() {
        Node newNode = head;
        while (newNode != null) {
            System.out.print(newNode.data + " -> ");
            newNode = newNode.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}