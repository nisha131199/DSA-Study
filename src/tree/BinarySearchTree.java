package tree;

/**
 * TODO: Tree can have node which contains two sub-nodes & so on.
 *  PROPERTIES :
 *  1. Size = total member in nodes
 *  2. child, parents & sibling nodes
 *  3. Edge = two nodes connected by a line
 *  4. Height = max no. of edges from the node you're trying to find & leaf node
 *  5. Leaf node = bottom-most nodes
 *  6. Level = Height of root - Height of node
 *  ==> Root level = 0
 *  ****************
 *  TYPES OF BINARY TREE
 *  1. Complete BT = All levels are full, & last level can fill from left to right only
 *      o (yes)       o (not)
 *    /  \          /  \
 *   o                  o
 *  2. Full BT = Every node can have either 0 or 2 children (compression & segment tree)
 *  3. Perfect BT = All levels are filled
 *  => total nodes = 2^(height+1) - 1 or 2^level
 *  => Leaf node = 2^height
 *  4. Height Balanced = avg height O(log n)
 *  5. Skewed BT = every node can have only one child
 *  6. Ordered BT = every node has some properties. e.g., BST
 *  ****************
 *  IMPLEMENTATION
 *  1. Linked Representation
 *  2. Sequential - using array
 *  ****************
 *  BINARY SEARCH TREE
 *  Rules:
 *  1. Height diff between two leaf node should be 1 or 0
 *  2. Left hand side elements smaller
 *  3. Right side elements are larger
 *  ****************
 *  ORDER TO TRAVERSE
 *  Node -> Left -> Right
 *  Left -> Node -> Right
 *  Left -> Right -> Node
 * */
class BinarySearchTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5, root);
        root.insert(8, root);
        root.insert(20, root);
        root.insert(6, root);
        root.insert(15, root);
        root.insert(13, root);
        root.insert(21, root);
        root.insert(16, root);
        root.insert(4, root);

        root.displayPreOrder(root);
        System.out.println();
        System.out.println("------------");
        root.displayInOrder(root);
        System.out.println();
        System.out.println("------------");
        root.displayPostOrder(root);
        System.out.println();
        System.out.println("isBalanced Tree : "+root.isBalanced(root));
    }

    static class Node {
        private int value;
        private Node left, right;
        private int height;

        Node(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        int getHeight(Node node) {
            if (node == null) {
                return -1;
            }
            return node.height;
        }

        boolean isBalanced(Node node) {
            return hasBalanced(node);
        }

        private boolean hasBalanced(Node node) {
            if (node == null) {
                return true;
            }
            return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && hasBalanced(node.left) && hasBalanced(node.left);
        }

        Node insert(int value, Node node) {
            if (node == null) {
                node = new Node(value);
                return node;
            }

            if (value < node.value) {
                node.left = insert(value, node.left);
            }

            if (value > node.value) {
                node.right = insert(value, node.right);
            }

            node.height = Math.max(getHeight(node.right), getHeight(node.left)) + 1;

            return node;
        }

        void display(Node node) {
            if (node == null) {
                return;
            }

            System.out.println(node.getValue() + " -> ");
            displayPreOrder(node.left);
            displayPreOrder(node.right);
        }

        /**
         * Node -> Left -> Right
         * */
        void displayPreOrder(Node node) {
            if (node == null) {
                return;
            }

            System.out.print(node.getValue() + " -> ");
            displayPreOrder(node.left);
            displayPreOrder(node.right);
        }

        /**
         * Left -> Node -> Right
         * */
        void displayInOrder(Node node) {
            if (node == null) {
                return;
            }

            displayInOrder(node.left);
            System.out.print(node.getValue() + " -> ");
            displayInOrder(node.right);
        }

        /**
         * Left -> Right -> Node
         * */
        void displayPostOrder(Node node) {
            if (node == null) {
                return;
            }

            displayPostOrder(node.left);
            displayPostOrder(node.right);
            System.out.print(node.getValue() + " -> ");
        }
    }
}
