import java.util.NoSuchElementException;

public class MinHeap {
    int[] heap;
    int heapSize;
    int maxSize; // maximum size to initialize an heap array

    public MinHeap(int capacity) {
        heapSize = 0;
        this.maxSize = capacity;
        heap = new int[maxSize + 1];
        heap[0] = -1;
    }

    // You need some methods to access the parent and childs index.
    public int parent(int i) {
        return i / 2;
    }

    public int leftChild(int i) {
        return 2 * i;
    }

    public int rightChild(int i) {
        return 2 * i + 1;
    }

    private void shiftUp(int i) {
        while (i > 1 && heap[parent(i)] > heap[i]) {
            Utils.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    private void shiftDown(int i) {
        while (i <= heapSize) {
            int minV = heap[i];
            int minId = i;
            
            if (leftChild(i) <= heapSize && minV > heap[leftChild(i)]) {
                minV = heap[leftChild(i)];
                minId = leftChild(i);
            }
            
            if (rightChild(i) <= heapSize && minV > heap[rightChild(i)]) {
                minV = heap[rightChild(i)];
                minId = rightChild(i);
            }
            
            if (minId != i) {
                Utils.swap(heap, i, minId);
                i = minId;
            } else {
                break;
            }
        }
    }

    public void insert(int key) {
        if (heapSize == maxSize) {
            throw new NoSuchElementException("Overflow Exception");
        }
        heapSize++;
        int i = heapSize;
        heap[i] = key;
        shiftUp(i);
    }

    public int extractMin() {
        if (heapSize == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        int minV = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return minV;
    }

    public static int[] heapSort(int[] arr){
        // Build a min heap from the array
        MinHeap minHeap = new MinHeap(arr.length);
        for (int i = 0; i < arr.length; i++){
            minHeap.insert(arr[i]);
        }
        // Extract elements from the heap one by one
        for (int i = 0; i < arr.length; i++){
            arr[i] = minHeap.extractMin();
        }
        return arr;
    }
}
