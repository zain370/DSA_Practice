
// FA21-BCS-046
// MUHAMMAD ZAIN

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }


    public Node getParent(Node root, int key) {
        Node parent = null;
        Node current = root;

        while (current != null && current.key != key) {
            parent = current;

            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            throw new IllegalArgumentException("Node with key " + key + " does not exist in the tree");
        }

        return parent;
    }


    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public int getNodeDepth(int key) {
        return getNodeDepthRec(root, key, 0);
    }

    private int getNodeDepthRec(Node root, int key, int depth) {
        if (root == null) {
            return -1;
        }

        if (key == root.key) {
            return depth;
        } else if (key < root.key) {
            return getNodeDepthRec(root.left, key, depth + 1);
        } else {
            return getNodeDepthRec(root.right, key, depth + 1);
        }
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBST() {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRec(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.key < minValue || root.key > maxValue) {
            return false;
        }

        return isBSTRec(root.left, minValue, root.key - 1) &&
                isBSTRec(root.right, root.key + 1, maxValue);
    }

    public boolean areNodesAtSameLevel(int key1, int key2) {
        int level1 = getLevel(root, key1);
        int level2 = getLevel(root, key2);
        return (level1 > 0 && level1 == level2);
    }

    private int getLevel(Node root, int key) {
        if (root == null) {
            return 0;
        }

        if (key == root.key) {
            return 1;
        }

        int leftLevel = getLevel(root.left, key);
        if (leftLevel > 0) {
            return leftLevel + 1;
        }

        int rightLevel = getLevel(root.right, key);
        if (rightLevel > 0) {
            return rightLevel + 1;
        }

        return 0;
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    public boolean printNode(Node root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        return false;
    }

    private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private  void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private  int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private  <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder Traversal : ");
        tree.inorder();
        System.out.println(" ");

        //   System.out.print("The parent of 80 is ")
        // System.out.println(tree.getParent(tree.root, 20).key);

        //  System.out.println(tree.getNodeDepth(30));
        //  System.out.println("The depth of 60 is 2");

        // System.out.print("The height of tree is ");
       // System.out.print(tree.height());

       // System.out.print("Is the given tree a BST : ");
        // System.out.println(tree.isBST());

       // System.out.print("Are node 60 and 40 at same level: ");
        //System.out.println(tree.areNodesAtSameLevel(60,40));

        System.out.print("Total number of nodes are : ");
        System.out.println(tree.countNodes());
        System.out.println(tree.printNode(root));


    }
}
