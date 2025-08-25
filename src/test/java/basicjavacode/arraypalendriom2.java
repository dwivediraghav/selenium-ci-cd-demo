package basicjavacode;

public class arraypalendriom2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("check the paindrome\n");
int[] newarr=arrayutlity.inputarr();
boolean isPaln = ispalindrome(newarr);
if(isPaln) {
	System.out.println("it is a palindrome ");
}
else {
	System.out.println("it is not ");
}
	}
public static boolean ispalindrome(int[] arr) {
	int i=0;
	while(i<arr.length/2) {
		if(arr[i]!=arr[arr.length-1-i]) {
			return false;
			
		}i++;
	}
	
	return true;
	
}
}
