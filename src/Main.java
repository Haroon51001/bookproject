import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		BSTUsingLinkedlist obj = new BSTUsingLinkedlist();
 		
		while(true) {
			System.out.print("\n1. insert a Book\n2. search a Book\n3. Delete a book\n4. Update book details\n5. Display all books\n6. Exit\n");
			choice=scanner.nextInt();
			
			switch(choice) {
			case 1:{
				obj.addBook();
				continue;
			}
			case 2:{
				obj.search();
				continue;
			}
			case 3:{
				obj.deleteBook();
				continue;
			}
			case 4:{
				obj.UpdateBook();
				continue;
			}
			case 5:{
				obj.displayAllBooks();
				continue;
			}
			case 6:{
				break;
			}
			
			}
			break;
		}
		System.out.println("Thanks.......");
	}
}



