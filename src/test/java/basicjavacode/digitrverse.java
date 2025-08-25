package basicjavacode;

import java.util.Scanner;

public class digitrverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int i =0;
		while(a>0) {
			int digit=a%10;
			i = i*10+digit;
			a/=10;
			
			
		}
		
System.out.println(i);
	}

}
