import java.util.Stack;

public class QueueWithTwoStacks<T> {
    Stack<T> stack1;  // Input stack for enqueue
    Stack<T> stack2;  // Output stack for dequeue
    
    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void enqueue(T data) {
        stack1.push(data);
    }
    
    public T dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        
        // Pop from stack2, which represents the front of the queue
        return stack2.pop();
    }
    
    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue());  // Output: 1
        System.out.println(queue.dequeue());  // Output: 2
        
        queue.enqueue(4);
        
        System.out.println(queue.dequeue());  // Output: 3
        System.out.println(queue.dequeue());  // Output: 4
        
    }
}
