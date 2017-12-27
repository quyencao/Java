package Intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GenericTest {
	public static <E> void printList(List<E> l) {
		for(E e: l) {
			System.out.printf(e + " ");
		}
		System.out.println();
	}
	
	public static <E extends Number & Comparable<E>> E max(E x, E y, E z) {
		E max = x;
		
		if(y.compareTo(max) > 0) {
			max = y;
		}
		
		if(z.compareTo(max) > 0) {
			max = z;
		}
		
		return max;
	}
	
	public static double sum(List<? extends Number> l) {
		return l.stream().mapToDouble(i -> i.doubleValue()).sum();
	}
	
	public static void main(String[] args) {
		Box<Integer> box1 = new Box();
		box1.add(1);
		box1.add(2);
		printList(box1.getBox());
		
		Box<String> box2 = new Box();
		box2.add("A");
		box2.add("B");
		printList(box2.getBox());
		
		System.out.println(max(1,2,3));
//		System.out.println(max("A", "B", "C"));
		
		System.out.println(sum(Arrays.asList(1,2,3)));
		System.out.println(sum(Arrays.asList(1.1,2.2,3.3)));
		
		//List<String> ls = new ArrayList<String>(); // 1
		//List<Object> lo = ls; // 2 

	}
}

class Box<T> {
	private List<T> box;

	public Box() {
		this.box = new ArrayList<>();
	}
	
	public void add(T t) {
		this.box.add(t);
	}
	
	public List<T> getBox() {
		return this.box;
	}
	
	public void display() {
		for(T t: this.box) {
			System.out.println(t);
		}
	}
}
