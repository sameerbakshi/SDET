package JavaActivity1;

import java.util.ArrayList;
import java.util.List;;

public class ArrayListClass {
	
	public static void main(String[] args) {
		List <String> myList = new ArrayList <String>();
		myList.add("Tom");
		myList.add("Jerry");
		myList.add("John");
		myList.add("Tony");
		myList.add("Steve");
		for (String name:myList) {
			System.out.println(name);
		}
		System.out.println("Third name is:"+myList.get(2));
		if(myList.contains("Steve"))
			System.out.println("Steve exists");
		System.out.println("Size of list is:"+myList.size());
		myList.remove("Tony");
		System.out.println("Size of list is:"+myList.size());
	}
}
