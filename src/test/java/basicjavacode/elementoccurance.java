package basicjavacode;

import java.util.Scanner;

public class elementoccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new  int[size];
		int num = input.nextInt();
		int i =0;
		int count = 0;
		while(i<arr.length) {
			
			System.out.println("Enter the element " + (i+1) + ":");
			arr[i]= input.nextInt();
			i++;
		}
		i=0;
		while(i<arr.length) {
			if(arr[i]==num) {
				count++;
				
			}i++;
		}
		
System.out.println("number is found  "+ count );
	}

}
