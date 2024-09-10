import java.util.NoSuchElementException;

public class MyDoubleLinkedList implements IMyDoubleLinkedList {
    protected DoubleNode head;
    protected int totalNodes;

    public MyDoubleLinkedList() {
        this.head = null;
        this.totalNodes = 0;
    }

    public int getSize() {
        return this.totalNodes;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public DoubleNode getHead() {
        return this.head;
    }

    public DoubleNode getFirst() throws NoSuchElementException {
        if (this.head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        return this.head;
    }

    public boolean contains(Double data) {
        DoubleNode currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    public void addFirst(Double data) {
        DoubleNode newNode = new DoubleNode(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.totalNodes++;
    }

    public void addAfter(DoubleNode currentNode, Double data) {
        if (currentNode == null) {
            addFirst(data);
            return;
        }

        DoubleNode newNode = new DoubleNode(data);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        this.totalNodes++;
    }

    public void addLast(Double data) {
        if (this.head == null) {
            addFirst(data);
            return;
        }

        DoubleNode currentNode = this.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        DoubleNode newNode = new DoubleNode(data);
        currentNode.setNext(newNode);
        this.totalNodes++;
    }

    public void removeFirst() throws NoSuchElementException {
        if (this.head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        this.head = this.head.getNext();
        this.totalNodes--;
    }

    public void removeAfter(DoubleNode currentNode) throws NoSuchElementException {
        if (currentNode == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (currentNode.getNext() == null) {
            throw new NoSuchElementException("The current node is the last node.");
        }

        currentNode.setNext(currentNode.getNext().getNext());
        this.totalNodes--;
    }

    public void removeCurrent(DoubleNode currentNode) throws NoSuchElementException {
        if (currentNode == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (head == currentNode) {
            removeFirst();
            return;
        }

        DoubleNode deleteCurrent = head;

        while (deleteCurrent.getNext() != null) {
            if (currentNode == deleteCurrent.getNext()) {
                this.totalNodes--;
                deleteCurrent.next = currentNode.getNext();
                return;
            }
            deleteCurrent = deleteCurrent.getNext();
        }

    }

    public void removeLast() throws NoSuchElementException {
        if (this.head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (this.head.getNext() == null) {
            removeFirst();
            return;
        }

        DoubleNode currentNode = this.head;
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(null);
        this.totalNodes--;
    }

    public void print() {
        DoubleNode currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}
