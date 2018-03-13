package main;

public class BinaryTree {
    private char[] tree;

    /**
     * Determines the index of the father.
     * <p>
     * The root is its own father.
     *
     * @param node index of the children
     * @return index of the father
     */
    public static int father(int node) {
        return (node-1)/2;
    }

    /**
     * Determines the index of the left child.
     *
     * @param node index of the father
     * @return index of the left child
     */
    public static int leftChild(int node) {
        return 2*node+1;
    }

    /**
     * Determines the index of the right child.
     *
     * @param node index of the father
     * @return index of the right child
     */
    public static int rightChild(int node) {
        return 2*node+2;
    }

    /**
     * Check if the given array represents a valid binary tree.
     *
     * @param array a binary tree encoded as char array
     * @throws IllegalArgumentException if check fails
     */
    private static void checkTree(char[] array) {
        if(array.length == 0)
            throw new IllegalArgumentException("Empty Array, not a valid Tree");
        for(int i = 1; i < array.length; i++) {
            if (array[father(i)] == ' ' && array[i] != ' ') {
                throw new IllegalArgumentException("No Father for Node " + array[i]);
            }
        }
    }

    /**
     * Create a new binary tree from the given array representation.
     * <p>
     * The array stores the values of the binary tree in breadth-first order.
     * A space encodes a missing node.
     *
     * @param array the new tree
     * @throws IllegalArgumentException if array does not represent a valid binary tree.
     */
    public BinaryTree(char[] array) {
        checkTree(array);
        this.tree = array;
    }

    /**
     * convert {@link BinaryTree#tree} into indented form.
     * <p>
     * One line per node, depth-first. One space of indentation per depth.
     */
    public String toString()
    {
        return toString(0, "");
    }
    private String toString(int node, String intendation)
    {
        if(node >= tree.length || tree[node] == ' ')
            return "";
        return intendation + tree[node] + "\n" +
                toString(leftChild(node), intendation + " ") +
                toString(rightChild(node), intendation + " ");
    }
}
