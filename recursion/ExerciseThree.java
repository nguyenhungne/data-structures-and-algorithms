public class ExerciseThree {
    public static boolean checkIsPrime(int number, int index) {
        if (number <= 2) {
            return (number == 2) ? true : false;
        }

        if (number % index == 0) {
            return false;
        }

        if (index * index > number) {
            return true;
        }
        return checkIsPrime(number, index + 1);
    }

    public static void main(String[] args){
         // Test checkIsPrime
         int initialIndex = 2;
         int testIsPrimeNumber = 13;
         System.out.println(checkIsPrime(testIsPrimeNumber, initialIndex));
	}
}
