package software.nju.edu.redis;

public class BookKey extends BasePrefix {

	public BookKey(String prefix) {
		super(prefix);
		// TODO Auto-generated constructor stub
	}
	
	public static BookKey getBookList = new BookKey("bl");
	public static BookKey getBookDetail = new BookKey("bd");

}
