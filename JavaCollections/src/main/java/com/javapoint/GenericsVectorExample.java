package com.javapoint;

import java.util.Enumeration;
import java.util.Vector;

/*
 * Vector first argument is capacity and second is size, when new elements need to added after capacity
 * has reached it refer to the incremental size, if not specified it just doubles the capacity
 * 
 */
public class GenericsVectorExample {

	public static void main(String args[]) {
		
		Vector<Integer> v = new Vector<Integer>(3,2);
		
		System.out.println("Initial size: " + v.size());
		System.out.println("Initial capacity: " + v.capacity());
		
		v.addElement(new Integer("1"));
		v.addElement(new Integer("2"));
		v.addElement(new Integer("3"));
		v.addElement(new Integer("4"));
		v.addElement(new Integer("5"));
	
		System.out.println("Capacity after five additions: " +
				v.capacity());
		
		v.addElement(6);
		System.out.println("Current capacity: " + v.capacity());

		System.out.println("Element at position zero: " + v.elementAt(0));
		System.out.println("First Element: " + v.firstElement());
		System.out.println("Last Element: " + v.lastElement());

		// Enumerate the elements in the vector.
		Enumeration<Integer> en = v.elements();

		System.out.println("\nElements in vector:");
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}
	
}
