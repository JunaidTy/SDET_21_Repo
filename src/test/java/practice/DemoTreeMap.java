package practice;

import java.util.TreeMap;

public class DemoTreeMap {

	public static void main(String[] args) {
		TreeMap tmap=new TreeMap();
		/*
		 * hetrogenous key are not allowed
		 * Duplicate are not allowed wrt key and allowed wrt to value
		 * null is not wrt to key(giving null point exception) but wrt value it is allowed*/
		tmap.put(1, 100);
		tmap.put(2, 200);
		tmap.put(3, 300);
		tmap.put(4, 400);
		tmap.put(4, 400);
		tmap.put(5, 400);
		tmap.put(4, 400);
		tmap.put(6, null);
		//tmap.put(null, 400);
		
		
		System.out.println(tmap);

	}

}
