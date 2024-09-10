import java.util.NoSuchElementException;

public interface IMyLinkedList<T> {
    public void addFirst(T data);
    public void addAfter(Node<T> currentNode, T data);
    public void addLast(T data);

    public void removeFirst() throws NoSuchElementException;
    public void removeAfter(Node<T> currentNode) throws NoSuchElementException;
    public void removeLast() throws NoSuchElementException;
    public void removeCurrent(Node<T> currentNode) throws NoSuchElementException;

    public int getSize();
    public boolean isEmpty();
    public Node<T> getHead();
    public Node<T> getFirst() throws NoSuchElementException;
    public boolean contains(T data);

    public void print();
}
