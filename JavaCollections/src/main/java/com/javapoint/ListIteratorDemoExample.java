package com.javapoint;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemoExample {

	public static void main (String args[]) {
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		
		// Modify objects being iterated.
		ListIterator<String> iter = al.listIterator();
		while (iter.hasNext()) {
			String element = iter.next();
			iter.set(element + "+");
		}
		
		// printing values
		while (iter.hasPrevious()) {
			System.out.println("printing values:" + iter.previous());
		}				
		
	}
}
