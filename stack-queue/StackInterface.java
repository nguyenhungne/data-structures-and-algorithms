import java.util.NoSuchElementException;

public interface StackInterface<T> {
    public Node<T> getTop();
    public void setTop(Node<T> top);

    public void push(T data);
    public T pop() throws NoSuchElementException;
    public int size();
    public boolean isEmpty();
    public T getPeek();
    public void print();
}
