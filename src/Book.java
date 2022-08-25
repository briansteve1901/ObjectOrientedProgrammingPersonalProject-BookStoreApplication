public class Book {
	private String IDFinal;
	private String bookTitle;
	private String bookType;
	private int chapterNumbers;
	private int price;
	
	public Book(String IDFinal, String bookTitle, String bookType, int chapterNumbers) {
		this.IDFinal = IDFinal;
		this.bookTitle = bookTitle;
		this.bookType = bookType;
		this.chapterNumbers = chapterNumbers;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public int getChapterNumbers() {
		return chapterNumbers;
	}

	public void setChapterNumbers(int chapterNumbers) {
		this.chapterNumbers = chapterNumbers;
	}

	public String getIDFinal() {
		return IDFinal;
	}

	public void setIDFinal(String IDFinal) {
		this.IDFinal = IDFinal;
	}

	public int getPrice() {
		if(getBookType().equals("Novel")) {
			this.price = 100000 + (getChapterNumbers() * 1000);
		}
		else {
			this.price = 50000 + (getChapterNumbers() * 1000);
		}
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
