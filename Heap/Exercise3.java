public class Exercise3 {
    public static void main(String[] args) {
        // Original array of numbers from the exercise
        int[] numbers = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        
        System.out.println("Original array:");
        printArray(numbers);

        // Sort ascending using MinHeap
        int[] ascendingOrder = MinHeap.heapSort(numbers.clone());
        System.out.println("\nAscending order (using MinHeap):");
        printArray(ascendingOrder);

        // Sort descending using MaxHeap
        int[] descendingOrder = MaxHeap.heapSort(numbers.clone());
        System.out.println("\nDescending order (using MaxHeap):");
        printArray(descendingOrder);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
