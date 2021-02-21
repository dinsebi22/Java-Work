package Data_Strutures.BinarySearch_TREE;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);

        binarySearchTree.printInorder();
    }
}
