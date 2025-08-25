package basicjavacode;

import java.util.Scanner;

public class basicinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("what is your name ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("Welcome " + name + " to the world");
	}

}
