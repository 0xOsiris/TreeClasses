
/* A Set that supports additional operations that depend
on the elements having an ordering.
*/
public interface NavigableSet<T extends Comparable<T>> extends Set<T>{
		/* return a new NavigableSet over the keys in the TreeSet
		between fromKey (inclusive) and toKey (exclusive).

		The elements are returned smallest to largest in T's ordering
		*/
		NavigableSet<T> subSet(T fromKey, T toKey);
}
