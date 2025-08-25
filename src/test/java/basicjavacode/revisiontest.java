package basicjavacode;

import java.util.Scanner;

public class revisiontest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a number ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int i =1;
		int sum=1;
		while(i<=num){
			sum*=i;
			i++;
			
		}
		
		System.out.println(sum);
		

	}

}
