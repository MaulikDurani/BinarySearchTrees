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

    /**
     * Inserts an item into the tree.
     *
     * @param key the item to be inserted into the tree
     */
    public void insert(T key) {
        throw new UnsupportedOperationException("Has not been implemented");
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

    /**
     * Returns the root node of the binary search tree.
     * By Ryan Majd
     * 
     * @return the root node of the binary search tree
     */
    public NodeType<T> getRoot() {
        return this.root;
    }
}
