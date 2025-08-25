package basicjavacode;

import java.util.Scanner;

public class adarrayseach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	int[][] numArr = arrayutlity.input2Darray();
	System.out.println("Enter the number u wnat to search ");
	int num = input.nextInt();
	boolean isFound= search(numArr,num);
	if(isFound) {
		System.out.println("your number is found ");
	}else {
		System.out.println("not found ");
	}
	
	
	
	}
public static boolean search(int[][]numArr,int num) {
	int i = 0;
	while(i<numArr.length) {
		
		int j=0;
		while(j<numArr[i].length) {
			if(numArr[i][j]==num) {
				return true;
			}
			j++;
		}
		i++;
	}
	
	
	
	return false;
}
}
