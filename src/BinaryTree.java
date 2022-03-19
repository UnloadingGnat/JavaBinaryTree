
/**
 * Binary Tree (Recursive)
 *
 * <p>
 *     Binary Tree Functions:
 *     constructors
 *     add(int num)
 *     find(int num)
 *     inOrderTraversal()
 *
 *     reverseOrderTraversal() - output tree in reverseOrder or descending order
 *     countInstance(int num) - counts the # of occurrences num has in the tree
 *     remove(BinaryTree node, int num) - remove the number from the tree
 * </p>
 *
 * @date 2022/01/12
 */

public class BinaryTree {
    // Attributes
    boolean empty = true;
    int data = 0;
    BinaryTree left = null;
    BinaryTree right = null;

    /**
     * Constructor
     */
    public BinaryTree() {
        this.data = 0;
        this.empty = true;
    }

    /**
     * Constructor
     * @param key node value
     */
    public BinaryTree(int key) {
        this.data = key;
        this.empty = false;
    }

    /**
     * Add a node to the tree
     * @param key node value
     */
    public void add(int key) {
        // Is the tree empty
        if (this.empty) {
            this.data = key;
            this.empty = false;
        }
        else if (key < data) {
            // Goes on the left side
            if (this.left == null) {
                this.left = new BinaryTree(key);
            }
            else {
                this.left.add(key);
            }
        }
        // key >= data
        else {
            // Goes on the right side
            if (this.right == null) {
                this.right = new BinaryTree(key);
            }
            else {
                this.right.add(key);
            }
        }
    }

    /**
     * find the minimum value of a tree
     * @param node node value of node
     * @return the min value of the tree
     */
    public BinaryTree minimum(BinaryTree node) {
        // find the min number w/ recursive calls
        if (node.left != null) {
            node = minimum(node.left);
        }
        return node;
    }

    /**
     * remove a number from the binary search tree
     * @param node node of current node
     * @param num num to remove
     * @return tree with num removed
     */
    public BinaryTree remove(BinaryTree node, int num) {
        if (node != null){
            // node node is greater than num
            if (node.data > num) {
                node.left = remove(node.left, num);
            }
            // node node is less than num
            else if (node.data < num) {
                node.right = remove(node.right, num);
            }
            // node node == num
            else {
                // if node has both leaves
                if (node.left != null && node.right != null) {
                    // Successor is the smallest node in right tree subtree
                    BinaryTree smallNodeInRight = minimum(node.right);

                    // the successor replaces the deleted node
                    node.data = smallNodeInRight.data;

                    // Deleting minimum node from right node
                    remove(node.right, smallNodeInRight.data);
                }
                // if node only has left leaf, replace
                else if (node.left != null) {
                    node = node.left;
                }
                // if node only has right leaf, replace
                else if (node.right != null) {
                    node = node.right;
                }
                // if node has no leaves, remove it
                else{
                    node = null;
                }
            }
        }
        return node;
    }

    /**
     * In-order traversal prints nodes in sorted order
     */
    public String inOrderTraversal() {
        String result = "";

        // Check is it's empty
        if (this.empty) {
            result = "Tree is empty";
        }
        else {
            // Left, Node, Right
            if (this.left != null) {
                result += this.left.inOrderTraversal();
            }

            result += this.data+" ";

            if (this.right != null) {
                result += this.right.inOrderTraversal();
            }
        }
        return result;
    }

    /**
     * reverse Order traversal
     * @return nodes in reverse sorted order
     */
    public String reverseOrderTraversal() {
        String result = "";

        // check is it empty
        if (this.empty) {
            result = "Tree is empty";
        }
        else {
            // Right -> Node -> Left
            if (this.right != null) {
                result += this.right.reverseOrderTraversal();
            }

            result += this.data + " ";

            if (this.left != null) {
                result += this.left.reverseOrderTraversal();
            }
        }
        return result;
    }

    /**
     * count Instances of a number in tree
     * @param num num to count occurrences of
     * @return count of occurs of the num in tree
     */
    public int countInstance(int num) {
        int count = 0;

        // base case null leaf
        if (!this.empty) {
            // if the root of the node is the num
            if (num == this.data) {
                count = 1;
            }
            // num is less, count instances on left leaf
            if (num < this.data && this.left != null) {
                count += this.left.countInstance(num);
            }
            // num is greater than or equal, count instances on right leaf
            if (num >= this.data && this.right != null) {
                count += this.right.countInstance(num);
            }
        }
        return count;
    }

    /**
     * Get the data at this node
     * @return node data
     */
    public int getData() {
        return this.data;
    }

    /**
     * Locate a value
     * @param key node value
     * @return the location of the node value
     */
    public BinaryTree find(int key) {
        BinaryTree result = null;

        if (!this.empty) {
            // Is this the node?
            if (this.data == key) {
                result = this;
            }
            else if (this.data > key && this.left != null) {
                // Search the left
                result = this.left.find(key);
            }
            else if (this.data < key && this.right != null) {
                // Search the right
                result = this.right.find(key);
            }
        }
        return result;
    }
}
