import java.util.NoSuchElementException;

public class IntegerLinkedList extends MyLinkedList<Integer> {
    public int countEvenNumber() {
        int count = 0;
        Node<Integer> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getData() % 2 == 0) {
                count++;
            }
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public boolean checkIsPrimeUtil(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
     }

     public int countPrimeNumber() {
         int count = 0;
         Node<Integer> currentNode = head;
         while (currentNode.getNext() != null) {
             if (checkIsPrimeUtil(currentNode.getData())) {
                 count++;
             }
             currentNode = currentNode.getNext();
         }
         return count;
     }

     public void addBeforeFirstEvenNumber(int data) throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }
         Node<Integer> currentNode = head;
         while (currentNode.getNext() != null) {
             if (currentNode.getData() % 2 == 0) {
                 Node<Integer> newNode = new Node<Integer>(data);
                 newNode.setNext(currentNode);
                 head = newNode;
                 return;
             }
             currentNode = currentNode.getNext();
         }
     }

     public int findMaximum() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }

         Node<Integer> currentNode = head;
         int max = currentNode.getData();
        //  loop from the second node
         currentNode = currentNode.getNext();
         while (currentNode.getNext() != null) {
             if (currentNode.getData() > max) {
                 max = currentNode.getData();
             }
             currentNode = currentNode.getNext();
         }
         return max;
     }

    //  Reverse the list without using temporary list.
        public void reverse() {
            Node<Integer> currentNode = head;
            Node<Integer> prevNode = null;
            Node<Integer> nextNode = null;
            while (currentNode != null) {
                nextNode = currentNode.getNext();
                currentNode.setNext(prevNode);
                prevNode = currentNode;
                currentNode = nextNode;
            }
            head = prevNode;
        }

    // Sort the list in ascending order.
        public void sort() {
            Node<Integer> currentNode = head;
            Node<Integer> nextNode = null;
            int temp;
            while (currentNode != null) {
                nextNode = currentNode.getNext();
                while (nextNode != null) {
                    if (currentNode.getData() > nextNode.getData()) {
                        temp = currentNode.getData();
                        currentNode.setData(nextNode.getData());
                        nextNode.setData(temp);
                    }
                    nextNode = nextNode.getNext();
                }
                currentNode = currentNode.getNext();
            }
        }
}
// data-structure-and-algorithms