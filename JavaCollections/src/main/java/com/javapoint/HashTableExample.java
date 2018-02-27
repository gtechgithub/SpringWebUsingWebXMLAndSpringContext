package com.javapoint;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExample {

	public static void main(String arg[]) {
		
		Hashtable <String,Double> balance = new Hashtable <String,Double> ();
		
		balance.put("John Doe", 3434.34);
		balance.put("Tom Smith", 123.22);
		balance.put("Jane Baker", 1378.00);
		balance.put("Tod Hall", 99.22);
		balance.put("Ralph Smith", -19.08);
		
		Enumeration<String> keys = balance.keys();
		
		System.out.println("Printing all values \n------------------");
		
		while(  keys.hasMoreElements()) {
			String key = keys.nextElement();
			Double value = balance.get(key);
			
			System.out.println(key + " ===>" + value);
		}
		
		
		
		// Deposit 1,000 into John Doe's account.
		double bal = balance.get("John Doe");
		balance.put("John Doe", bal+ 1000);

		System.out.println("\n------------------");
		System.out.println("John Doe new balance:" + balance.get("John Doe"));
	}
}
