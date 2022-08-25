import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner (System.in);
	Vector <Book> bookList = new Vector <Book> ();
	private void menu() {
		int choice;
		do {
			System.out.println("Books Store");
			System.out.println("1. View Books");
			System.out.println("2. Insert Book");
			System.out.println("3. Delete Book");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				viewBooks();
				break;
			case 2:
				insertBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				System.exit(0);
				break;
			}
		}while(choice<1||choice>4);
	}
	private void deleteBook() {
		if(bookList.size()==0) {
			System.out.println("There is no book yet.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			scan.nextLine();
		}
		else {
			System.out.println("========================================================================");
			System.out.printf("%-5s |%-6s |%-10s |%-10s |%-10s |%-10s\n","No","Id","Title","Type","Price","Total Chapter(s)");
			System.out.println("========================================================================");
			for(int i=0;i<bookList.size();i++) {
				Book book = bookList.get(i);
				System.out.printf("%-5d |%-6s |%-10s |%-10s |%-10d |%-10d\n", i+1,
						book.getIDFinal(),
						book.getBookTitle(),
						book.getBookType(),
						book.getPrice(),
						book.getChapterNumbers()
						);
			}
			System.out.println();
			int deleteChoice;
			do {
				System.out.print("Choose index to be delete [1.." + bookList.size() +"]: ");
				deleteChoice = scan.nextInt();
			}while(deleteChoice<1||deleteChoice>bookList.size());
			bookList.remove(deleteChoice-1);
			System.out.println("Delete success!!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			scan.nextLine();
		}
		menu();
	}
	private void insertBook() {
		String bookTitle;
		do {
			System.out.print("Input title [5-10 Characters]: ");
			bookTitle = scan.next();
			scan.nextLine();
		}while(bookTitle.length()<5||bookTitle.length()>10);
		
		String bookType;
		do {
			System.out.print("Input type [Novel|Comic] (Case Sensitive): ");
			bookType = scan.next();
		}while(bookType.compareTo("Novel")!=0&&bookType.compareTo("Comic")!=0);
		
		int numberChapters;
		do {
			System.out.print("Input number of chapter(s) [1-10]: ");
			numberChapters = scan.nextInt();
		}while(numberChapters<1||numberChapters>10);
		
		String ID = "BJ";
		int temp1, temp2, temp3;
		temp1 = (int) Math.round(Math.random()*9);
		temp2 = (int) Math.round(Math.random()*9);
		temp3 = (int) Math.round(Math.random()*9);
		String temps1, temps2, temps3;
		temps1 = Integer.toString(temp1);
		temps2 = Integer.toString(temp2);
		temps3 = Integer.toString(temp3);
		String IDFinal = ID+temps1+temps2+temps3;
		
		Book book = new Book (IDFinal, bookTitle, bookType, numberChapters);
		bookList.add(book);
		
		System.out.println("Book created!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		scan.nextLine();
		menu();
	}
	private void viewBooks() {
		if(bookList.size()==0) {
			System.out.println("There is no book yet.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			scan.nextLine();
		}
		else {
			System.out.println("========================================================================");
			System.out.printf("%-5s |%-6s |%-10s |%-10s |%-10s |%-10s\n","No","Id","Title","Type","Price","Total Chapter(s)");
			System.out.println("========================================================================");
			for(int i=0;i<bookList.size();i++) {
				Book book = bookList.get(i);
				System.out.printf("%-5d |%-6s |%-10s |%-10s |%-10d |%-10d\n", i+1,
						book.getIDFinal(),
						book.getBookTitle(),
						book.getBookType(),
						book.getPrice(),
						book.getChapterNumbers()
						);
			}
			System.out.println("=======================================================================================");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			scan.nextLine();
		}
		menu();
	}
	public Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();
	}

}
