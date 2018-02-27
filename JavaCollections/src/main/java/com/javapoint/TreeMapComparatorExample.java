package com.javapoint;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/*** 
 * Program to sort based on the last name using Comparator inteface and TreeMap
 * @author gocothakotai
 *
 */


class TreeMapComparator implements Comparator<String>{

	//compare based on the last name
	@Override 
	public int compare(String a , String b) {
		
		int indexOfa = a.lastIndexOf(' ');
		int indexOfb = b.lastIndexOf(' ');
		
		int k = a.substring(indexOfa).compareTo(b.substring(indexOfb));
		
		if (k==0) {
			
			//last names of both the string are equal, hence compare the entire name
			return (a.compareTo(b)); 
		}
		else
		{
			return k;
		}
	}

}


public class TreeMapComparatorExample {
	
	
	public static void main(String args[]) {
		
		TreeMap <String,Double> tm = new TreeMap<String,Double> (new TreeMapComparator());
		
		//populate the entries
		tm.put("John Doe", new Double(3434.34));
		tm.put("Tom Smith", new Double(123.22));
		tm.put("Jane Baker", new Double(1378.00));
		tm.put("Tod Hall", new Double(99.22));
		tm.put("Ralph Smith", new Double(-19.08));
		
		//get the set of entries
		Set<Map.Entry<String,Double>> set =  tm.entrySet();
		

		//display the elements
		for(Entry <String,Double> entry: set) {
			System.out.println(entry.getKey() + " ==>" + entry.getValue());
		}
	}
}