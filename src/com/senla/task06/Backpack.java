package com.senla.task06;

public class Backpack {

	private int maxWeight;

	public Backpack(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxWeight;
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
		Backpack other = (Backpack) obj;
		if (maxWeight != other.maxWeight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Backpack [maxWeight=" + maxWeight + "]";
	}

}
