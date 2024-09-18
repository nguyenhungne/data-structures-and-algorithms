public class ExerciseThree {
    public String reverseOrderSentence(String sentence) {
        MyStack<Character> stack = new MyStack<Character>();  // Use Character stack
        for (char character : sentence.toCharArray()) {  // Loop through characters
            stack.push(character);
        }
        
        StringBuilder reversedSentence = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop());
        }
        
        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        ExerciseThree exerciseThree = new ExerciseThree();
        System.out.println(exerciseThree.reverseOrderSentence("Hello World"));  // Output: dlroW olleH
    }
}
