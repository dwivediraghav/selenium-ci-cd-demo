package basicjavacode;

import java.util.Scanner;

public class gcdsecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		while(b!=0) {
			int temp = b;
			b=a%b;
			a=temp;
		}
		
System.out.println(a);
	}

}
