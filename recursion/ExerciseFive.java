public class ExerciseFive {
    public static int decimalToBinary(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 2 + 10 * decimalToBinary(n / 2);
    }

    public static void main(String[] args) {
        int decimalNumber = 8;
        int binaryNumber = decimalToBinary(decimalNumber);
        System.out.println("Decimal number " + decimalNumber + " is equal to binary number " + binaryNumber);
    }
}
