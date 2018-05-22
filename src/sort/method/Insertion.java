package sort.method;

import sort.RandNum;
import sort.SortInt;

public class Insertion extends RandNum implements SortInt {
	@Override
	public int[] sort(int[] arr) {
		System.out.println("===== Insertion Sort " + arr.length + " Numbers =====");
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] > arr[i+1]) {
				int temp = arr[i+1];
				for (int j = i; j >= 0; j--) {
					if (arr[j] < temp) {
						break;
					}
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
