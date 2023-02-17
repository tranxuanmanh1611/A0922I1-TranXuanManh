public class TestBST {
    public static void main(String[] args) {
        BST<Integer> newBST = new BST<>();
        System.out.println(newBST.insert(11));
        System.out.println(newBST.insert(10));
        System.out.println(newBST.insert(9));
        System.out.println(newBST.insert(100));
        System.out.println(newBST.insert(2));
        System.out.println(newBST.insert(1));
        System.out.println(newBST.insert(8));
        System.out.println(newBST.insert(90));
        System.out.println(newBST.insert(105));



        System.out.println("Inorder (sorted): ");
        newBST.inOrder();
        System.out.println("Post order");
        newBST.postOrder();
        System.out.println("preOrder");
        newBST.preOrder();
        System.out.println("The number of nodes is: " + newBST.getSize());
    }
}
