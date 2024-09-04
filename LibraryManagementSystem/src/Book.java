public class Book {
    private String title;
    private String author;
    private int ISBN;
    private int availableCopies;

    //constructor to initialize a new book
    public Book(String title, String author, int ISBN, int availableCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availableCopies = availableCopies;
    }

    //getter for Title
    public String getTitle() {
        return title;
    }

    //getter for Author
    public String getAuthor() {
        return author;
    }

    //getter for ISBN
    public int getISBN() {
        return ISBN;
    }

    //getter for available copies
    public int getAvailableCopies(){
        return availableCopies;
    }

    //Method to modify the available copies of book
    public void modifyCopies(int count) {
         this.availableCopies+=count;
    }
}
