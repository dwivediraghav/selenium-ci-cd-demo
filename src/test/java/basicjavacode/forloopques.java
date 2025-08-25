package basicjavacode;

public class forloopques {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number[]= {10,20,30,40,20,30,10,20,20};
		int count=0;
		int serch_val=20;
		for(int i=0;i<=number.length-1;i++)
		{
			if(number[i]==serch_val) {
				count++;
				
			}
			
		}
		System.out.println(count);

	}

}
