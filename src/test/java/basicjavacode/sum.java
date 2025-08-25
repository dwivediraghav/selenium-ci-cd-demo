package basicjavacode;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter first number : ");
		int firstNum = input.nextInt();
		System.out.print("Enter second number : ");
		int Secondnum= input.nextInt();
		int sum = firstNum + Secondnum;
		System.out.println("the output  "+ sum);
		

	}

}
