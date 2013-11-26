package main;

import java.util.ArrayList;
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

	private List<Integer> sort(List<Integer> list) {
		List<Integer> sortedList = new ArrayList<Integer>();

		return sortedList;
	}

	private void printIntList(List<Integer> list) {
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	private List<Integer> generateIntList(int size, int range) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(new Random().nextInt(range));
		}

		return list;
	}
}
