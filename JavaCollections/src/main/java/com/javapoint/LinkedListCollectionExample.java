package com.javapoint;

import java.util.LinkedList;

public class LinkedListCollectionExample {

	public static void main(String args[]) {
	
	//linked list extends from abstractsequentiallist and implements from List, Deque and Queue
	LinkedList<String> LinkList = new LinkedList<String>();
	LinkList.add("F");
	LinkList.add("B");
	LinkList.add("D");
	LinkList.add("E");
	LinkList.add("C");
	
	LinkList.addFirst("Z");
	LinkList.addLast("A");

	LinkList.add(1, "I");
	
	System.out.println("printing all contents:" + LinkList);
	
	LinkList.remove();
	LinkList.remove(2);
	LinkList.remove("D");
	
	System.out.println("printing all contents after deletion:" + LinkList);
	

	//getting and setting the value
	System.out.println("getting values for LinkList.get(1):" + LinkList.get(1));
	
	LinkList.set(1,"D2");
	
	System.out.println("getting values for LinkList.get(1) after setting:" + LinkList.get(1));
	
	}
	
	
}
