public class InsertionSort {

    public static void insertionSort(int[] array) {
        int arrayLeng = array.length;

        for (int i = 1; i < arrayLeng; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] >key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

    }

    public static void main(String[] args) {
        int[] testArray = { 37, 27, 43, 3, 9, 82, 10 };
        insertionSort(testArray);

        for (int element : testArray) {
            System.out.println(element);
        }
	}
}
