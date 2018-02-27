package com.javapoint;

import java.util.LinkedList;

class Address{
	
	private String name;
	private String city;
	private String street;
	private String pincode;
	
	Address(String name,String city, String street, String pincode){
		this.name =  name;
		this.city = city;
		this.street= street;
		this.pincode= pincode;
	}
	
	@Override
	public String toString() {
		return name + "\n " + city + "\n " + street + "\n " + pincode;
	}
}

public class UserDefinedCollections {

	public static void main(String args[]) {
		LinkedList<Address> ml = new LinkedList<Address>();
		
		Address add1 = new Address ("name1","city1","street1","pincode1");
		Address add2 = new Address ("name2","city2","street2","pincode2");
		
		ml.add(add1);
		ml.add(add2);
		
		for(Address adr: ml) {
			System.out.println(adr);
		}
	}
}
