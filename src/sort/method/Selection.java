package sort.method;

import sort.SortInt;

public class Selection implements SortInt {
	@Override
	public int[] sort(int[] arr) {
		System.out.println("===== Selection Sort " + arr.length + " Numbers =====");
		for (int i = 0; i < arr.length-1; i++) {
			int minLoc = 0;
			for (int j = i; j < arr.length; j++) {
				if (j == i) minLoc = j;
				if (arr[minLoc] > arr[j]) minLoc = j;
			}
			int temp = arr[i];
			arr[i] = arr[minLoc];
			arr[minLoc] = temp;
		}
		return arr;
	}
}
