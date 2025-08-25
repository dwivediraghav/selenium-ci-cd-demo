package basicjavacode;

public class array2dsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numarr = arrayutlity.input2Darray();
		long sum = sumarr(numarr);
		
		System.out.println(sum);
		
		

	}
	
public static long sumarr(int[][] numarr){
	int sum=0;
	int i = 0;
	while(i<numarr.length) {
		int j=0;
		while(j<numarr[i].length) {
			sum+=numarr[i][j];
			j++;
			
		}
		i++;
		
	}
	
	return sum;
}
}
