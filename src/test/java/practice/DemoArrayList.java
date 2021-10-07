package practice;

import java.util.ArrayList;

public class DemoArrayList {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		/*
		->insertion order maintained(sortings depends on insertion order)
		->duplicates are allowed
		->null is allowed
		->boolean value are allowed
		->character and strings are allowed 
		->Hetrogenous data are allowed
		*/
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(null);
		list.add(null);
		list.add(40);
		list.add(15);
		list.add(40);
		list.add("abc");
		list.add('c');
		list.add(true);

		System.out.println(list);

	}

}
