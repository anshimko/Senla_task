package com.senla.task06;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		Set<Item> items = new HashSet<>();
		items.add(new Item("Player", 4, 3000));
		items.add(new Item("Notebook", 3, 2000));
		items.add(new Item("Guitar", 1, 1500));
		items.add(new Item("Phone", 1, 2000));
		
		PackerLogic packer = new PackerLogic();
		
		Set<Item> searchItems = packer.findTheBestCombinationOfItems(items, new Backpack(4));
		
		System.out.println(searchItems);

	}
}
