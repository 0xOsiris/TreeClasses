
import java.util.Objects;

 public  class TreeNode<T extends Comparable> {

        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;
        public int height;
        public TreeNode(T d) {
                        data = d;
                        left = null;
                        right = null;
                        height = 1;
        }
	
		/* String representation of the tree rooted at this TreeNode

	The representation is preorder, with each subtree enclosed in parentheses
	e.g. The tree

	        100
	  50           200
	     60     110   203

	would be printed as  (100,(50,(),(60,(),())),(200,(110,(),()),(203,(),())))
	*/
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		toStringHelper(this, s);
		return s.toString();
	}
    
    public void printTree() {
		System.out.println(this.toString());
    }

	private static void toStringHelper(TreeNode n, StringBuilder s) {
		s.append("(");
		if (n != null)  {
				s.append(n.data);
				s.append(",");
				toStringHelper(n.left, s);
				s.append(",");
				toStringHelper(n.right, s);
		}
		s.append(")");
	}

	public void checkIsBST() {
		if (!this.isBST()) throw new IllegalStateException("tree is not a BST");
	}

	public boolean isBST(){
			return isBSTHelper(this);
	}
	
	private boolean isBSTHelper(TreeNode current){
			
			boolean right= true;
			boolean left= true;
			
			if(current.right != null)
			{ if(current.data.compareTo(current.right.data) > 0)
					right = false;
			else right = isBSTHelper(current.right);
			}
			
			if(current.left != null)
			{ if(current.data.compareTo(current.left.data) < 0)
					left = false;
			else left = isBSTHelper(current.left);
			}
			
			return (right && left);
			
	}

	public boolean isLeaf() {
			return left == null &&right == null;
	}
	
	/* Two TreeNodes are t1.equals(t2) if their data are equal and left and right
	children are equals().
	*/

		@Override
		public int hashCode() {
				int hash = 5;
				return hash;
		}

		@Override
		public boolean equals(Object obj) {
				if (this == obj) {
						return true;
				}
				if (obj == null) {
						return false;
				}
				if (getClass() != obj.getClass()) {
						return false;
				}
				final TreeNode<?> other = (TreeNode<?>) obj;
				if (!Objects.equals(this.data, other.data)) {
						return false;
				}
				if (!Objects.equals(this.left, other.left)) {
						return false;
				}
				if (!Objects.equals(this.right, other.right)) {
						return false;
				}
				return true;
		}
       
}
