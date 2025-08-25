package basicjavacode;

import java.util.Scanner;

public class reversearray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input= new Scanner(System.in);

int[] newarr = arrayutlity.inputarr();
reversearr(newarr);
System.out.println("your reversed array is  ");
arrayutlity.displayarr(newarr);
	}
	public static void reversearr(int [] arr) {
		int i = 0;
		while(i<arr.length/2) {
			int swap = arr[i];
			arr[i]=arr[(arr.length-1)-i];
			arr[(arr.length-1)-i]=swap;
			i++;
			
			
		}
		
	}

}
