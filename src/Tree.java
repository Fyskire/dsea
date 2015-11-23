// Wrapper class, there is no need for customization
class Tree<T extends Comparable<T>> extends AbstractTree<T> {

    public Tree(T key) {
        root = new Node<T>(key);
    }

    public boolean insert(T key) {
        return root.insert(key);
    }

    public boolean isIn(T key) {
        return root.isIn(key);
    }

    // all the traversal methods! :D |--> :(
    public void preorder() {
        root.preorder();
        System.out.println("");
    }

    public void inorder() {
        root.inorder();
        System.out.println("");
    }

    public void postorder() {
        root.postorder();
        System.out.println("");
    }

    // recursive depth method
    public int maxDepth() {
        return root.maxDepth();
    }

    public static void main(String args[]) {

        // new Integer tree (put in 2 as root key)
        Tree<Integer> T = new Tree<Integer>(2);
        // put in 3 (true)
        System.out.println(T.insert(3));
        // put in 3 (false - keys are unique!)
        System.out.println(T.insert(3));
        System.out.println(T.insert(6));
        System.out.println(T.insert(5));
        System.out.println(T.insert(1));
        // 2 in tree (true)
        System.out.println(T.isIn(2));
        
        T.preorder();
        T.inorder();
        T.postorder();
        System.out.println("max depth: " +T.maxDepth());

}
}
