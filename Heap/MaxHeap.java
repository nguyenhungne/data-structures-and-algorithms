import java.util.NoSuchElementException;

public class MaxHeap {
    int[] heap;
    int heapSize;
    int maxSize; // maximum size to initialize an heap array

    public MaxHeap(int capacity) {
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
        while (i > 1 && heap[parent(i)] < heap[i]) {
            Utils.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    private void shiftDown(int i) {
        while (i <= heapSize) {
            int maxV = heap[i];
            int maxId = i;
            
            if (leftChild(i) <= heapSize && maxV < heap[leftChild(i)]) {
                maxV = heap[leftChild(i)];
                maxId = leftChild(i);
            }
            
            if (rightChild(i) <= heapSize && maxV < heap[rightChild(i)]) {
                maxV = heap[rightChild(i)];
                maxId = rightChild(i);
            }
            
            if (maxId != i) {
                Utils.swap(heap, i, maxId);
                i = maxId;
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

    public int extractMax() {
        if (heapSize == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        int maxV = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return maxV;
    }

    public static int[] heapSort(int[] arr){
        // Build a max heap from the array
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++){
            maxHeap.insert(arr[i]);
        }
        // Extract elements from the heap one by one
        for (int i = arr.length - 1; i >= 0; i--){
            arr[i] = maxHeap.extractMax();
        }
        return arr;
    }
}
