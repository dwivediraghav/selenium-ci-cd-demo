package basicjavacode;

import java.util.Scanner;

public class arraybasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] nums= new int[size];
		
		int i=0;
		while(i<size) {
			System.out.println("please enter element " + (i+1) + " : ");
			nums[i] = input.nextInt();
			i++;
		}
		
		long total = sum(nums);
        int average = avg(nums);

        System.out.println("Sum of array elements: " + total);
        System.out.println("Average of array elements: " + average);


	}
	public static long sum(int[] nums) {
		long sum = 0;
		int i = 0;
		while(i<nums.length) {
			sum+=nums[i];
			i++;
		}
		return sum;
	}
public static int avg(int[] nums) {
	long sum=sum(nums);
	
	return (int) (sum/nums.length);
}
}
