package practice;

import java.util.TreeSet;

public class DemoTreeSet {

	public static void main(String[] args) {
		TreeSet tree=new TreeSet();
		/*
		 * class cast exception when adding string
		 * Sorting order is in accending order
		 * Null point exception when giving null value*/
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.add(40);
		tree.add(40);
		tree.add(15);
		//tree.add("Mango");
		//tree.add(null);
		
		System.out.println(tree);

	}

}
