package basicjavacode;

import java.util.Scanner;

public class arraytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = {10,20,43,556,54,45,32,55,56};
		boolean isFound = isFound(arr,num);
		if(isFound) {
			System.out.println("Number is found");
		}else {
			System.out.println("number not found");
		}
		
		

	}
public static boolean isFound(int[] arr, int num) {
	int index=0;
	while(index<arr.length) {
		if(arr[index]==num) {
			return true;
		}
		index++;
	}return false;
}
}
