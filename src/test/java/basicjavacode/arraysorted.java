package basicjavacode;

import java.util.Scanner;

public class arraysorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		int i = 0;
		while(i<arr.length) {
			System.out.println("enter the element "+(i+1)+": ");
			arr[i] = input.nextInt();
			i++;
		}
		

	}

}
