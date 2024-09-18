public class ExerciseTwo {
    public static int SolveExpressionUsingStack(int n) {
        // *Note: This is a expression that can be solved using a stack
        // f(n) = 3, if n = 1
        // f(n) = f(n - 1) + 2^n + n^2, if n > 1

        MyStack<Integer> stack = new MyStack<Integer>();
        int result = 0;

        // Simulate the recursive function using a stack
        while (n > 1) {
            stack.push(n);
            n--;
        }

        // Base case
        result = 3;

        // Calculate the result
        while (!stack.isEmpty()) {
            n = stack.pop();
            result += (Math.pow(2, n) + Math.pow(n, 2));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(SolveExpressionUsingStack(3));
    }
}
