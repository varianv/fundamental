package sort;

import sort.method.Bubble;
import sort.method.Insertion;
import sort.method.Selection;

public class Sort extends RandNum {
	static Selection selection = new Selection();
	static Bubble bubble = new Bubble();
	static Insertion insertion = new Insertion();
	
	public static void main(String[] args) {
		int[] listInt = generateRandNum(2000);
		int[] listInt2 = listInt;
		int[] listInt3 = listInt;
		
		System.out.println("Before : " + Util.arrToStr(listInt));
		
		long start = System.nanoTime();
		listInt = selection.sort(listInt);
		System.out.println("Time elapsed : " + (System.nanoTime()-start) + " ns");

//		System.out.println("After1 : " + Util.arrToStr(listInt));
		
		start = System.nanoTime();
		listInt2 = bubble.sort(listInt2);
		System.out.println("Time elapsed : " + (System.nanoTime()-start) + " ns");

//		System.out.println("After2 : " + Util.arrToStr(listInt2));
		
		start = System.nanoTime();
		listInt3 = insertion.sort(listInt3);
		System.out.println("Time elapsed : " + (System.nanoTime()-start) + " ns");
		
//		System.out.println("After3 : " + Util.arrToStr(listInt3));
	}
}
