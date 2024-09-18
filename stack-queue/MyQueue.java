import java.util.NoSuchElementException;

public class MyQueue<T> implements QueueInterface<T> {
    Node<T> front;
    Node<T> back;
    int totalNodes;

    public void enQueue(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
            totalNodes++;
            return;
        }

        back.setNext(newNode);
        back = newNode;
        totalNodes++;
    };

    public T deQueue() throws NoSuchElementException {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }

        T deQueuedData = this.front.data; 
        this.front = this.front.getNext();
        totalNodes--;

        return deQueuedData;
    };

    public int size() {
        return totalNodes;
    };

    public boolean constains (T data) {
        Node<T> temp = this.front;

        if (size() > 0) {
            for(int k=0;k<size();k++) {
                if (temp.data == data) {
                    return true;
                }
                temp = temp.next;
            }
        }

        return false;
    };

    public boolean isEmpty() {
        return this.front == null;
    }

    public T getFront() {
        return this.front.data;
    };

    public void print() {
        Node<T> temp = this.front;
        if (size()>0) {
            for(int k=0;k<size();k++) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
        }
        System.out.println("");
    };

}
