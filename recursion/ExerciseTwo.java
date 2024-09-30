public class ExerciseTwo {
    public static int  factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * factorial(number-1);
    }

    public static int computePowerOf(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x* computePowerOf(x, n - 1);
    }

    public static int CountNumberDigitsPositiveInteger(int number) {
        if (number == 0) {
            return 0;
        }

        return 1 + CountNumberDigitsPositiveInteger(number / 10);
    }

    public static int  findGreatestCommonDivisor(int x, int y) {
        if (y == 0) {
            return x;
        }

        return findGreatestCommonDivisor(y, x % y);
    }

    public static void main(String[] args){
        // Test factorial
        int n = 6;
		System.out.println(factorial(n));
        
        // Test computePowerOf
        int testX = 3;
        int testN = 2;
		System.out.println(computePowerOf(testX, testN));

        // Test CountNumberDigitsPositiveInteger
        int testPositiveInteger = 34324;
		System.out.println(CountNumberDigitsPositiveInteger(testPositiveInteger));

        // Test findGreatestCommonDivisor
        int testFindGreatestCommonDivisorNumber1 = 4;
        int testFindGreatestCommonDivisorNumber2 = 2;
		System.out.println(findGreatestCommonDivisor(testFindGreatestCommonDivisorNumber1, testFindGreatestCommonDivisorNumber2));
	}
}
