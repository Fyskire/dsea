class Node<T extends Comparable<T>> extends AbstractNode<T>{ 

  public Node(T key){
    super(key);
  }

  public boolean insert (T key){

    int direction = key.compareTo(this.key);	
    Boolean b = false;
    // use direction to choose if left or right, zero means equality
    System.out.println("Direction: " + direction);
    if(direction == 1){ // If right
    	if(this.right == null){
    		this.right = new Node(key);
    		b =  true;
    	} else {
    		b = this.right.insert(key);
    	}
    } else if (direction == -1){ //If left
    	if(this.left == null){
    		this.left = new Node(key);
    		b =  true;
    	} else {
    		b = this.left.insert(key);
    	}
    } else if (direction == 0){ //If equal
    	System.out.println("ERROR: Key already exists. Keys are unique!");
    } else {
    	System.out.println("ERROR: compareTo method returned gibberish.");
    }
    // should be more sophisticated than xkcd random dice roll https://xkcd.com/221/
    return b;
  }

  public boolean isIn (T key){

    int direction = key.compareTo(this.key);
    // use direction to choose if left or right, zero means equality

    // should be more sophisticated than xkcd random dice roll https://xkcd.com/221/
    return false;
  }

  public void preorder(){ //W-L-R
	  System.out.print(key + " ");
	  if(this.left != null){
		  this.left.preorder();
	  }
	  if (this.right != null){
		  this.right.preorder();
	  }
  }

  public void inorder(){ //L-W-R
	  if(this.left != null){
		  this.left.preorder();
	  }
	  System.out.print(key + " ");
	  if (this.right != null){
		  this.right.preorder();
	  }
  }

  public void postorder(){//L-R-W
	  if(this.left != null){
		  this.left.preorder();
	  }
	  if (this.right != null){
		  this.right.preorder();
	  }
	  System.out.print(key + " ");
  }


  public int maxDepth(){

    // Should be a bit more sophisticated
    return 0;
  }		
}
