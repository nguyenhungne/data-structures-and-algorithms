public class Exercise4 {
    static class Person {
        String name;
        int priority;
        
        Person(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        // Create MaxHeap for priority queue (higher priority = higher number)
        MaxHeap priorityQueue = new MaxHeap(10);
        
        // Initial enqueue operations
        enqueueAndPrint("Alex", 3, priorityQueue);
        enqueueAndPrint("Bob", 2, priorityQueue);
        enqueueAndPrint("David", 6, priorityQueue);
        enqueueAndPrint("Susan", 1, priorityQueue);
        
        // First dequeue
        System.out.println("\nDequeue: " + dequeue(priorityQueue));
        
        // Second set of enqueue operations
        enqueueAndPrint("Mike", 5, priorityQueue);
        enqueueAndPrint("Kevin", 4, priorityQueue);
        
        // Second dequeue
        System.out.println("\nDequeue: " + dequeue(priorityQueue));
        
        // Third dequeue
        System.out.println("\nDequeue: " + dequeue(priorityQueue));
        
        // Final set of enqueue operations
        enqueueAndPrint("Helen", 0, priorityQueue);
        enqueueAndPrint("Paul", 8, priorityQueue);
        enqueueAndPrint("Iris", 7, priorityQueue);
        
        // Final dequeue
        System.out.println("\nDequeue: " + dequeue(priorityQueue));
        
        System.out.println("\nFinal 4 persons dequeued.");
    }
    
    private static void enqueueAndPrint(String name, int priority, MaxHeap queue) {
        queue.insert(priority);
        System.out.println("Enqueued: " + name + " (Priority: " + priority + ")");
    }
    
    private static int dequeue(MaxHeap queue) {
        return queue.extractMax();
    }
}
