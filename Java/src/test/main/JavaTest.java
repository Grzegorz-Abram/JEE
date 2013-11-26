package test.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.Java;

import org.junit.Test;

public class JavaTest {

	@Test
	public void testCountDuplicates() {
		Java java = new Java();

		assertArrayEquals(
				new List[] { java.stringToList("1"), java.stringToList("6") },
				java.countDuplicates(java.stringToList("1,1,1,1,1,1")));
		assertArrayEquals(
				new List[] { java.stringToList("1,2"), java.stringToList("2,3") },
				java.countDuplicates(java.stringToList("1,1,2,2,2")));
		assertArrayEquals(
				new List[] { java.stringToList("1,3,4,5"),
						java.stringToList("2,3,1,2") },
				java.countDuplicates(java.stringToList("1,1,3,3,3,4,5,5")));
		assertArrayEquals(
				new List[] { java.stringToList(""), java.stringToList("") },
				java.countDuplicates(new ArrayList<Integer>()));
		assertArrayEquals(
				new List[] { java.stringToList(""), java.stringToList("") },
				java.countDuplicates(null));
	}

	@Test
	public void testListToArray() {
		Java java = new Java();
		List<Integer> list = java.stringToList("1,2,3,4,5");

		assertEquals("1,2,3,4,5", java.listToString(list));
		assertEquals("", java.listToString(new ArrayList<Integer>()));
		assertEquals("", java.listToString(null));
	}

	@Test
	public void testSort() {
		Java java = new Java();
		List<Integer> list = java.stringToList("1,2,3,4,5");

		assertEquals(list, java.sort(java.stringToList("1,2,3,4,5")));
		assertEquals(list, java.sort(java.stringToList("5,4,3,2,1")));
		assertEquals(list, java.sort(java.stringToList("3,4,2,5,1")));
		assertEquals(new ArrayList<Integer>(), java.sort(java.stringToList("")));
	}

	@Test
	public void testStringToList() {
		Java java = new Java();

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		assertEquals(list, java.stringToList("1,2,3,4,5"));
		assertEquals(list, java.stringToList("1, 2, 3, 4, 5"));
		assertEquals(list, java.stringToList("1 ,2 ,3 ,4 ,5"));
		assertEquals(list2, java.stringToList("A,2,3,4,5"));
		assertEquals(list2, java.stringToList("2,3,A,4,5"));
		assertEquals(list2, java.stringToList("2,3,A B,4,5"));
		assertEquals(list2, java.stringToList("2,3,3 4,4,5"));
		assertEquals(new ArrayList<Integer>(), java.stringToList(""));
		assertEquals(new ArrayList<Integer>(), java.stringToList(null));
	}
}
