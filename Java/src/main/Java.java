package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Java {

	public static void main(String[] args) {
		Java java = new Java();
		List<Integer> list, sortedList;

		list = java.generateIntList(20, 10);
		sortedList = java.sort(list);
		java.printIntList(sortedList);
	}

	public List<Integer> sort(List<Integer> list) {
		List<Integer> sortedList = new ArrayList<Integer>(list);
		int actual, next, temp;

		for (int i = 0; i < sortedList.size(); i++) {
			for (int j = 0; j < sortedList.size() - 1; j++) {
				if (sortedList.get(j) > sortedList.get(j + 1)) {
					actual = sortedList.get(j);
					next = sortedList.get(j + 1);

					temp = next;
					next = actual;
					actual = temp;

					sortedList.set(j, actual);
					sortedList.set(j + 1, next);
				}
			}
		}

		return sortedList;
	}

	public void printIntList(List<Integer> list) {
		for (Integer integer : list) {
			System.out.print(integer + "  ");
		}
	}

	public List<Integer> generateIntList(int size, int range) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(new Random().nextInt(range));
		}

		return list;
	}

	public String listToString(List<Integer> list) {
		String string = "";

		try {
			for (Integer integer : list) {
				string += "," + integer;
			}

			string = string.substring(1);
		} catch (StringIndexOutOfBoundsException e) {
		} catch (NullPointerException e) {
		}

		return string;
	}

	public List<Integer> stringToList(String string) {
		List<Integer> list = new ArrayList<Integer>();

		try {
			String[] array = string.split(",");

			for (String element : array) {
				try {
					list.add(Integer.parseInt(element.trim()));
				} catch (NumberFormatException e) {
				}
			}
		} catch (NullPointerException e) {
		}

		return list;
	}
}
