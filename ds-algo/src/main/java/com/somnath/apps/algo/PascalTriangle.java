package com.somnath.apps.algo;

public class PascalTriangle {

	public static void printPascalTriangle(int n) {
		// An auxiliary array to store generated pascal triangle values
		int[][] arr = new int[n][n];
		int targetElem = -1;
		// Iterate through every line and print integer(s) in it
		for (int line = 0; line < n; line++)
		{
			// Every line has number of integers/columns equal to line number
			for (int i = 0; i <= line; i++)
			{
				// First and last values in every row are 1
				if (i == line || i == 0)
					arr[line][i] = 1;
				else // Other values are sum of values just above-left and above-right
					arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
				System.out.printf("%d ", arr[line][i]);
				if (line == 4 && i == 1)
					targetElem = arr[line][i];
			}
			System.out.printf("\n");
		}
		System.out.println("Target Element: " + targetElem);

	}

	public static void main (String[] args) {
		printPascalTriangle(5);
	}

}
