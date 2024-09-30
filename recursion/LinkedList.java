public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // (a)
    public Node addSortedList(Node current, int item) {
        if (current == null || current.data >= item) {
            Node newNode = new Node(item);
            newNode.next = current;
            return newNode;
        }

        current.next = addSortedList(current.next, item);
        return current;
    }

    public void addSortedList(int item) {
        head = addSortedList(head, item);
    }

    public int countEvenNumbers(Node current) {
        if (current == null) {
            return 0;
        }

        int count = (current.data % 2 == 0) ? 1 : 0;
        return count + countEvenNumbers(current.next);
    }

    public int countEvenNumbers() {
        return countEvenNumbers(head);
    }

    public int sumAllNumbers(Node current) {
        if (current == null) {
            return 0;
        }

        return current.data + sumAllNumbers(current.next);
    }

    public int sumAllNumbers() {
        return sumAllNumbers(head);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // (a) Add elements to the linked list recursively in sorted order
        list.addSortedList(10);
        list.addSortedList(3);
        list.addSortedList(5);
        list.addSortedList(7);
        list.addSortedList(8);
        System.out.print("Linked list: ");
        list.printList();

        // (b) Count even numbers using recursion
        int evenCount = list.countEvenNumbers();
        System.out.println("Even numbers count (recursively): " + evenCount);

        // (b) Sum all numbers using recursion
        int sum = list.sumAllNumbers();
        System.out.println("Sum of all numbers (recursively): " + sum);
    }
}
