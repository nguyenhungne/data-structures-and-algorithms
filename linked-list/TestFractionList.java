public class TestFractionList {
    public static void main(String[] args){
        MyLinkedList<Fraction> fractionLinkedList = new MyLinkedList<Fraction>();
        Fraction fractionOne = new Fraction(1, 2);
        Fraction fractionTwo = new Fraction(1, 3);
        Fraction fractionThree = new Fraction(1, 4);
        Fraction fractionFour = new Fraction(1, 5);
        fractionLinkedList.addFirst(fractionOne);
        fractionLinkedList.addFirst(fractionTwo);
        fractionLinkedList.addFirst(fractionThree);
        fractionLinkedList.addFirst(fractionFour);

        fractionLinkedList.print();
	}
}
