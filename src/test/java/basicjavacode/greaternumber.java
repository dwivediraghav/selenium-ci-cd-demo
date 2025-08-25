package basicjavacode;

import java.util.Scanner;

public class greaternumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your number  ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		if(a>b && a>c) {
			System.out.println("a is gratest");
		}
		else if(b>c){
			System.out.println("b is greatest");
		}
		else {
			System.out.println("c is greatest");
		}
		

	}

}
