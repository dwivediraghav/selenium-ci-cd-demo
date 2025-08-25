package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



public class streams {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Raghav");
//		names.add("Rahul");
//		names.add("Aman");
//		names.add("Raj");
//		names.add("Ramesh");
//		names.add("ANmol");
//		Long c = names.stream().filter(s->s.startsWith("R")).count();
//		System.out.println(c);
//		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		Stream.of("Raghav","Rahul","Aman","Rajl").filter(s->s.endsWith("l")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//sorting 
		Stream.of("Rzaghav","Rahul","Aman","Rajl").filter(s->s.startsWith("R")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//print unique number frim this array 
		List<Integer>values=Arrays.asList(3,2,2,4,5,6,5,9,1);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		
		
	     
	
		
		
		
		
		

	}
	
	

}
