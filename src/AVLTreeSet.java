/**
 *
 * @author Leyton
 */


public class AVLTreeSet<T extends Comparable<T>> extends BSTSet<T>{

	public	AVLTreeSet(){
		super();
	}

        public void add(T data){
            super.add(data);
            super.updateHeight( data);
            this.balance(data);
        }

		public boolean remove(T data) {
			if (super.remove(data)) {
					super.updateHeight(data);
					this.balance(data);
					return true;
			} else {
				return false;
			}
		}

		
	protected void checkIsBalanced(){
		if (!isBalanced(this.root)) throw new IllegalStateException("tree is not balanced");
	}

    private void balance(T data) {
        balanceHelper(root, data);
    }

    private void balanceHelper(TreeNode current, T data) {
        if (current == null) {
            return;
        }

        if (current.data.compareTo(data) != 0) {

            if (current.data.compareTo(data) > 0 && current.left != null) {
                balanceHelper(current.left, data);

            } else if (current.data.compareTo(data) < 0 && current.right != null) {
                balanceHelper(current.right, data);
            }
        }

        //if balanced, return;
        if (isBalanced(current)) {
            return;
        }

        //reach this point if not balanced only.
        if (getHeight(current.right) > getHeight(current.left)) //right heavy
        {
            if (getHeight(current.right.left) > getHeight(current.right.right)) {
                    rotateRight(current.right);
                    rotateLeft(current);
            } else {
                    rotateLeft(current);
            }
        } else {  //left heavy
            if (getHeight(current.left.right) > getHeight(current.left.left)) {
                    rotateLeft(current.left);
                    rotateRight(current);
            } else {
                    rotateRight(current);
            }
        }
	}
    

	/*
	Perform a tri-node restructuring with a single left rotation
	and return the new root of the tri-node

	e.g.
    If the method is called on 
	  b
	 / \
        c   a
	  / \
	 d   e
	then the tri-node is b,a,e so the result is
	    a
	   / \
	  b   e
	 / \
	c   d       
	and the method makes sure the parent of b now is the parent of a
	*/
    private void rotateLeft(TreeNode<T> b) {
        
	        
        TreeNode<T> oldRight = b.right;
        b.right=oldRight.left;
        if (getParent(b) == null) {
            root = oldRight;
        } else if (getParent(b).left == b) {
            getParent(b).left=oldRight;
        } else {
            getParent(b).right=oldRight;
        }
        oldRight.left= b;
        this.updateHeight(b.data);
        //this.updateHeightWholeTree();
        
    }
    
	/*
	Perform a tri-node restructuring with a single right rotation
	and return the new root of the tri-node

	e.g.
    If the method is called on 
	    a
	   / \
	  b   e
	 / \
	c   d       
	then the tri-node is a,b,c, so the result is
	  b
	 / \
        c  a
	  / \
	 d   e
	and the method makes sure the parent of a now is the parent of b
	*/
    private void rotateRight(TreeNode<T> a) {
            if (a.left == null) {
                return;
            }
            TreeNode<T> oldLeft = a.left;
            a.left=oldLeft.right;
            if (getParent(a) == null) {
                root = oldLeft;
            } else if (getParent(a).left == a) {
                getParent(a).left=oldLeft;
            } else {
                getParent(a).right=oldLeft;
            }
            oldLeft.right=a;
            this.updateHeight(a.data);
            //this.updateHeightWholeTree();
    }
    


}
