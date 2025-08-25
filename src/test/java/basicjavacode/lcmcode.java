package basicjavacode;

import java.util.Scanner;

public class lcmcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num= input.nextInt();
		int num2 = input.nextInt();
		int i=1;
		
		while(true) {
				int factor=num*i;
				if(factor%num2==0) {
					System.out.println(factor);
					break;
				}i++;
		}
		

	}

}
