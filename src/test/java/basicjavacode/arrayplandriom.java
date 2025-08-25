package basicjavacode;

import java.util.Arrays;
import java.util.Scanner;

public class arrayplandriom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int[] newarr= arrayutlity.inputarr();
int[] reversedcopy = Arrays.copyOf(newarr, newarr.length);
reversearray.reversearr(reversedcopy);
System.out.println("Original Array:");
arrayutlity.displayarr(newarr);

System.out.println("Reversed Array:");
arrayutlity.displayarr(reversedcopy);
if (arrcheck(newarr, reversedcopy)) {
	System.out.println("It is a palindrome.");
} else {
	System.out.println("It is NOT a palindrome.");
}


	}
	public static boolean arrcheck(int[] arr,int[] reversedcopy) {
		if (arr.length != reversedcopy.length) return false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != reversedcopy[i]) {
				return false;
			}
		}
		
		return true;
		
		
	}

}
