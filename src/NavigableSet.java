import java.util.Iterator;

/* A Set that supports additional operations that depend
on the elements having an ordering.
*/
public interface NavigableSet<T extends Comparable<T>> extends Set<T>{
		/* return an iterator over the keys in the TreeSet
		between start (inclusive) and end (exclusive).

		The elements are returned smallest to largest in T's ordering
		*/
		Iterator<T> keysInRange(T start, T end);
}
