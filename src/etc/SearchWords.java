package etc;

import java.util.Scanner;

public class SearchWords {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Row    : ");
		int row = s.nextInt();
		System.out.print("Column : ");
		int column = s.nextInt();
		System.out.println("============");
		
		char[][] chars = new char[row][column];
		
		for (int i = 0; i < row; i++) {
			String rowStr = inputRow(s, i, column);
			for (int j = 0; j < column; j++) {
				// mengisi matriks
				chars[i][j] = rowStr.charAt(j);
			}
		}
		
		System.out.println("== Matrix ==");
		for (int k = 0; k < chars.length; k++) {
			for (int l = 0; l < chars[0].length; l++) {
				System.out.print(chars[k][l] + " ");
			}
			System.out.println();
		}
		System.out.println("============");
		
		System.out.print("Word   : ");
		String word = s.next();
		int wordInt = 0;
		
		// pergerakan matriks dimulai dari arah jam 12, 1.30, 3, 4.30, 6, 7.30, 9, dan 10.30
		int[] x = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] y = {-1, -1, 0, 1, 1, 1, 0, -1};
		
		// inisialisasi nilai matrix xTemp dan yTemp dengan angka -1
		int[] xTemp = new int[row*column];
		for (int xx = 0; xx < xTemp.length; xx++) {
			xTemp[xx] = -1;
		}
		int[] yTemp = new int[row*column];
		for (int yy = 0; yy < yTemp.length; yy++) {
			yTemp[yy] = -1;
		}
		int numTemp = 0;
		
		// cari koordinat semua huruf di matriks "chars" yang sama dengan huruf pertama "word"
		for (int rows = 0; rows < row; rows++) {
			for (int columns = 0; columns < column; columns++) {
				if (chars[rows][columns] == word.charAt(wordInt)) {
					xTemp[numTemp] = columns;
					yTemp[numTemp] = rows;
					numTemp = numTemp+1;
				}
			}
		}
		
		int result = 0;
		
		// loop sejumlah huruf pertama "word" di matriks "chars"
		for (int loop = 0; loop < numTemp; loop++) {
			// loop sejumlah pergerakan matriks "x" dan "y" = 8 arah
			for (int index = 0; index < 8; index++) {
				// pengecekan apakah koordinat+pergerakan matriks masih dalam range matriks "chars"
				if ((xTemp[loop]+x[index] >= 0 && yTemp[loop]+y[index] >= 0) && 
					(xTemp[loop]+x[index] < column && yTemp[loop]+y[index] < row)) {
					int xIndex = x[index];
					int yIndex = y[index];
					int xNew = xTemp[loop];
					int yNew = yTemp[loop];
					// loop sejumlah "word" dimulai dari karakter kedua hingga selesai
					for (int temp = 1; temp < word.length(); temp++) {
						xNew = xNew+xIndex;
						yNew = yNew+yIndex;
						// pengecekan apakah koordinat+pergerakan matriks masih dalam range matriks "chars"
						if ((xNew >= 0 && yNew >= 0) && (xNew < column && yNew < row)) {
							// ambil isi matriks "chars" dengan x -> column, y -> row
							char test1 = chars[yNew][xNew];
							// ambil karakter di "word" kesekian sesuai loop
							char test2 = word.charAt(temp);
							if (test1 != test2) break;
							// jika huruf di "word" sudah dicek semua maka result+1
							else if (temp == word.length()-1) result = result+1;
						} else break;
					}
				}
			}
		}
		
		s.close();
		
		System.out.println("Result : " + result);
	}
	
	// input row, jumlah huruf harus sama dengan jumlah "column" yang diinput
	private static String inputRow(Scanner s, int i, int column) {
		System.out.print("Row " + (i+1) + "  : ");
		String rowStr = s.next();
		if (rowStr.length() == column) return rowStr;
		else {
			System.out.println("You must input " + column + " chars!");
			return inputRow(s, i, column);
		}
	}
}
