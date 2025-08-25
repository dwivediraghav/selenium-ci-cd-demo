package basicjavacode;

import java.util.HashMap;
import java.util.Scanner;

public class duplicatehashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        // Taking array size as input
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Taking array elements as input
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Using HashMap to find duplicates
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Printing duplicate elements
        System.out.print("Duplicate elements: ");
        boolean hasDuplicates = false;
        for (int key : map.keySet()) {
            if (map.get(key) > 1) { // If count > 1, it's a duplicate
                System.out.print(key + " ");
                hasDuplicates = true;
            }
        }

        if (!hasDuplicates) {
            System.out.print("None");
        }

        // Closing scanner
        scanner.close();

	}

}
