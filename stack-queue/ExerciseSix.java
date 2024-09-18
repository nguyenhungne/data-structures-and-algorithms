public class ExerciseSix {
    public boolean isPalindrome(String word) {
        MyStack<Character> stack = new MyStack<Character>();
        MyQueue<Character> queue = new MyQueue<Character>();
        
        for (char character : word.toCharArray()) {
            stack.push(character);
            queue.enQueue(character);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.deQueue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ExerciseSix exerciseSix = new ExerciseSix();
        System.out.println(exerciseSix.isPalindrome("racecar"));  // Output: true
        System.out.println(exerciseSix.isPalindrome("hello"));  // Output: false
    }
}
