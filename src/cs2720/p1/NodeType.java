package cs2720.p1;

public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> left;
    public NodeType<T> right;

    /**
     * The constructor for the {@code NodeType<T>} object.
     *
     */
    public NodeType(T value) {
        this.info = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Returns the value of info.
     *
     * @returns the value of {@code info}
     *
     */
    public T getInfo() {
        return this.info;
    }

    /**
     * Returns the left child node.
     *
     * @returns the value of {@code left}
     *
     */
    public NodeType<T> getLeft() {
        return this.left;
    }

    /**
     * Returns the right child node.
     *
     * @returns the value of {@code right}
     *
     */
    public NodeType<T> getRight() {
        return this.right;
    }

    /**
     * Sets the value of info.
     *
     * @param item the value to be assigned
     *
     */
    public void setInfo(T value) {
        this.info = value;
    }

    /**
     * Setter method for left child node.
     *
     * @param left the node to be assigned
     *
     */
    public void setLeft(NodeType<T> left) {
        this.left = left;
    }

    /**
     * Setter method for right child node.
     *
     * @param right the node to be assigned
     *
     */
    public void setRight(NodeType<T> right) {
        this.right = right;
    }
}
