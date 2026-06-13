package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		
		int sum=4;
		int target=0;
		Map<Integer, Integer> inventory = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			
			target=sum-arr[i];
			
			if(inventory.isEmpty()==true || inventory.containsKey(target)==false) {
				inventory.put(arr[i], i);
				
			}
			else {
				System.out.println("target found at index "+inventory.get(target)+" and "+i);
				break;
			}
		
			

}}}
