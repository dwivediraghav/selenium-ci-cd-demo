package basicjavacode;

import java.util.Scanner;

public class sumofdigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int sum=0;
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		
		
System.out.println(sum);
	}

}
