
import org.junit.Test;
import static org.junit.Assert.*;

/* Most of these test cases are white box. That is,
they are aware of the particular implementation of AVLTreeSet

This is evident in statements like
    assertEquals(BSTSet.bulkInsert(ex).root, t.root);
*/
public class AVLTreeSetTest {
		
		public AVLTreeSetTest() {
		}

		@Test
		public void testIsEmpty() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				assertTrue(t.isEmpty());
		}

		@Test
		public void testInsertBalancedOrder() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(50);
				assertEquals(t.root.height, 1);
				t.add(25);
				assertEquals(t.root.height, 2);
				t.add(75);
				assertEquals(t.root.height, 2);
				t.add(12);
				assertEquals(t.root.height, 3);
				t.add(37);
				assertEquals(t.root.height, 3);
				t.add(62);
				assertEquals(t.root.height, 3);
				t.add(87);
				t.checkIsBalanced();
				t.root.checkIsBST();
				assertEquals(t.root.height, 3);
		}
		
		@Test
		public void testInsertDecreasing() {
				AVLTreeSet<Integer> t = new AVLTreeSet(); 
				t.add(75);
				assertEquals(t.root.height, 1);
				t.add(50);
				assertEquals(t.root.height, 2);
				t.add(25);
				t.checkIsBalanced();
				t.root.checkIsBST();
				assertEquals(t.root.height, 2);
				assertEquals((int)t.root.data, 50);
		}

		@Test
		public void testInsertIncreasing() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(25);
				assertEquals(t.root.height, 1);
				t.add(50);
				assertEquals(t.root.height, 2);
				t.add(75);
				assertEquals(t.root.height, 2);
				Integer[] ex = {50,25,75};
				assertEquals(BSTSet.bulkInsert(ex).root, t.root);
				t.add(100);
				assertEquals(t.root.height, 3);
				assertEquals((int)t.root.data, 50);
				t.add(125);
				t.checkIsBalanced();
				t.root.checkIsBST();
				Integer[] ex2 = {50,25,100,75,125};
				assertEquals(BSTSet.bulkInsert(ex2).root, t.root);
				assertEquals(t.root.height, 3);
		}

		@Test
		public void testInsertSimpleRotateLeftRight() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(50);
				assertEquals(t.root.height, 1);
				t.add(25);
				assertEquals(t.root.height, 2);
				t.add(30);
				t.checkIsBalanced();
				t.root.checkIsBST();
				assertEquals(t.root.height, 2);
				Integer[] ex = {30,25,50};
				assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}
		
		@Test
		public void testInsertSimpleRotateRightLeft() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(50);
				assertEquals(t.root.height, 1);
				t.add(75);
				assertEquals(t.root.height, 2);
				t.add(60);
				t.checkIsBalanced();
				t.root.checkIsBST();
				assertEquals(t.root.height, 2);
				Integer[] ex = {60,50,75};
				assertEquals(BSTSet.bulkInsert(ex).root, t.root);
				t.root.printTree();
				assertEquals((int)t.root.data, 60);
				assertEquals((int)t.root.left.data, 50);
				assertEquals((int)t.root.right.data, 75);
		}
		
		@Test
		public void testInsertComplexRotateLeftRight() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(44);
				t.add(17);
				t.add(78);
				t.add(32);
				t.add(50);
				t.add(88);
				t.add(48);
				t.add(62);
				t.add(54);
				t.checkIsBalanced();
				t.root.checkIsBST();
				Integer[] ex = {44,17,62,32,50,78,48,54,88};
				assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}


		@Test
		public void testRemoveRoot1() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(44);
				t.remove(44);
				assertTrue(t.isEmpty());
		}
		@Test
		public void testRemoveRoot2() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(50);
				t.remove(25);
				t.remove(50);
				assertTrue(t.isEmpty());
		}
		@Test
		public void testRemoveRoot3() {
				AVLTreeSet<Integer> t = new AVLTreeSet<>(); 
				t.add(50);
				t.add(25);
				t.add(75);
				t.remove(50);
				assertTrue(t.root.data==25 || t.root.data==75);
				t.root.checkIsBST();
		}
		@Test 
		public void testRemoveComplex() {
			AVLTreeSet<Integer> t = new AVLTreeSet<>();
				t.add(44);
				t.add(17);
				t.add(62);
				t.add(32);
				t.add(50);
				t.add(78);
				t.add(48);
				t.add(54);
				t.add(88);
				t.remove(32);
				t.checkIsBalanced();
				t.root.checkIsBST();
				assertEquals(t.root.height, 4);
				Integer[] ex = {62,44,78,17,50,88,48,54};
				assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}

		@Test 
		public void testRemoveComplex2() {
			AVLTreeSet<Integer> t = new AVLTreeSet<>();
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
			t.checkIsBalanced();
			t.root.checkIsBST();
			t.root.printTree();
			t.remove(300);
			t.root.printTree();
			t.checkIsBalanced();
			t.root.checkIsBST();
			assertEquals(t.root.height, 4);
			Integer[] ex = {100,50,175,75,150,200,30,60,125,160,250};
			assertEquals(BSTSet.bulkInsert(ex).root, t.root);
		}
		

		// PART 4: Optionally add tests for the rotateLeft/rotateRight methods
		// if it helps with debugging
		@Test
		public void testRotateRight() {
		}

		@Test
		public void testRotateLeft() {
		}

		@Test
		public void testDoubleRotateLeftThenRight() {
		}

		@Test
		public void testDoubleRotateRightThenLeft() {
		}

		
}
