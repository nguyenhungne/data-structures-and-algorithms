import java.util.NoSuchElementException;

public interface QueueInterface<T> {
    public void enQueue(T data);
    public T deQueue() throws NoSuchElementException;
    public int size();
    public boolean constains (T data);
    public boolean isEmpty();
    public T getFront();
    public void print();
}
