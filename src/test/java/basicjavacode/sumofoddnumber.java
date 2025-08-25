package basicjavacode;

import java.util.Scanner;

public class sumofoddnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int i=1;
		int sum = 0;
		while(i<=num) {
			if(i%2!=0) {
				sum+=i;
			}i++;
			
		}
		System.out.println("Sum of odd numbers up to " + num + " is: " + sum);
	}

}
