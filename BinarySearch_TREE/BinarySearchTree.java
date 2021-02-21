package Data_Strutures.BinarySearch_TREE;

public class BinarySearchTree {

    class Node{
        Integer key;
        Node left;
        Node right;

        public Node(Integer key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int key){
        this.root = insertNode(this.root, key);
    }

    private Node insertNode(Node root, Integer key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.key){
            root.left = insertNode(root.left, key);
        }else{
            root.right = insertNode(root.right, key);
        }
        return root;

    }

    public void printInorder(){
        inorderRec(this.root);

    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }


    public Node getRoot() {
        return root;
    }
}



