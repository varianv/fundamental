package sort;

public final class Util {
	/**
	 * Generate string from array.
	 * @param arr
	 * @return str
	 */
	public static String arrToStr(int[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) str = String.valueOf(arr[i]);
			else str = str + " | " + arr[i];
		}
		return str;
	}
}
