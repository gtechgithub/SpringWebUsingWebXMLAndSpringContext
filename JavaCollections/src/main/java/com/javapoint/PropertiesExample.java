package com.javapoint;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String args[]) {

		Properties prop = new Properties();

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		FileInputStream fin = null;

		try {

			fin = new FileInputStream("C:\\Users\\gocothakotai\\Desktop\\phonebook.dat");

			// load properties from file
			if (fin != null) {
				prop.load(fin);
				fin.close();
			}

			// adding new key and values
			String keyin;
			String keyinName;
			boolean changed = false;
			
			System.out.println("enter name if not type 'quit':");
			while (!(keyin = buf.readLine()).equals("quit")) {

				System.out.println("enter phone no");
				keyinName = buf.readLine();
				prop.put(keyin, keyinName);
				changed = true;
				
				System.out.println("enter name if not type 'quit':");
				
			}

			// store the values
			if (true) {

				FileOutputStream fop = new FileOutputStream("C:\\Users\\gocothakotai\\Desktop\\phonebook.dat");
				prop.store(fop, "Telephone book");
				fop.close();
			}

			System.out.println(" enter name to retrieve phone no if not type 'quit':");
			
			// display based on the name
			while (!(keyin = buf.readLine()).equals("quit")) {
				System.out.println("printing telelphone no for " + keyin + ":" + prop.get(keyin));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}