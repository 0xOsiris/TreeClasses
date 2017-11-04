
/* The Set ADT, which is a collection of elements
with no duplicates and no ordering.
*/
public interface Set<T> {
		/* Add e to the Set */	
		public void add(T e);
		
		/* Return true if and only if e is in this Set */	
		public boolean contains(T e);
		
		/* Remove e from the Set and return true if e was found */	
		public boolean remove(T e);
				
}
