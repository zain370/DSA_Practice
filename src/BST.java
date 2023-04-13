public class BST {
    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    Node root=null;


    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node BST_DELETE(Node node, int key) {
        if (node != null) {
            if (key == node.data) {
                if (hasLeft(node) && hasRight(node)) {
                    Node successor = INORDER_SUCCESSOR(node);
                    copy(node, successor);
                    node.right = BST_DELETE(node.right, successor.data);
                } else {
                    node = getChildNode(node);
                }
            } else if (key < node.data) {
                node.left = BST_DELETE(node.left, key);
            } else {
                node.right = BST_DELETE(node.right, key);
            }
            return node;
        }
        return null;
    }

    private Node getChildNode(Node node) {
        if (hasLeft(node)) {
            return node.left;
        } else if (hasRight(node)) {
            return node.right;
        } else {
            return null;
        }
    }

    private void copy(Node node, Node successor) {
        node.data = successor.data;
        // Copy other data attributes if present but not child links
    }



    private Node INORDER_SUCCESSOR(Node node) {
        Node current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }




    public void insertion(int data){
        root=insertion(root,data);
    }
    
    public Node insertion(Node node,int data){

        if(node==null)
        {
            node=new Node(data);
        }
        else if(data<= node.data){
            node.left=insertion(node.left,data);
        }
        else{
            node.right=insertion(node.right,data);
        }
        return node;

    }

    public void preorder(){
        preorder(root);
    }

    public void preorder(Node node){
        if(node!=null)
        {
            System.out.println(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(){
        inorder(root);
    }

    public void inorder(Node node){
        if(node!=null) {
            inorder(node.left);
            System.out.println(node.data + " ");
            inorder(node.right);
        }
    }

    public void postorder(){
        postorder(root);
    }

    public void postorder(Node node){
        if(node!=null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data+" ");
        }
    }

    public Node getLeftChild(Node node) {
        return node.left;
    }

    public Node getRightChild(Node node) {
        return node.left;
    }

    public Node getParentNode(Node node, int data){
        if(node==null){
            return null;
        }

        Node getParent = null;

        while (node != null){
            if(data < node.data) {
                getParent = node;
                node = node.left;
            }

            else if(data > node.data ) {
                getParent = node;
                node = node.right;
            }

            else {break;}
        }
            return getParent;
    }

    public boolean hasLeft(Node node){
        if(node.left!=null)
            return true;
        else
            return false;
    }

    public boolean hasRight(Node node){
        if(node.right!=null)
            return true;
        else
            return false;
    }

    public Node getSibling(Node node) {
        if (node == null || node == root) {
            // Node is the root or null, so no siblings
            return null;
        }

        Node parent = getParent(node);
        if (parent.left == node) {
            // Node is the left child, so sibling is the right child
            return parent.right;
        } else {
            // Node is the right child, so sibling is the left child
            return parent.left;
        }
    }

    public Node getParent(Node node) {
        if (node == null || node == root) {
            // Node is the root or null, so no parent
            return null;
        }

        Node parent = null;
        Node current = root;
        while (current != null && current != node) {
            if (node.data <= current.data) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        return parent;
    }

    public static void main(String[] args) {
        BST bst= new BST();

        bst.insertion(3);
        bst.insertion(1);
        bst.insertion(2);
        bst.insertion(4);


    //    System.out.println(bst.getLeftChild(bst.root).data);

    //    System.out.println(bst.getParent(bst.root).left);
    //    bst.inorder();


    }
}