package jp.co.foo;

import com.google.common.collect.HashMultimap;

public class Guava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMultimap<String, String> hashMultimap = HashMultimap.create();
		hashMultimap.put("a", "b");
		hashMultimap.put("a", "c");
		System.out.println(hashMultimap);
	}

}
