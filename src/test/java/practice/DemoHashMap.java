package practice;

import java.util.HashMap;

public class DemoHashMap {

	public static void main(String[] args) {
		HashMap map=new HashMap();
		/*
		 * Duplicates are not allowed w.r.t. key but allowed w.r.t value
		 * Overwrite of the values are allowed
		 * Insertion order is maintained w.r.t key
		 * Null value in key and value both are allowed
		 * Null can be duplicate w.rt.value but cannot be duplicate wrt key
		 */
		
		map.put(1, 100);
		map.put(2, 200);
		map.put(3, 300);
		map.put(4, 400);
		map.put(10, "Mango");
		map.put(5, 100);
		map.put(7, 200);
		map.put(6, 300);
		map.put(9, 400);
		map.put(11, 400);
		map.put(2, 1000);
		map.put(10, "Mango");
		map.put("abc", 2000);
		map.put(null, 400);
		map.put(null, 400);
		map.put(9, null);
		map.put(9, null);
		
		System.out.println(map);
	}

}
