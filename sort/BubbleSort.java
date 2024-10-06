public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] =  temp; 
                }
            } 
        }
    }

    public static void main(String[] args) {
        int[] testArray = { 37, 27, 43, 3, 9, 82, 10 };
        bubbleSort(testArray);

        for (int element : testArray) {
            System.out.println(element);
        }
	}
}