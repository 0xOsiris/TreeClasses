
import java.util.Random;
import java.util.TreeSet;



public class StressTest {
	public static void main(String[] args) {
		System.out.println("\nTesting BSTSet...");
		{
				BSTSet<Integer> su = new BSTSet<>();
				uniformRandom(su);
				su.root.checkIsBST();
				su.updateHeightWholeTree(); // calculate height at the end
				long minHeight = (long)Math.ceil(Math.log(su.size)/Math.log(2));
				System.out.println("final height: "+su.root.height+ " / lower bound: "+minHeight);
		}
		System.gc(); // force the Java garbage collector to run before the next test
		{
				BSTSet<Integer> su = new BSTSet<>();
				increasing(su);
				su.root.checkIsBST();
				su.updateHeightWholeTree(); // calculate height at the end
				long minHeight = (long)Math.ceil(Math.log(su.size)/Math.log(2));
				System.out.println("final height: "+su.root.height+ " / lower bound: "+minHeight);
		}
		System.gc();

		System.out.println("\nTesting AVLTreeSet...");
		{
				AVLTreeSet<Integer> sb = new AVLTreeSet<>();
				uniformRandom(sb);
				sb.root.checkIsBST();
				sb.checkIsBalanced();
				long minHeight = (long)Math.ceil(Math.log(sb.size)/Math.log(2));
				System.out.println("final height: "+sb.root.height+ " / lower bound: "+minHeight);
		}
		System.gc();
		{
				AVLTreeSet<Integer> sb = new AVLTreeSet<>();
				increasing(sb);
				sb.root.checkIsBST();
				sb.checkIsBalanced();
				long minHeight = (long)Math.ceil(Math.log(sb.size)/Math.log(2));
				System.out.println("final height: "+sb.root.height+ " / lower bound: "+minHeight);
		}
		System.gc();

		// Java's implementation
		System.out.println("\nTesting java.util.TreeSet...");
		{
				TreeSet<Integer> st = new TreeSet<>();
				uniformRandom(st);
		}
		System.gc();
		{
				TreeSet<Integer> st = new TreeSet<>();
				increasing(st);
		}
	}	

	public static void uniformRandom(Set<Integer> dut) {
		System.out.println("\tUniform random inputs");
		final int inserts = 5000000;
		Random r = new Random();   // give constructor a seed it you want it deterministic

		long start = System.currentTimeMillis();
		for (int i=0; i<inserts; i++) {
			dut.add(r.nextInt());
		}	
		long end = System.currentTimeMillis();
		System.out.println("\taveraged "+(float)(end-start)/inserts +"ms per insert");
	}
	
	public static void increasing(Set<Integer> dut) {
		System.out.println("\tIncreasing inputs");
		final int inserts = 10000;

		long start = System.currentTimeMillis();
		for (int i=0; i<inserts; i++) {
			dut.add(i);
		}	
		long end = System.currentTimeMillis();
		System.out.println("\taveraged "+(float)(end-start)/inserts +"ms per insert");
	}
	
	public static void uniformRandom(java.util.Set<Integer> dut) {
		System.out.println("\tUniform random inputs");
		final int inserts = 5000000;
		Random r = new Random();   // give constructor a seed it you want it deterministic

		long start = System.currentTimeMillis();
		for (int i=0; i<inserts; i++) {
			dut.add(r.nextInt());
		}	
		long end = System.currentTimeMillis();
		System.out.println("\taveraged "+(float)(end-start)/inserts +"ms per insert");
	}
	
	public static void increasing(java.util.Set<Integer> dut) {
		System.out.println("\tIncreasing inputs");
		final int inserts = 10000;

		long start = System.currentTimeMillis();
		for (int i=0; i<inserts; i++) {
			dut.add(i);
		}	
		long end = System.currentTimeMillis();
		System.out.println("\taveraged "+(float)(end-start)/inserts +"ms per insert");
	}
}
