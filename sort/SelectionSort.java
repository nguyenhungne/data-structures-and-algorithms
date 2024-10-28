public class SelectionSort {
    public static void selectionSort(int[] array) {
        int arrayLength = array.length;

        for(int i = 0; i < arrayLength; i++ ) {
            int minIndex = i;

            // find the minimum element in the unsorted array
            for (int j = i + 1; j < arrayLength; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
            }

            // swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] testArray = { 37, 27, 43, 3, 9, 82, 10 };
        selectionSort(testArray);

        for (int element : testArray) {
            System.out.println(element);
        }
	}
}
