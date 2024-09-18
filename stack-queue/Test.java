public class Test {
    public static void main(String[] args){
        // Testing data
        Fraction fractionOne = new Fraction(1, 2);
        Fraction fractionTwo = new Fraction(1, 3);
        Fraction fractionThree = new Fraction(1, 4);
        Fraction fractionFour = new Fraction(1, 5);

        // Test stack
        MyStack<Fraction> fractionStack = new MyStack<Fraction>();

        fractionStack.push(fractionOne);
        fractionStack.push(fractionTwo);
        fractionStack.push(fractionThree);
        fractionStack.push(fractionFour);
        System.out.println("Testing stack: ");
        
        fractionStack.print();
        System.out.println("Peek1: " + fractionStack.getPeek());

        fractionStack.pop();
        System.out.println("Peek2: " + fractionStack.getPeek());

        // test queue
        MyQueue<Fraction> fractionQueue = new MyQueue<Fraction>();
        fractionQueue.enQueue(fractionOne);
        fractionQueue.enQueue(fractionTwo);
        fractionQueue.enQueue(fractionThree);
        fractionQueue.enQueue(fractionFour);

        System.out.println("Testing queue: ");
        fractionQueue.print();
        
        System.out.println("Front1: " + fractionQueue.getFront());
        fractionQueue.deQueue();

        System.out.println("Front2: " + fractionQueue.getFront());

        System.out.println("Testing queue: ");
        fractionQueue.print();
	}
}
