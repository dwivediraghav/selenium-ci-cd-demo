package basicjavacode;

import java.util.Scanner;

public class arraysortedmerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter to sorted array ");
		
		int[] newarr1=arrayutlity.inputarr();
		int[] newarr2 = arrayutlity.inputarr();
		int[] mergedarr = merge(newarr1,newarr2);
		System.out.println("here is your merged arr ");
		arrayutlity.displayarr(mergedarr);
		
		
		

	}
	public static int[] merge(int[] newarr1,int[] newarr2) {
		
		int newSize = newarr1.length + newarr2.length;
		int[] newarr = new int[newSize];
		int i = 0,j=0,k=0;
		while(i<newarr1.length || j<newarr2.length) {
			if(j==newarr2.length   || i<newarr1.length && newarr1[i] <newarr2[j] ) {
				newarr[k]=newarr1[i];
				i++;
				k++;
			}else{
				newarr[k]=newarr2[j];
				k++;
				j++;
			}
		}
		
		
		
		
		return newarr;
		
	}

}
