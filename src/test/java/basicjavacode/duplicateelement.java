package basicjavacode;


import java.util.HashSet;

public class duplicateelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,3,2};
		HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!set.add(num)) { // If adding fails, it's a duplicate
                duplicates.add(num);
            }
        }

        System.out.println("Duplicate elements: " + duplicates);
	}

}
