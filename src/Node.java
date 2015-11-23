class Node<T extends Comparable<T>> extends AbstractNode<T> {

    public Node(T key) {
        super(key);
    }

    public boolean insert (T key) {

        int direction = key.compareTo(this.key);
        // use direction to choose if left or right, zero means equality
        //System.out.println("Direction: " + direction);
        if (direction == 1) { // If right
            if(this.right == null) {
                this.right = new Node<T>(key);
                return true;
            } else {
                return this.right.insert(key);
            }
        } else if (direction == -1) { //If left
            if(this.left == null){
                this.left = new Node<T>(key);
                return true;
            } else {
                return this.left.insert(key);
            }
        } else if (direction == 0) { //If equal
            System.out.println("ERROR: Key already exists. Keys are unique!");
            return false;
        } else {
            System.out.println("ERROR: compareTo method returned gibberish.");
            return false;
        }
    }

    public boolean isIn (T key) {
        int direction = key.compareTo(this.key);
        return false;
    }

    public void preorder() { //W-L-R
        System.out.print(key + " ");
        if (this.left != null)
            this.left.preorder();
        if (this.right != null)
            this.right.preorder();
    }

    public void inorder() { //L-W-R
        if (this.left != null)
            this.left.inorder();
        System.out.print(key + " ");
        if (this.right != null)
            this.right.inorder();
    }

    public void postorder() { //L-R-W
        if (this.left != null)
            this.left.postorder();
        if (this.right != null)
            this.right.postorder();
        System.out.print(key + " ");
      }


    public int maxDepth() {
        int l = (left!=null?left.maxDepth():0);
        int r = (right!=null?right.maxDepth():0);
        return (l>r?l:r)+1;
        // FOCKIN 1337 M8
    }
}
