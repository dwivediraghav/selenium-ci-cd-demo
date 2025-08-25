package basicjavacode;

import java.util.Scanner;

public class gcdtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num=input.nextInt();
		int num1 = input.nextInt();
		int smallest = Math.min(num, num1);
		int gcd = 1;
		int i =2;
		while(i<=smallest) {
			if(num%i==0 && num1%i==0) {
				gcd=i;
				
				
			}i++;
			
		}
		
System.out.println(gcd);
	}

}
