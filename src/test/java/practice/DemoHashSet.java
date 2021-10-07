package practice;

import java.util.HashSet;

public class DemoHashSet {

	public static void main(String[] args) {
		HashSet set=new HashSet();
		/*insertion order is not maintained
		 * Duplicate are not allowed
		 * Haterogenous are allowed
		 * Null is valid only once*/
		set.add(10);
		set.add(20);
		set.add(40);
		set.add(15);
		set.add(25);
		set.add("Mango");
		set.add('p');
		set.add(10);
		set.add(null);
		set.add(null);
		System.out.println(set);
		

	}

}
