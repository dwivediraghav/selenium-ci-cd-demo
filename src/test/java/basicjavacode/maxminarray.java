package basicjavacode;

import java.util.Scanner;

public class maxminarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		int i=0;
		
		while(i<arr.length) {
			System.out.println("enter the elemrnt " + (i+1) + ";");
			arr[i]=input.nextInt();
			i++;
		}
		int max = arr[0];
		int min = arr[0];
		
		i=1;
		while(i<arr.length) {
			if(arr[i]>max) {
				max=arr[i];
				
			}
			if(arr[i]<min) {
				min=arr[i];
			}
			i++;
		}
		System.out.println("Maximum value in array: " + max);
		System.out.println("Minimum value in array: " + min);
	}

}
