package cs2720.p1;

/**
 * BinarySearchTree represents a binary search tree data structure.
 * It stores elements of type T in a sorted manner, allowing efficient
 * insertion, deletion, and search operations.
 * The tree is composed of nodes, where each node contains a value of type T and
 * references to its left and right child nodes.
 * The tree follows the binary search property, where the value of each node is
 * greater than all values in its left subtree and less than all values in its
 * right subtree.
 *
 * @param <T> the type of elements stored in the binary search tree, must
 *            implement the Comparable interface
 */
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

    /**
     * Inserts a new key into the binary search tree.
     * 
     * @param key the key to be inserted
     */
    public void insert(T key) {
        root = insertRecursive(root, key);
    }

    /**
     * Inserts a new key into the binary search tree recursively.
     * If the key already exists, it will not be inserted again.
     *
     * 
     * By Ryan Majd
     * 
     * @param root the root node of the binary search tree
     * @param key  the key to be inserted
     * @return the updated root node of the binary search tree
     */
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
        } else {
            System.out.println("The item already exists in the tree.");
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
    public T convertToType(String input, String choice) {
        String lInput = input.toLowerCase();
        if (input.contains(".") || choice.equals("d")) {
            double d = Double.parseDouble(input);
            return (T) (Comparable<Double>) d;
        } else if (lInput.matches("[0-9]+")) {
            Integer i = Integer.parseInt(input);
            return (T) (Comparable<Integer>) i;
        }
        return (T) input;
    }

    /**
     * Inserts converted data type into the BinarySearchTree
     *
     * By Ryan Majd
     */
    public void convertAndInsert(String input, String choice) {
        T dt = convertToType(input, choice);
        insert(dt);
    }

    /**
     * Converts the given input to the specified type and deletes the corresponding
     * node from the binary search tree.
     * 
     * By Ryan Majd
     * 
     * @param input  the input value to be converted
     * @param choice the type to which the input should be converted
     */
    public void convertAndDelete(String input, String choice) {
        T dt = convertToType(input, choice);
        delete(dt);
    }

    /**
     * Converts the input string to the specified type and performs a search
     * operation.
     * 
     * By Ryan Majd
     * 
     * @param input  the input string to be converted
     * @param choice the choice of type to convert the input string to
     */
    public void convertAndSearch(String input, String choice) {
        T dt = convertToType(input, choice);
        search(dt);
    }

    /**
     * Searches for a specified key in the binary search tree.
     * 
     * By Ryan Majd
     * 
     * @param key the key to search for
     */
    protected void search(T key) {
        if (searchRecursive(root, key)) {
            System.out.println("Item is present in the tree");
        } else {
            System.out.println("Item is not present in the tree");
        }
    } // search(T key)

    /**
     * Recursively searches for a key in the binary search tree.
     * 
     * By Ryan Majd
     * 
     * @param root the root node of the binary search tree
     * @param key  the key to search for
     * @return true if the key is found, false otherwise
     */
    private boolean searchRecursive(NodeType<T> root, T key) {
        if (root == null) {
            // If the tree is empty or the key is not found
            return false;
        }

        int compareResult;

        if (key == null && root.getInfo() == null) {
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

        if (compareResult == 0) {
            // Node with the key found
            return true;
        } else if (compareResult < 0) {
            // If the key is smaller, go to the left subtree
            return searchRecursive(root.getLeft(), key);
        } else {
            // If the key is larger, go to the right subtree
            return searchRecursive(root.getRight(), key);
        }
    }

    /**
     * Deletes the item from the tree.
     *
     * @param key the item to be deleted from the tree
     * 
     *            By Ryan Majd
     *
     */
    public void delete(T key) {
        root = deleteRecursive(root, key);
    }

    /**
     * Recursively deletes a node with the specified key from the binary search
     * tree.
     * If the key is not found, a message is printed and the tree remains unchanged.
     * 
     * By Ryan Majd
     * 
     * @param root the root node of the binary search tree
     * @param key  the key of the node to be deleted
     * @return the updated root node after deletion
     */
    private NodeType<T> deleteRecursive(NodeType<T> root, T key) {
        if (root == null) {
            // If the tree is empty or the key is not found
            System.out.println("The number is not present in the tree");
            return null;
        }

        int compareResult;

        if (key == null && root.getInfo() == null) {
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
            // If the key is smaller, go to the left subtree
            root.setLeft(deleteRecursive(root.getLeft(), key));
        } else if (compareResult > 0) {
            // If the key is larger, go to the right subtree
            root.setRight(deleteRecursive(root.getRight(), key));
        } else {
            // Node with the key to be deleted found

            // Case 1: Node with only one child or no child
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            // Case 3: Node with two children
            // Find the smallest node in the right subtree (in-order successor)
            root.setInfo(findMin(root.getRight()).getInfo());

            // Delete the in-order successor
            root.setRight(deleteRecursive(root.getRight(), root.getInfo()));
        }

        return root;
    } // deleteRecursive

    /**
     * Finds the minimum value in the binary search tree rooted at the given node.
     * 
     * By Ryan Majd
     * 
     * @param node the root node of the binary search tree
     * @return the node with the minimum value in the binary search tree
     */
    private NodeType<T> findMin(NodeType<T> node) {
        // Find the leftmost node in the tree (smallest node)
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    } // find Min from leftmost node

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

    /* Helper Methods */
    @Deprecated
    public void toTree() {
        printTree(root, 0);
    }

    @Deprecated
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
    } // deprecated printTree method

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
        return "In-order: " + result.toString().trim();
    }

    /**
     * Performs an in-order traversal of the binary search tree rooted at the given
     * node.
     * Appends the information of each node to the given StringBuilder in ascending
     * order.
     * 
     * By Ryan Majd
     * 
     * @param root   the root of the binary search tree
     * @param result the StringBuilder to store the traversal result
     */
    private void inOrderTraversal(NodeType<T> root, StringBuilder result) {
        if (root != null) {
            inOrderTraversal(root.getLeft(), result);

            // Only append if the node's info is not null
            if (root.getInfo() != null) {
                result.append(root.getInfo()).append(" ");
            }

            inOrderTraversal(root.getRight(), result);
        }
    } // in order traversal recursively building string

    /**
     * Returns the number of leaf nodes.
     * By Maulik Durani
     *
     * @returns int the number of leaf nodes.
     *
     */
    public int getNumLeafNodes(NodeType<T> node) {
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

    /**
     * Returns a string of all of the nodes that only have one child.
     * By Maulik Durani
     *
     * @return result a string of all the nodes that have only one child node
     *
     */
    public String getSingleParent(NodeType<T> node) {
        String result = "";
        if (node != null) {
            if (node.getLeft() == null && node.getRight() != null) {
                result += node.getInfo() + " ";
            } else if (node.getLeft() != null && node.getRight() == null) {
                result += node.getInfo() + " ";
            }
            result += getSingleParent(node.getLeft());
            result += getSingleParent(node.getRight());
        } else {
            return "";
        }
        return result;
    }

    /**
     * Returns the string of all single parent nodes.
     * By Maulik Durani
     *
     * @return list the string of all single parent nodes
     *
     */
    public String getSingleParents() {
        String list = getSingleParent(root);
        list = list.replace("null ", "");
        return list;
    } // get single parents

    /**
     * Returns the depth of the specified item.
     * By Maulik Durani
     * 
     * @param node the root node
     * @param item the value being searched for
     *
     * @return int the depth of the specified item
     * 
     */
    public int getDepth(NodeType<T> node, T item) {
        if (node == null) {
            return -1;
        } else if (item.compareTo(node.getInfo()) < 0) {
            return getDepth(node.getLeft(), item) + 1;
        } else if (item.compareTo(node.getInfo()) > 0) {
            return getDepth(node.getRight(), item) + 1;
        } else {
            return 0;
        }
    }

    /**
     * Recursively prints the cousin nodes.
     * By Maulik Durani
     *
     * @param node  the root node
     * @param item  the specified item
     * @param depth the calculated depth of the node that contains {@code item}
     *
     */
    public void getCousinsRecursive(NodeType<T> node, T item, int depth) {
        if (depth < 2) {
            return;
        }
        if (searchRecursive(node.getLeft(), item)) {
            getCousinsRecursive(node.getLeft(), item, depth - 1);
            printDepth(node.getRight(), depth - 1);
        } else {
            getCousinsRecursive(node.getRight(), item, depth - 1);
            printDepth(node.getLeft(), depth - 1);
        }
    }

    /**
     * A method used in getCousinsRecursive().
     * By Maulik Durani
     *
     * @param node  the root node
     * @param depth the calculated depth from
     *              {@code getDepth(NodeType<T> node, T item)}
     *
     */
    public void printDepth(NodeType<T> node, int depth) {
        if (node != null) {
            if (depth == 0) {
                System.out.print(node.getInfo() + " ");
            }
            if (node.getLeft() == null && node.getRight() == null) {
                return;
            } else if (node.getLeft() == null && node.getRight() != null) {
                printDepth(node.getRight(), depth - 1);
            } else if (node.getRight() != null && node.getRight() == null) {
                printDepth(node.getLeft(), depth - 1);
            } else {
                printDepth(node.getLeft(), depth - 1);
                printDepth(node.getRight(), depth - 1);
            }
        }
    }

    /**
     * The method called to find cousins of a specified item.
     * By Maulik Durani
     * 
     * @param item the specified item
     *
     */
    public void getCousins(T item) {
        if (searchRecursive(root, item)) {
            int depth = getDepth(root.getRight(), item);
            getCousinsRecursive(root.getRight(), item, depth);
        } else {
            System.out.println("");
        }
    }

    /**
     * Calls {@code getCousins(T item)}.
     * By Maulik Durani
     *
     * @param input  the value used in searching
     * @param choice specifies what datatype to convert {@code input} to
     *
     */
    public void getCousinsConverted(String input, String choice) {
        T dt = convertToType(input, choice);
        getCousins(dt);
    }

} // BST
