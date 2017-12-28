package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class CollectionJava8 {
	public static void main(String[] args) {
		// Iterable forEach default method
		List<Integer> intList = Arrays.asList(12, 35, 7, 55);

		intList.forEach(System.out::println);

		List<Integer> testRemoveItem = new ArrayList<>();
		testRemoveItem.add(1);
		testRemoveItem.add(10);
		testRemoveItem.add(5);
		// Iterator<Integer> ite = testRemoveItem.iterator();
		// // Remove element in collection
		// while(ite.hasNext()) {
		// int value = ite.next();
		// if(value % 2 == 0) {
		// ite.remove();
		// }
		// }
		// System.out.println("AFTER REMOVE ITEW");
		// testRemoveItem.forEach(System.out::println);
		System.out.println("AFTER REMOVE ITEM==============");

		// Collection removeIf default method
		testRemoveItem.removeIf(i -> i % 2 == 0);
		testRemoveItem.forEach(System.out::println);

		System.out.println("AFTER REPLACE ALL================");
		// List replaceAll default method
		intList.replaceAll(i -> 2 * i);
		intList.forEach(System.out::println);

		System.out.println("AFTER SORT==================");
		// List sort defaut method
		intList.sort((i1, i2) -> i1 - i2);
		intList.forEach(System.out::println);

		// Multi-value Map - Hash table
		Map<Integer, List<Integer>> intMultiMap = new HashMap<>();
		List<Integer> listLessThan10 = Arrays.asList(1, 2, 4, 5);
		intMultiMap.put(10, listLessThan10);
		List<Integer> listFrom10To20 = Arrays.asList(13, 16, 18);
		intMultiMap.put(20, listFrom10To20);

		intMultiMap.forEach((bound, list) -> System.out.println(bound + " " + list));
		intMultiMap.replaceAll((bound, list) -> {
			list.replaceAll(i -> i + 10);

			return list;
		});
		intMultiMap.forEach((bound, list) -> System.out.println(bound + " " + list));

		System.out.println("Add new key if not exist");
		// add new key
		intMultiMap.computeIfAbsent(30, i -> new ArrayList<Integer>()).add(25);

		intMultiMap.forEach((bound, list) -> System.out.println(bound + " " + list));

		// get a key
		List<Integer> list = intMultiMap.getOrDefault(30, new ArrayList<>());
		System.out.println(list);
	}
}
