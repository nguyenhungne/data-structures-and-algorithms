public class ExerciseSix {
    public static int findMinimum(int[] array, int size) {
        int min = array[0];

        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int sumArray(int[] array, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static int countEvenNumbers(int[] array, int size) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = { 4, 1, 6, 3, 9, 8 };
        int size = array.length;

        int min = findMinimum(array, size);
        System.out.println("Minimum element: " + min);

        int sum = sumArray(array, size);
        System.out.println("Sum of elements: " + sum);

        int evenCount = countEvenNumbers(array, size);
        System.out.println("Count of even numbers: " + evenCount);
    }

}
