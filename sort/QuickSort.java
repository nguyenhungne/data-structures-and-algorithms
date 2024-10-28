public class QuickSort {
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        // Find the position of the pivot element
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Place the pivot in its correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] testArray = { 37, 27, 43, 3, 9, 82, 10 };
        quickSort(testArray, 0, testArray.length - 1);

        for (int element : testArray) {
            System.out.println(element);
        }
    }
}
