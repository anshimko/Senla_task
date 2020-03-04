package com.senla.task06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
	Задача решена методом динамического программирования
*/
public class PackerLogic {

	public Set<Item> findTheBestCombinationOfItems(Set<Item> allItem, Backpack backpack) {

		List<Item> allItemList = new ArrayList<>(allItem);

		allItemList.add(0, null);
		Map<Cell, CellValue> matrix = initMatrix(backpack.getMaxWeight(), allItemList.size());

		for (int i = 1; i < allItemList.size(); i++) {
			for (int j = 1; j <= backpack.getMaxWeight(); j++) {
				Item current = allItemList.get(i);
				if (j - current.getWeight() >= 0) {
					CellValue prevCellValue = matrix.get(new Cell(j - current.getWeight(), i - 1));

					Set<Item> newItemsSet = new HashSet<>(prevCellValue.getItems());
					newItemsSet.add(current);

					CellValue firstCellValue = new CellValue(current.getCost() + prevCellValue.getValue(), newItemsSet);
					CellValue secondCellValue = matrix.get(new Cell(j, i - 1));

					CellValue newCellValue = max(firstCellValue, secondCellValue);
					matrix.put(new Cell(j, i), newCellValue);
				} else {
					matrix.put(new Cell(j, i), matrix.get(new Cell(j, i - 1)));
				}
			}
		}

		return matrix.get(new Cell(backpack.getMaxWeight(), allItemList.size() - 1)).getItems();
	}

	private CellValue max(CellValue first, CellValue second) {
		int max = Math.max(first.getValue(), second.getValue());
		if (max == first.getValue()) {
			return first;
		}
		return second;
	}

	private Map<Cell, CellValue> initMatrix(int backpackMaxWeight, int numAllItem) {
		Map<Cell, CellValue> matrix = new HashMap<>();
		for (int i = 0; i <= backpackMaxWeight; i++) {
			matrix.put(new Cell(i, 0), new CellValue(0, new HashSet<>()));
		}
		for (int i = 0; i < numAllItem; i++) {
			matrix.put(new Cell(0, i), new CellValue(0, new HashSet<>()));
		}
		return matrix;
	}

	private class Cell {
		private int backpackMaxWeight;
		private int itemCost;

		Cell(int backpackMaxWeight, int itemCost) {
			this.backpackMaxWeight = backpackMaxWeight;
			this.itemCost = itemCost;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + backpackMaxWeight;
			result = prime * result + itemCost;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (backpackMaxWeight != other.backpackMaxWeight)
				return false;
			if (itemCost != other.itemCost)
				return false;
			return true;
		}

	}

	private class CellValue {

		private int value;
		private Set<Item> Items;

		CellValue(int value, Set<Item> Items) {
			this.value = value;
			this.Items = Items;
		}

		int getValue() {
			return value;
		}

		Set<Item> getItems() {
			return Items;
		}
	}
}