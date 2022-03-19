
/**
 *  Binary Tree Driver Program
 *
 * <p>
 *     Uses a nonrandom dataset for the binary tree for function demonstration purposes, and debugging.
 *
 *      add 14 data points to BST (including repeated numbers). Then find 2 data points. Count occurrences of repeated 72
 *      Display BST in ascending and descending order
 *
 *      [WORKING - remove(BinaryTree node, int num)] Remove a number from BST, by passing the tree, does this 3 times, and with repeated numbers
 *
 *      [NOT WORKING - removeNum(int num)] - Remove num, by having the parent node remove a number in the child node's stead.
 * </p>
 *
 * @date 2022/01/12
 */

class Main {
    /**
     * Main program
     * @param args command line args
     */
    public static void main(String[] args) {
        // Create a tree
        BinaryTree theTree = new BinaryTree();

        // Fill Binary Search Tree with numbers
        theTree.add(9);
        theTree.add(12);
        theTree.add(14);
        theTree.add(17);
        theTree.add(23);
        theTree.add(19);
        theTree.add(67);
        theTree.add(69);
        theTree.add(54);
        theTree.add(72);
        theTree.add(72);
        theTree.add(72);
        theTree.add(72);
        theTree.add(76);
        theTree.add(50);

        // Let's find something
        System.out.print("Find 69: ");
        BinaryTree node = theTree.find(69);
        System.out.println(node == null ? "Not found" : "Found:" + node.getData());

        // Let's find another number
        System.out.print("Find 420: ");
        BinaryTree node2 = theTree.find(420);
        System.out.println(node2 == null ? "Not found" : "Found:" + node2.getData());

        int findNum = 72;
        System.out.println("Found " + theTree.countInstance(findNum) + " occurrences of " + findNum);

        // Show data reverse
        System.out.println("Tree in Descending order");
        System.out.println(theTree.reverseOrderTraversal());

        // Show the data in the tree
        System.out.println("Tree in ascending order");
        System.out.println(theTree.inOrderTraversal());

        // Remove 19 from the tree
        int removeNumber = 19;
        theTree = theTree.remove(theTree, removeNumber);
        System.out.println(removeNumber + " has been removed from the tree");

        // show tree with 19 removed
        System.out.println(theTree.inOrderTraversal());

        // Remove 19 from the tree
        removeNumber = 72;
        theTree = theTree.remove(theTree, removeNumber);
        System.out.println(removeNumber + " has been removed from the tree");

        // show tree with 19 and 72 removed
        System.out.println(theTree.inOrderTraversal());

        // Remove 72 again from the tree
        removeNumber = 72;
        theTree = theTree.remove(theTree, removeNumber);
        System.out.println(removeNumber + " has been removed from the tree");

        // show tree with 19,72 and 72 removed
        System.out.println(theTree.inOrderTraversal());
    }
}
