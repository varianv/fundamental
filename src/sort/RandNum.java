package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandNum {
	static int[] generateRandNum(int size) {
		List<Integer> listInt = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			listInt.add(i+1);
		}
		Collections.shuffle(listInt);
		int[] arrInt = new int[listInt.size()];
		for (int i = 0; i < size; i++) {
			arrInt[i] = listInt.get(i);
		}
		return arrInt;
	}
}
