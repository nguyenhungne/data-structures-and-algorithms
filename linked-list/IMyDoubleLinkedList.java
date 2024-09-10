import java.util.NoSuchElementException;

public interface IMyDoubleLinkedList {
    public void addFirst(Double data);
    public void addAfter(DoubleNode currentNode, Double data);
    public void addLast(Double data);

    public void removeFirst() throws NoSuchElementException;
    public void removeAfter(DoubleNode currentNode) throws NoSuchElementException;
    public void removeLast() throws NoSuchElementException;
    public void removeCurrent(DoubleNode currentNode) throws NoSuchElementException;

    public int getSize();
    public boolean isEmpty();
    public DoubleNode getHead();
    public DoubleNode getFirst() throws NoSuchElementException;
    public boolean contains(Double data);

    public void print();
}
