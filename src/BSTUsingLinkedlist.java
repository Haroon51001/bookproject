
import java.util.Scanner;
public class BSTUsingLinkedlist {
	Book root = null;
	
	public void addBook(){
        Scanner sc = new Scanner(System.in);
        Book book;
        System.out.println("Enter Book Details to Add Book");
        System.out.print("ID : ");
        int id = sc.nextInt();
        System.out.print("Title : ");
        sc.nextLine();
        String title = sc.nextLine();
        System.out.print("Edition : ");
        String edition = sc.nextLine();

        book = new Book(id,title,edition);

        System.out.println("New Book has been successfully added");
        
        if(root==null){
            root=book;
        }
        else{
            insertHelper(root, book);
        }
    }
    private void insertHelper(Book r, Book book){
        if(book.bid<r.bid){
            if(r.left==null){
                r.left=book;
            }else{
                insertHelper(r.left, book);
            }
        }
        else if(book.bid>r.bid){
            if(r.right==null){
                r.right=book;
            }else{
                insertHelper(r.right, book);
            }
        }
        else{
            System.out.println("\t\t\t\t\tthis book already exists!");
        }
    }
    
    
    public void search() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("enter id : ");
    	int id = sc.nextInt();
    	Book searchBook=searchHelper(root, id);
    	searchBook.display();
    }
    
    private Book searchHelper(Book r, int id){
        if(r==null){
            return null;
        }
        else if(r.bid==id){
            return r;
        }
        else if(r.bid>id){
            return searchHelper(r.left,id);
        }else{
            return searchHelper(r.right,id);
        }
    }
    
    
    
    
    public void displayAllBooks(){
        inOrderTraversalHelper(root);
    }
    private void inOrderTraversalHelper(Book root){
        if(root!=null){
            inOrderTraversalHelper(root.left);
            root.display();
            inOrderTraversalHelper(root.right);
        }
    }
    
    
    public void deleteBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Book ID : ");
        int id = sc.nextInt();

        Book current = root;
        Book parent = null;

        while(current!=null) {
            if (id == current.bid)
                break;
            else if (id > current.bid) {
                parent = current;
                current = current.right;
            } else {
                parent = current;
                current = current.left;
            }
        }
        if(current==null){
            System.out.println("There is no book with ID : "+id);
            return;
        }
        else{
            if(current.left==null && current.right==null){
                if(parent==null){
                    root=null;
                }else if(parent.right==current){
                    parent.right=null;
                }else{
                    parent.left=null;
                }
            }
            else if(current.left==null){
                if(parent==null){
                    root=current.right;
                }else if(parent.right==current){
                    parent.right=current.right;
                }else{
                    parent.left=current.right;
                }
            }
            else if(current.right==null){
                if(parent==null){
                    root=current.left;
                }else if(parent.right==current){
                    parent.right=current.left;
                }else{
                    parent.left=current.left;
                }
            }
            else {
                Book temp_current = current.right;
                Book temp_parent = null;
                while(temp_current.left!=null){
                    temp_parent=temp_current;
                    temp_current=temp_current.left;
                }
                if(temp_parent==null){
                    current.right=temp_current.right;
                }else{
                    temp_parent.left=temp_current.right;
                }
                current.bid = temp_current.bid;
                current.title = temp_current.title;
                current.edition = temp_current.edition;
                
            }
        }
        System.out.println("Book has been successfully removed..\n");
        
    }
    
    
    public void UpdateBook(){

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        char check;
        System.out.print("Book ID : ");
        int id = sc.nextInt();
        Book searchAcc = searchHelper(root, id);
        if(searchAcc!=null) {
            System.out.print("Do you want to Change Title? : (Y/N) ");
            check=sc.next().charAt(0);
            if(check=='y'||check=='Y')
            {
                System.out.print("Enter title : ");
                searchAcc.title=sc1.nextLine();
                System.out.println("Title has been successfully changed : "+searchAcc.title);
            }
            System.out.print("Do you want to Change Edition? : (Y/N) ");
            check=sc.next().charAt(0);
            if(check=='y'||check=='Y')
            {
                System.out.print("Enter edition : ");
                searchAcc.edition=sc1.nextLine();
                System.out.println("Edition has been successfully changed : "+searchAcc.edition);
            }
            System.out.println("Book "+searchAcc.bid+" details has been successfully updated..\n");
            searchAcc.display();
            System.out.println();
        }
    }
    
}



