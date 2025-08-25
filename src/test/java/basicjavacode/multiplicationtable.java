package basicjavacode;

import java.util.Scanner;

public class multiplicationtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your number  ");
		int num = input.nextInt();
		int i=1;
		while(i<=10) {
			System.out.println(num + "X" + i + " = " + (num*i));
			i++;
		}

	}

}
