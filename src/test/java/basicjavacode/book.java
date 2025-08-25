package basicjavacode;

public class book {
	static int totalnoofbooks;
	String author;
	String title;
	String isbn;
	
	boolean isborrowed;
	static {
		totalnoofbooks=0;
		
	}
book(String author,String title,String isbn){
	this.isbn=isbn;
	this.title=title;
	this.author=author;
	
}

book(String isbn){
	this("Unknown","Unknown",isbn);
}
}
