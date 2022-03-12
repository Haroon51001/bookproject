

	public class Book {
		int bid;
		String title;
		String edition;
		Book left;
		Book right;
		
		Book(int id, String title, String edition){
			this.bid=id;
			this.title=title;
			this.edition=edition;
		}
		
		public void display() {
			System.out.println("ID : "+bid+" |Title : "+ this.title+" |Edition : "+this.edition);
		}
	}


