package basicjavacode;

import java.util.Scanner;

public class fibnociseries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		if(a<0) return;
		System.out.print("0 ");
		if(a==0) return;
		System.out.print("1 ");
		int first=0, second=1;
		while(first+second<=a) {
			int third = first+second;
			System.out.print(third + " ");
			first=second;
			second=third;
		}
		

	}

}
