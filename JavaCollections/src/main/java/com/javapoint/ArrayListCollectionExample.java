package com.javapoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListCollectionExample {

	public static void main (String args[]) {

	//Array List implement from List interface
	ArrayList<String> arrayCol = new ArrayList<String>();
	arrayCol.add("C");
	arrayCol.add("A");
	arrayCol.add("B");
	arrayCol.add("D");
	arrayCol.add("F");
	arrayCol.add(1,"A1");
	
	System.out.println("Array size:" + arrayCol.size());
	System.out.println("contents of Array:" + arrayCol);

	arrayCol.remove(2);
	arrayCol.remove("D");

	//allocating capacity
	arrayCol.ensureCapacity(1);
	arrayCol.trimToSize();
	
	System.out.println("Array size:" + arrayCol.size());
	System.out.println("contents of Array:" + arrayCol);


	//using iterator
	Iterator<String> iter  =  arrayCol.iterator();
	
	while (iter.hasNext()) {
		
		System.out.println(iter.next());
	}
	

	//converting into array
	String arr[] = new String[arrayCol.size()];
	arrayCol.toArray(arr);
	
	System.out.println("printing from Array");
	for (String val : arr) {
		System.out.println(val);
	}
	
	
	}
	
	
}
