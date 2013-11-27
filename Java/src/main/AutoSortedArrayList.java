package main;

import java.util.ArrayList;

public class AutoSortedArrayList extends ArrayList<Integer> {

	private boolean autoSorted = true;

	public boolean isAutoSorted() {
		return autoSorted;
	}

	public void setAutoSorted(boolean autoSorted) {
		this.autoSorted = autoSorted;
	}

	@Override
	public boolean add(Integer e) {
		boolean ret = super.add(e);

		if (autoSorted) {
			sort();
		}

		return ret;
	}

	public void sort() {
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < this.size() - 1; j++) {
				if (this.get(j) > this.get(j + 1)) {
					swapElements(j, j + 1);
				}
			}
		}
	}

	public void swapElements(int place1, int place2) {
		int temp = this.get(place2);
		this.set(place2, this.get(place1));
		this.set(place1, temp);
	}
}
