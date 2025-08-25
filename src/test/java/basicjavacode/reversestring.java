package basicjavacode;

import java.util.Scanner;

public class reversestring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        // Input the string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Reverse the string manually
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i); // Append each character to the reversed string
        }
        
        if (input.equalsIgnoreCase(reversed)) {  // Ignore case for case-insensitive check
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        // Output the reversed string
        System.out.println("Reversed string: " + reversed);

        scanner.close();

	}

}
