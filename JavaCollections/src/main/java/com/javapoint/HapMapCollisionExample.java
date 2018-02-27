package com.javapoint;

import java.util.*;

/**
 * How does get(Key key) method works internally in HashMap:

Here are steps, which happens, when you call get() method with key object to retrieve corresponding value from hash based collection

a) Key.hashCode() method is used to find the bucket location in backing array. (Remember HashMap is backed by array in Java) Though hashcode() is not used directly, but they are passed to internal hash() function.

b) In backing array or better known as bucket, key and values are stored in form of a nested class called Entry. If there is only one Entry at bucket location, than value from that entry is returned. Pretty straightforward right?

Things get little tricky, when Interviewer ask second question, What happens if two keys has same hashCode? If multiple keys has same hashCode, than during put() operation collision had occurred, which means multiple Entry object stored in a bucket location. Each Entry keep track of another Entry, forming a linked list data structure there. Now, if we need to retrieve value object in this situation, following steps will be followed :

1) Call hashCode() method of key to find bucket location.

2) Traverse thought linked list, comparing keys in each entries using keys.equals() until it return true.

So, we use equals() method of key object to find correct entry and than return value from that.

 * 
 * 
 * 
 * @author gocothakotai
 *
 */

class Person{

	 int id;
	 String name;
	
	 Person(int id, String name){
		 this.id =  id;
		 this.name = name;
	 }
	 
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		
		boolean returnValue = false;
		
		if ( ((Person)o).getId() == id &&  ((Person)o).getName() == name ) {
			return true;
		}
		
		return returnValue;
	}
	
}

public class HapMapCollisionExample {

	public static void main(String args[]) {
		
		HashMap <Person,Integer> hm = new HashMap<Person,Integer>();
		Person p1 =  new Person(1,"name1" );
		Person p2 =  new Person(2,"name2" );
		Person p3 =  new Person(3,"name3" );
		Person p4 =  new Person(1,"name4" );
		Person p5 =  new Person(1,"name5" );
		
		
		hm.put(p1,1);
		hm.put(p2,2);
		hm.put(p3,3);
		hm.put(p4,4);
		hm.put(p5,5);
		
		
		System.out.println("getting non collision values for (new Person(3,\"name3\" ),3)" + hm.get(p3));
		
		System.out.println("\n \n");
		
		
		System.out.println("getting collision values for (new Person(1,\"name1\" ),1)" + hm.get(p1));
		
		
	}
	
}
