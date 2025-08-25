package basicjavacode;

import java.util.Scanner;

public class primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();	
		int i =2;
		boolean isPrime=true;
		if(num<2) {
			isPrime=false;
			
		}
		else {
		while(i<num) {
			if(num%i==0) {
				isPrime=false;
				break;
			}
			i++;
		}}
		if (isPrime) {
            System.out.println(num + " is a Prime Number");
        } else {
            System.out.println(num + " is NOT a Prime Number");
        }
	}

}
