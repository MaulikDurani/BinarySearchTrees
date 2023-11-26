package cs2720.p1;

public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    /**
     * The constructor of a BinarySearchTree.
     *
     * by Maulik Durani
     */
    public BinarySearchTree() {
        this.root = new NodeType<T>(null);

    }

    public void insert(String str) {
        T key = (T) str; // This assumes T is a generic type that can be cast from String
        root = insertRecursive(root, key);
    }

    public void insert(int i) {
        T key = (T) Integer.valueOf(i);
        root = insertRecursive(root, key);
    }

    public void insert(double d) {
        T key = (T) Double.valueOf(d);
        root = insertRecursive(root, key);
    }

    public void insert(T key) {
        root = insertRecursive(root, key);
    }

    private NodeType<T> insertRecursive(NodeType<T> root, T key) {
        if (root == null) {
            return new NodeType<>(key);
        }

        int compareResult;

        if (key == null && root.getInfo() == null) {
            // Both keys are null, consider them equal
            compareResult = 0;
        } else if (key == null) {
            // The new key is null, so it's considered smaller than a non-null key
            compareResult = -1;
        } else if (root.getInfo() == null) {
            // The existing key is null, so it's considered smaller than a non-null key
            compareResult = 1;
        } else {
            // Compare non-null keys
            compareResult = key.compareTo(root.getInfo());
        }

        if (compareResult < 0) {
            // If the key is smaller, it goes to the left
            NodeType<T> leftChild = insertRecursive(root.getLeft(), key);
            root.setLeft(leftChild);
        } else if (compareResult > 0) {
            // If the key is larger, it goes to the right
            NodeType<T> rightChild = insertRecursive(root.getRight(), key);
            root.setRight(rightChild);
        }

        return root;
    }

    /**
     * Converts input from scanner to desired data type.
     *
     * By Ryan Majd
     *
     * @returns input the converted input to the desired data type
     *
     */
    @SuppressWarnings("unchecked")
    public T convertToType(String input) {
	String lInput = input.toLowerCase();
	if (input.contains(".")) {
	    double d = Double.parseDouble(input);
	    return (T) (Comparable) d;
	} else if (lInput.matches("[0-9]+")) {
	    Integer i = Integer.parseInt(input);
	    return (T) i;
	}
	return (T) input;
    }

    /**
     * Inserts converted data type into the BinarySearchTree
     *
     * By Ryan Majd
     */
    public void convertAndInsert(String input) {
	T dt = convertToType(input);
	insert(dt);
    }
    
    /**
     * Deletes the item from the tree.
     *
     * @param key the item to be deleted from the tree
     *
     */
    public void delete(T key) {

    }

    /**
     * Returns whether the item specified was found.
     *
     * @param item the item to be searched for
     * @returns true if the item is found in the tree, otherwise false
     *
     */
    public boolean retrieve(T item) {
        throw new UnsupportedOperationException("Has not been implemented");
    }

    /**
     * Prints out the tree in in-order.
     *
     */
    public void inOrder() {
        throw new UnsupportedOperationException("Has not been implemented");
    }

    /* Helper Methods */

    public void toTree() {
        printTree(root, 0);
    }

    private void printTree(NodeType<T> root, int depth) {
        if (root == null) {
            return;
        }

        printTree(root.getRight(), depth + 1);

        // Print indentation for the current depth
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        // Print the node's value if it's not null
        if (root.getInfo() != null) {
            System.out.println("- " + root.getInfo());
        }

        printTree(root.getLeft(), depth + 1);
    }

    /**
     * Returns the root node of the binary search tree.
     * By Ryan Majd
     * 
     * @return the root node of the binary search tree
     */
    public NodeType<T> getRoot() {
        return this.root;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        inOrderTraversal(root, result);
        return result.toString().trim();
    }

    private void inOrderTraversal(NodeType<T> root, StringBuilder result) {
        if (root != null) {
            inOrderTraversal(root.getLeft(), result);

            // Only append if the node's info is not null
            if (root.getInfo() != null) {
                result.append(root.getInfo()).append(" ");
            }

            inOrderTraversal(root.getRight(), result);
        }
    }

    /**
     * Returns the number of leaf nodes.
     * By Maulik Durani
     *
     * @returns int the number of leaf nodes.
     *
     */
    public int getNumLeafNodes(NodeType<T> node) {
	NodeType<T> temp = root;
	if (node == null) {
	    return 0;
	}
	if (node.getLeft() == null && node.getRight() == null) {
	    return 1;
	}
	return getNumLeafNodes(node.getLeft()) + getNumLeafNodes(node.getRight());
    }

    /**
     * Returns the number of leaf nodes.
     * By Maulik Durani
     *
     * @return int the number of leaf nodes
     *
     */
    public int getLeafCount() {
	return getNumLeafNodes(root);
    }


}
