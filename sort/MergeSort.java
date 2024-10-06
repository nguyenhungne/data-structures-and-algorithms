public class MergeSort {
    private static void merge(int array[], int left, int middle, int right) {
        // Find sizes of two sub-arrays to be merged
        int size1 = middle - left + 1;
        int size2 = right - middle;

        // Create temporary arrays
        int leftArray[] = new int[size1];
        int rightArray[] = new int[size2];

        // Copy data to temporary arrays
        for (int i = 0; i < size1; ++i) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < size2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        
        // Initial index of merged sub-array array
        int k = left;

        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    public static void main(String[] args) {
        int[] testArray = { 37, 27, 43, 3, 9, 82, 10 };
        mergeSort(testArray, 0, testArray.length - 1);

        for (int element : testArray) {
            System.out.println(element);
        }
    }
}
