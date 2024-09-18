import java.util.Stack;

public class ExerciseFour {
    public static boolean isBalanced(String sequence) {
        Stack<Character> stack = new Stack<>();
        
        for (char character : sequence.toCharArray()) {
            // If it's a left delimiter, push it onto the stack
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } 
            // If it's a right delimiter, check for balance
            else if (character == ')' || character == '}' || character == ']') {
                // If stack is empty or doesn't match, it's unbalanced
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                // If the delimiters don't match, it's unbalanced
                if (!isMatchingPair(top, character)) {
                    return false;
                }
            }
        }
        
        // If stack is empty, it's balanced; otherwise, it's not
        return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char left, char right) {
        boolean isParenthesesPair = (left == '(' && right == ')');
        boolean isBracesPair = (left == '{' && right == '}');
        boolean isBracketsPair = (left == '[' && right == ']');

        return isParenthesesPair || isBracesPair || isBracketsPair;
    }
    
    public static void main(String[] args) {
        String sequence1 = "{[4()]}";  // Balanced
        String sequence2 = "{[(])}";  // Not Balanced
        String sequence3 = "{[}";     // Not Balanced
        
        System.out.println("Is sequence 1 balanced? " + isBalanced(sequence1)); // true
        System.out.println("Is sequence 2 balanced? " + isBalanced(sequence2)); // false
        System.out.println("Is sequence 3 balanced? " + isBalanced(sequence3)); // false
    }
}
