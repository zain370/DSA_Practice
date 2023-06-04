class AVLNode {
    int key;
    int height;
    AVLNode left;
    AVLNode right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {
    private AVLNode root;

    private int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int balanceFactor(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private AVLNode insertNode(AVLNode node, int key) {
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insertNode(node.left, key);
        else if (key > node.key)
            node.right = insertNode(node.right, key);
        else
            return node; // Duplicate keys are not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1) {
            if (key < node.left.key)
                return rightRotate(node);
            else if (key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balanceFactor < -1) {
            if (key > node.right.key)
                return leftRotate(node);
            else if (key < node.right.key) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }



    private boolean isAVLTree(AVLNode node) {
        if (node == null)
            return true;

        int balanceFactor = balanceFactor(node);

        if (balanceFactor < -1 || balanceFactor > 1)
            return false;

        return isAVLTree(node.left) && isAVLTree(node.right);
    }

    public boolean isAVLTree() {
        return isAVLTree(root);
    }

    private void inorderTraversal(AVLNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    public void inorder() {
        inorderTraversal(root);
    }

    private boolean containsNode(AVLNode node, int x) {
        if (node == null)
            return false;

        if (x == node.key)
            return true;
        else if (x < node.key)
            return containsNode(node.left, x);
        else
            return containsNode(node.right, x);
    }

    public boolean contains(int x) {
        return containsNode(root, x);
    }


    public void insert(int key) {
        root = insertNode(root, key);
    }

    public AVLTree(int[] a) {
        for (int key : a) {
            insert(key);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree(new int[] {15,25,35,45,55,65,75});


         System.out.print("Inorder traversal of the AVL tree: ");
        tree.inorder();
        System.out.println("");
     //   System.out.print(65"Is it an AVL :");
     //   System.out.println(tree.isAVLTree());


      //  System.out.println("Tree contains 55: "+ tree.contains(55));
      //  System.out.println("Tree contains 102: "+ tree.contains(102));


    }
}
