public class Utils {
    public Utils(){}

    // And the method to help us swap two values in an array.
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
