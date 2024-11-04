class AVL {
    private Node root;

    // Get the height of the node
    private int height(Node currentNode) {
        return currentNode == null ? -1 : currentNode.height;
    }

    // Get the balance factor of a node
    private int getBalance(Node currentNode) {
        return currentNode == null ? 0 : (height(currentNode.leftChild) - height(currentNode.rightChild));
    }

    // Rotate right
    private Node rightRotate(Node rootNode) {
        Node newRootNode = rootNode.leftChild;
        Node tempSubtree = newRootNode.rightChild;

        // Perform rotation
        newRootNode.rightChild = rootNode;
        rootNode.leftChild = tempSubtree;

        // Update heights
        rootNode.height = Math.max(height(rootNode.leftChild), height(rootNode.rightChild)) + 1;
        newRootNode.height = Math.max(height(newRootNode.leftChild), height(newRootNode.rightChild)) + 1;

        // Return new root
        return newRootNode;
    }

    // Rotate left
    private Node leftRotate(Node rootNode) {
        Node newRootNode = rootNode.rightChild;
        Node tempSubtree = newRootNode.leftChild;

        // Perform rotation
        newRootNode.leftChild = rootNode;
        rootNode.rightChild = tempSubtree;

        // Update heights
        rootNode.height = Math.max(height(rootNode.leftChild), height(rootNode.rightChild)) + 1;
        newRootNode.height = Math.max(height(newRootNode.leftChild), height(newRootNode.rightChild)) + 1;

        // Return new root
        return newRootNode;
    }

    // Insert a key in the AVL tree
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.leftChild = insert(currentNode.leftChild, value);
        } else if (value > currentNode.value) {
            currentNode.rightChild = insert(currentNode.rightChild, value);
        } else {
            return currentNode; // Duplicate keys are not allowed
        }

        // Update height of the current node
        currentNode.height = Math.max(height(currentNode.leftChild), height(currentNode.rightChild)) + 1;

        // Get the balance factor
        int balance = getBalance(currentNode);

        // If the node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && value < currentNode.leftChild.value) {
            return rightRotate(currentNode);
        }

        // Right Right Case
        if (balance < -1 && value > currentNode.rightChild.value) {
            return leftRotate(currentNode);
        }

        // Left Right Case
        if (balance > 1 && value > currentNode.leftChild.value) {
            currentNode.leftChild = leftRotate(currentNode.leftChild);
            return rightRotate(currentNode);
        }

        // Right Left Case
        if (balance < -1 && value < currentNode.rightChild.value) {
            currentNode.rightChild = rightRotate(currentNode.rightChild);
            return leftRotate(currentNode);
        }

        // Return the unchanged node pointer
        return currentNode;
    }

    // In-order traversal of the AVL tree
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.leftChild);
            System.out.print(currentNode.value + " ");
            inOrder(currentNode.rightChild);
        }
    }

    // Find the minimum value node
    private Node minValueNode(Node currentNode) {
        Node current = currentNode;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    // Delete a node
    public void delete(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node rootNode, int value) {
        if (rootNode == null) {
            return rootNode;
        }

        if (value < rootNode.value) {
            rootNode.leftChild = deleteNode(rootNode.leftChild, value);
        } else if (value > rootNode.value) {
            rootNode.rightChild = deleteNode(rootNode.rightChild, value);
        } else {
            // Node with one child or no child
            if ((rootNode.leftChild == null) || (rootNode.rightChild == null)) {
                Node tempNode = rootNode.leftChild != null ? rootNode.leftChild : rootNode.rightChild;

                if (tempNode == null) {
                    tempNode = rootNode;
                    rootNode = null;
                } else {
                    rootNode = tempNode;
                }
            } else {
                Node tempNode = minValueNode(rootNode.rightChild);

                rootNode.value = tempNode.value;

                rootNode.rightChild = deleteNode(rootNode.rightChild, tempNode.value);
            }
        }

        if (rootNode == null) {
            return rootNode;
        }

        rootNode.height = Math.max(height(rootNode.leftChild), height(rootNode.rightChild)) + 1;

        int balance = getBalance(rootNode);

        if (balance > 1 && getBalance(rootNode.leftChild) >= 0) {
            return rightRotate(rootNode);
        }

        if (balance > 1 && getBalance(rootNode.leftChild) < 0) {
            rootNode.leftChild = leftRotate(rootNode.leftChild);
            return rightRotate(rootNode);
        }

        if (balance < -1 && getBalance(rootNode.rightChild) <= 0) {
            return leftRotate(rootNode);
        }

        if (balance < -1 && getBalance(rootNode.rightChild) > 0) {
            rootNode.rightChild = rightRotate(rootNode.rightChild);
            return leftRotate(rootNode);
        }

        return rootNode;
    }
}
