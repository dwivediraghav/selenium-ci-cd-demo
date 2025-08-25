package basicjavacode;

import java.util.Scanner;

public class issortedarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		
		int i=0;
		while(i<arr.length) {
			System.out.println("enter the elemnt "+(i+1)+ ": ");
			arr[i] = input.nextInt();
			i++;
		}

	
	boolean isInc = isIncreasing(arr);
	boolean isDec = isDecreasing(arr);
	if(isInc) {
		System.out.println("sorted in increasing oreder");
	}
	else if(isDec){
		System.out.println("sorted in decreasing order");
		
	}
	else {
		System.out.println("not sorted ");
	}
	}
	public static boolean isIncreasing(int[] arr) {
		int i=1;
		while(i<arr.length) {
			if(arr[i]<=arr[i-1]) {
				return false;
			}i++;
		}
		return true;
	}
	public static boolean isDecreasing(int[] arr) {
		int i=1;
		while(i<arr.length) {
			if(arr[i]>=arr[i-1]) {
				return false;
			}i++;
		}
		
		return true;
	}

}
