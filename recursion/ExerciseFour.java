public class ExerciseFour {
    // Util:
    public static int  factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * factorial(number-1);
    }

    // Exercise A
    public static int expressionA(int i) {
        return 2*i + 1;
    }
    public static int exerciseA(int number) {
        if (number == 1) {
            return expressionA(number);
        }

        return expressionA(number) + exerciseA(number - 1);
    }

    // Exercise B
    public static int expressionB(int i) {
        return factorial(i);
    }
    public static int exerciseB(int number) {
        if (number == 1) {
            return expressionB(number);
        }

        return expressionB(number) + exerciseB(number - 1);
    }

    // Exercise C
    public static int expressionC(int i) {
        return factorial(i);
    }
    public static int exerciseC(int number) {
        if (number == 1) {
            return expressionC(number);
        }

        return expressionC(number) * exerciseC(number - 1);
    }

    // Exercise D
    public static int exerciseD(int n, int r) {
        if (r == 0) {
            return 1;
        }
        
        return n * exerciseD(n - 1, r - 1);
    }

    // Exercise E
    public static int exerciseE(int n) {
        if (n == 1) {
            return 3;
        }
        
        return (int)Math.pow(2, n) + n * n + exerciseE(n - 1);
    }


    public static void main(String[] args){
        // Test exercise a
        int testExerciseANumber = 3;
        System.out.print(exerciseA(testExerciseANumber));
	}
}
