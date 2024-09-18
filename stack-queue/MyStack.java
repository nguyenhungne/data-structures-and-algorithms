import java.util.NoSuchElementException;

public class MyStack<T> implements StackInterface<T> {
    Node<T> top;
    int totalNodes;

    public MyStack() {
        this.top = null;
        this.totalNodes = 0;
    }

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(this.top);
        this.top = newNode;
        this.totalNodes++;
    }

    public T pop() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        T poppedData = this.top.getData();
        this.top = this.top.getNext();
        this.totalNodes--;
        
        return poppedData;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.totalNodes;
    }

    public T getPeek() {
        return this.top.data;
    }

    public void print() {
        Node<T> currentNode = this.top;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}
