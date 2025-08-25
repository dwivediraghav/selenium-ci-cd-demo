package basicjavacode;

import java.util.Scanner;

public class arrayutlity {
	public static int[] inputarr() {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int [] arr = new int[size];
		int i = 0;
		while(i<arr.length) {
			System.out.println("enter the element " + (i+1) + ": ");
			arr[i] = input.nextInt();
			i++;
		}
		return arr;
	}
	
	public static int[][] input2Darray() {
		Scanner input = new Scanner(System.in);
		System.out.println("enter the row ");
		int row = input.nextInt();
		System.out.println("enter the column ");
		int column = input.nextInt();
		int[][] newArr = new int[row][column];
		int i = 0;
		while(i<row) {
			int  j = 0;
			while(j<column) {
			System.out.println("enter the row  " + (i+1) + ": "  + " , enter the column" + (j+1) + ": ");
			newArr[i][j] = input.nextInt();
			j++;
			}i++;
		}
		return newArr;
	}
	
	
public static void displayarr(int[] arry) {
	int i= 0;
	while(i<arry.length) {
		System.out.print(arry[i] + " ");
		i++;
	}
	System.out.println();
}


}
