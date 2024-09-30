public class ExerciseSeven {
    public static int findMinimumRecursive(int[] array, int size) {
        if (size == 1) {
            return array[0];
        }

        int min = findMinimumRecursive(array, size - 1);

        if (array[size - 1] < min) {
            return array[size - 1];
        } else {
            return min;
        }
    }

    public static int sumArrayRecursive(int[] array, int size) {
        if (size == 0) {
            return 0;
        }

        return array[size - 1] + sumArrayRecursive(array, size - 1);
    }

    public static int countEvenNumbersRecursive(int[] array, int size) {
        if (size == 0) {
            return 0;
        }

        int count = (array[size - 1] % 2 == 0) ? 1 : 0;
        return count + countEvenNumbersRecursive(array, size - 1);
    }

    public static void main(String[] args) {
        int[] array = { 4, 1, 6, 3, 9, 8 }; // Example array
        int size = array.length;

        int min = findMinimumRecursive(array, size);
        System.out.println("Minimum element (recursively): " + min);

        int sum = sumArrayRecursive(array, size);
        System.out.println("Sum of elements (recursively): " + sum);

        int evenCount = countEvenNumbersRecursive(array, size);
        System.out.println("Count of even numbers (recursively): " + evenCount);
    }

}
