
import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

public class BSTSetTest {
		
		public BSTSetTest() {
		}

		@Test
		public void testSize() {
				BSTSet<Integer> t = new BSTSet<>();
				t.add(10);
				assertEquals(1, t.size);
				t.add(20);
				assertEquals(2, t.size);
		}
		
		@Test
		public void testContainsA() {
				// PART 1
				BSTSet<Integer> t = new BSTSet<>();
				assertFalse(true);
		}
		@Test
		public void testContainsB() {
				// PART 1
				BSTSet<Integer> t = new BSTSet<>();
				assertFalse(true);
		}
		@Test
		public void testContainsC() {
				// PART 1
				BSTSet<String> t = new BSTSet<>();
				assertFalse(true);
		}
		// Feel free to write more contains tests!


		@Test
		public void testDeleteMinLeaf() {
			BSTSet<Integer> n = new BSTSet<>();
			n.add(30);
			n.add(20);
			n.add(50);
			n.deleteMin(n.root.right);
			Integer[] ex = {30, 20};
			assertEquals(BSTSet.bulkInsert(ex).root, n.root);
		}

		@Test
		public void testDeleteMinLeftShallow() {
			BSTSet<Integer> n = new BSTSet<>();
			n.add(30);
			n.add(20);
			n.add(50);
			n.add(49);
			n.deleteMin(n.root.right);
			Integer[] ex = {30, 20, 50};
			assertEquals(BSTSet.bulkInsert(ex).root, n.root);
		}
		
		@Test
		public void testDeleteMinLeftShallow2() {
			BSTSet<Integer> n = new BSTSet<>();
			n.add(30);
			n.add(20);
			n.add(50);
			n.add(49);
			n.add(51);
			n.deleteMin(n.root.right);
			Integer[] ex = {30, 20, 50, 51};
			assertEquals(n.root, BSTSet.bulkInsert(ex).root);
		}
		
		@Test
		public void testDeleteMinLeftDeep() {
			BSTSet<Integer> n = new BSTSet<>();
			n.add(30);
			n.add(20);
			n.add(50);
			n.add(40);
			n.add(60);
			n.add(35);
			n.add(45);
			n.deleteMin(n.root.right);
			Integer[] ex = {30, 20, 50, 40, 60, 45};
			assertEquals(n.root, BSTSet.bulkInsert(ex).root);
		}
		
		@Test
		public void testRemoveRoot1() {
				BSTSet<Integer> t = new BSTSet<>(); 
				t.add(44);
				assertTrue(t.remove(44));
				assertTrue(t.isEmpty());
		}
		@Test
		public void testRemoveRoot2() {
				BSTSet<Integer> t = new BSTSet<>(); 
				t.add(50);
				assertFalse(t.remove(25));
				assertTrue(t.remove(50));
				assertTrue(t.isEmpty());
		}
		@Test
		public void testRemoveRoot3() {
				BSTSet<Integer> t = new BSTSet<>(); 
				t.add(50);
				t.add(25);
				t.add(75);
				assertTrue(t.remove(50));
				assertTrue(t.root.data==25 || t.root.data==75);
				t.root.checkIsBST();
		}
		
		@Test 
		public void testRemoveComplex() {
			BSTSet<Integer> t = new BSTSet<>();
				t.add(44);
				t.add(17);
				t.add(62);
				t.add(32);
				t.add(50);
				t.add(78);
				t.add(48);
				t.add(54);
				t.add(88);
				assertTrue(t.remove(32));
				assertFalse(t.remove(32));
				t.root.checkIsBST();
				Integer[] ex = {44,17,62,50,78,48,54,88};
				assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}

		@Test 
		public void testRemoveComplex2() {
			BSTSet<Integer> t = new BSTSet<>();
			t.add(100);
			t.add(50);
			t.add(200);
			t.add(30);
			t.add(75);
			t.add(150);
			t.add(250);
			t.add(60);
			t.add(125);
			t.add(175);
			t.add(300);
			t.add(160);
			t.root.checkIsBST();
			t.root.printTree();
			assertTrue(t.remove(300));
			t.root.printTree();
			t.root.checkIsBST();
			Integer[] ex = {100,50,200,30,75,150,250,60,125,175,160};
			assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}
		
		@Test 
		public void testRemoveComplex3() {
			BSTSet<Integer> t = new BSTSet<>();
			t.add(100);
			t.add(50);
			t.add(200);
			t.add(30);
			t.add(75);
			t.add(150);
			t.add(250);
			t.add(60);
			t.add(125);
			t.add(175);
			t.add(300);
			t.add(160);
			t.add(155);
			t.add(165);
			t.root.checkIsBST();
			t.root.printTree();
			assertTrue(t.remove(150));
			t.root.printTree();
			t.root.checkIsBST();
			Integer[] ex = {100,50,200,30,75,155,250,60,125,175,300,160,165};
			assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}

		@Test
		public void testInsert() {
			BSTSet<Integer> n = new BSTSet<>();
			n.add(13);
			n.add(20);
			n.add(25);
			n.add(3);
			Integer[] ex = {13,20,3,25};
			assertEquals(n.root, BSTSet.bulkInsert(ex).root);
		}

		private <T extends Comparable<T>> void subsetHelper(T[] input, T fromKey, T toKey){
			// use a Java SortedSet to check ours
			java.util.SortedSet<T> exp = new java.util.TreeSet();
			exp.addAll(Arrays.asList(input));
			java.util.SortedSet expSubset = exp.subSet(fromKey, toKey);
			
			// insert into our Set and take subset
			BSTSet<T> t = BSTSet.bulkInsert(input);
			NavigableSet<T> subt = t.subSet(fromKey, toKey);
			
			// our Set should contain and not contain all the same elements
			// as the Java Set
			for (int i=0; i<input.length; i++){
				assertEquals(expSubset.contains(input[i]), subt.contains(input[i]));	
			}
		}

		@Test
		public void testSubSet() {
			Integer[] input = {100,50,150,25,75,125,175,60,79};
			subsetHelper(input, 54, 127);
		}
		
		@Test
		public void testSubSet2() {
			Integer[] input = {100,50,150,25,75,125,175,60,79};
			subsetHelper(input, 50, 100);
		}
		
		@Test
		public void testSubSet3() {
			String[] input = {"kangaroo","bass","leopard","albatross","goat","lemur","mouse","cat","gorilla"};
			subsetHelper(input, "kangaroo", "penguin");
		}
		
		@Test
		public void testSubSet4() {
			// PART 2
			assertFalse(true);
		}
		
		@Test
		public void testSubSetOutOfBounds() {
			// PART 2
			assertFalse(true);
		}

		@Test 
		public void testGenericity() {
			AVLTreeSet<String> t = new AVLTreeSet<>();
			t.add("Dog");
			assertFalse(t.contains("Cat"));
			assertTrue(t.contains("Dog"));
			
			AVLTreeSet<StringWrapper> s = new AVLTreeSet<>();
			s.add(new StringWrapper("Dog"));
			assertFalse(s.contains(new StringWrapper("Cat")));
			assertTrue(s.contains(new StringWrapper("Dog")));
		}

		private class StringWrapper implements Comparable<StringWrapper> {
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
						final StringWrapper other = (StringWrapper) obj;
						if (!Objects.equals(this.s, other.s)) {
								return false;
						}
						return true;
				}
				private final String s;
				public StringWrapper(String s) { this.s = s; }
				@Override
				public int compareTo(StringWrapper o) {
					return this.s.compareTo(o.s);
				}
		}
}
