package basicjavacode;

import java.util.Arrays;

public class minandmax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,5,8,6,10,0};
		//Arrays.sort(arr);
		//System.out.println("min value "  +   arr[0]    +   " , max value "+arr[arr.length-1]);
		
		int max=arr[0];
		int min = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		System.out.println("max  "+max+" min is  "+min);
		
	}

}
