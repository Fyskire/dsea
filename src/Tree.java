import java.util.*;
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
        Random rnd = new Random();
        for (int k = 2; k <= 6; k++) {
            System.out.print("n = 10^"+k+" | 10 Runs: [          ]\b\b\b\b\b\b\b\b\b\b\b");
            int n = (int) Math.pow(10,k);
            double avgDepth = 0;
            for (int i = 0; i < 10; i++) {
                ArrayList<Integer> numbers = new ArrayList<Integer>(n);
                for (int j = 1; j <= n; j++)
                    numbers.add(j);
                int index = rnd.nextInt(n);
                Tree<Integer> tree1 = new Tree<Integer>(numbers.get(index));
                Integer swp = numbers.get(index);
                numbers.set(index, numbers.get(n-1));
                numbers.set(n-1, swp);
                for (int j = 1; j < n; j++) {
                    index = rnd.nextInt(n-j);
                    tree1.insert(numbers.get(index));
                    swp = numbers.get(index);
                    numbers.set(index, numbers.get(n-j-1));
                    numbers.set(n-j-1, swp);
                }
                avgDepth += (double) tree1.maxDepth();
                System.out.print("#");
            }
            System.out.print("] | ");
            avgDepth = avgDepth/10;
            System.out.println("avgDepth = "+avgDepth);
        }
    }
}
