import java.util.NoSuchElementException;

public class MyLinkedList<T> implements IMyLinkedList<T> {
    protected Node<T> head;
    protected int totalNodes;

    public MyLinkedList() {
        this.head = null;
        this.totalNodes = 0;
    }

    public int getSize() {
        return this.totalNodes;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getFirst() throws NoSuchElementException {
        if (this.head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        return this.head;
    }

    public boolean contains(T data) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.totalNodes++;
    }

    public void addAfter(Node<T> currentNode, T data) {
        if (currentNode == null) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<T>(data);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        this.totalNodes++;
    }

    public void addLast(T data) {
        if (this.head == null) {
            addFirst(data);
            return;
        }

        Node<T> currentNode = this.head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        Node<T> newNode = new Node<T>(data);
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

    public void removeAfter(Node<T> currentNode) throws NoSuchElementException {
        if (currentNode == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        if (currentNode.getNext() == null) {
            throw new NoSuchElementException("The current node is the last node.");
        }

        currentNode.setNext(currentNode.getNext().getNext());
        this.totalNodes--;
    }

    public void removeCurrent(Node<T> currentNode) throws NoSuchElementException {
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

        Node<T> deleteCurrent = head;

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

        Node<T> currentNode = this.head;
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(null);
        this.totalNodes--;
    }

    public void print() {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}
