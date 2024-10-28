import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree (Node rootNode) {
        this.root = rootNode;
    }

    private Node insert(Node currentTreeRoot, Integer data) {
        if (currentTreeRoot == null) {
            return new Node(data);
        }

        int compareValue = -1;

        if (currentTreeRoot.key != null) {
            compareValue = data.compareTo(currentTreeRoot.key);
        }

        if (compareValue < 0) {
            currentTreeRoot.left = insert(currentTreeRoot.left, data);
        } else if (compareValue > 0) {
            currentTreeRoot.right = insert(currentTreeRoot.right, data);
        } else {
            currentTreeRoot.key = data;
        }

        return currentTreeRoot;
    }

    public void insert(Integer key) {
        insert(this.root, key);
    }

    private void NLR(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            NLR(root.left);
            NLR(root.right);
        }
    }

    private void LNR(Node root) {
        if (root != null) {
            LNR(root.left);
            System.out.print(root.key + " ");
            LNR(root.right);
        }
    }

    private void LRN(Node root) {
        if (root != null) {
            LRN(root.left);
            LRN(root.right);
            System.out.print(root.key + " ");
        }
    }

    private Node search(Node root, Integer key) {
        if (root == null) {
            return root;
        }

        int compareValue = -1;

        if (root.key != null) {
            compareValue = key.compareTo(root.key);
        }

        if (compareValue < 0) {
            return search(root.left, key);
        } else if (compareValue > 0) {
            return search(root.right, key);
        }

        // Equal
        return root;
    }

    private Node findMinimum(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left == null) {
            return root;
        }

        return findMinimum(root.left);
    }

    private Node deleteMinimum(Node root) {
        if (root.left == null) {
            return root.right;
        }

        root.left = deleteMinimum(root.left);
        return root;
    }

    private Node delete(Node root, Integer key) {
        if (root == null) {
            return root;
        }

        int compareValue = key.compareTo(root.key);

        if (compareValue < 0) {
            root.left = delete(root.left, key);
        } else if (compareValue > 0) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: No child or only one child
            if (root.left == null) {
                return root.right;
            } 
            
            if (root.right == null) {
                return root.left;
            }

            // Case 2: Two children: Replace with the minimum node in the right subtree successor 
            // because it is greater than all nodes in the left subtree and smaller than all nodes in the right subtree
            // it will have at most one child (right child)
            root.key = findMinimum(root.right).key;
            root.right = deleteMinimum(root.right);
        }

        return root;
    }

    public Node search(Integer key) {
        return search(this.root, key);
    }

    public Node findMinimum() {
        return findMinimum(this.root);
    }

    public Node deleteMinimum() {
        return deleteMinimum(this.root);
    }

    public Node delete(Integer key) {
        return delete(this.root, key);
    }

    public void NLR () {
        NLR(this.root);
    }

    public void LNR() {
        LNR(this.root);
    }

    public void LRN() {
        LRN(this.root);
    }

    // EXERCISE 2: createTreeFromString
    public void createTreeFromString(String treeString) {
        String[] nodes = treeString.split(" ");

        for (String node : nodes) {
            insert(Integer.parseInt(node));
        }
    }

    // EXERCISE 3: Write the function that prints on the screen the values of the tree in descending order.
    private void RNL(Node root) {
        if (root != null) {
            RNL(root.right);
            System.out.print(root.key + " ");
            RNL(root.left);
        }
    }

    public void RNL() {
        RNL(this.root);
    }

    // EXERCISE 4: Write contains function with input is a key, the function returns true if the key in
    // the tree. Otherwise, it returns false.
    public boolean contains(Integer key) {
        return search(key) != null;
    }

    // EXERCISE 5: Delete Maximum
    private Node deleteMaximum(Node root) {
        if (root == null) {
            return root;
        }

        if (root.right == null) {
            return root.left;
        }

        root.right = deleteMaximum(root.right);
        return root;
    }

    public Node deleteMaximum() {
        return deleteMaximum(this.root);
    }

    // EXERCISE 6: Write the function to delete a node in BST, but you must use the predecessor instead
    // of the successor.
    public Node deletePredecessor(Integer key) {
        int predecessorKey = findPredecessor(key).key;
        return delete(predecessorKey);
    }

    private Node findPredecessor(Node root, Integer key) {
        if (root == null) {
            return root;
        }

        int compareValue = key.compareTo(root.key);

        if (compareValue < 0) {
            return findPredecessor(root.left, key);
        }

        // Case 2: The key is greater than the root's key
        if (compareValue > 0) {
            Node temp = findPredecessor(root.right, key);
            if (temp == null) {
                return root;
            }
        }

        return root;
    }

    public Node findPredecessor(Integer key) {
        return findPredecessor(this.root, key);
    }

    // EXERCISE 7: Write the function to calculate the height of the BST.
    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int height() {
        return height(this.root);
    }

    // EXERCISE 8: Write the function to calculate sum of all keys in the BST.
    private int sum(Node root) {
        if (root == null) {
            return 0;
        }

        return root.key + sum(root.left) + sum(root.right);
    }

    public int sum() {
        return sum(this.root);
    }

    // EXERCISE 9: Write the function sumEven() to calculate the sum of even keys in the BST.
    private int sumEven(Node root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.key % 2 == 0) {
            sum += root.key;
        }

        return sum + sumEven(root.left) + sumEven(root.right);
    }

    public int sumEven() {
        return sumEven(this.root);
    }

    // EXERCISE 10: Write the function countLeaves() to count the leaves of the BST.
    private int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public int countLeaves() {
        return countLeaves(this.root);
    }

    // EXERCISE 11: Write the function sumEvenKeysAtLeaves() to sum the even keys stored in the leaves
    // of the BST.
    private int sumEvenKeysAtLeaves(Node root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left == null && root.right == null && root.key % 2 == 0) {
            sum += root.key;
        }

        return sum + sumEvenKeysAtLeaves(root.left) + sumEvenKeysAtLeaves(root.right);
    }

    public int sumEvenKeysAtLeaves() {
        return sumEvenKeysAtLeaves(this.root);
    }

    // EXERCISE 12: Write the function bfs() to traverse the BST by level order and print the keys on
    // the screen.
    public void bfs() {
        if (root == null) {
            return;
        }

        // Queue to keep track of nodes to visit
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Process each node in the queue
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.key + " ");

            // Add left child to the queue if it exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child to the queue if it exists
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Node testRoot = new Node(2);
        BinarySearchTree test = new BinarySearchTree(testRoot);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(6);
        test.insert(0);
        test.insert(1);

        test.NLR();
        System.out.println();
        test.LNR();
        System.out.println();
        test.LRN();
        System.out.println();
        test.RNL();
        System.out.println();
        test.bfs();
    }
}
