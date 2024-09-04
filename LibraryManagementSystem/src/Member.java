import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberid;
    private List<BorrowedBook> borrowedbooksList;

    //Inner class for the Borrowed Books
    private class BorrowedBook{
        private Book book;
        private String borrowedDate;
        private String duedate;

        //Constructor to initialize the borrowed book
        public BorrowedBook(Book book, String borrowedDate, String duedate) {
            this.book = book;
            this.borrowedDate = borrowedDate;
            this.duedate = duedate;
        }

        public Book getBook() {
            return book;
        }

        public String getBorrowedDate() {
            return borrowedDate;
        }

        public String getDuedate() {
            return duedate;
        }
    }

    //Constructor to initialize a new Member
    public Member(String name, String memberid) {
        this.name = name;
        this.memberid = memberid;
        this.borrowedbooksList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Method to display borrowed books
    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (BorrowedBook borrowedBook : borrowedbooksList) {
            System.out.println("Title: " + borrowedBook.getBook().getTitle() +
                    ", Borrow Date: " + borrowedBook.getBorrowedDate() +
                    ", Due Date: " + borrowedBook.getDuedate());
        }
    }

    //getter for member id
    public String getMemberid() {
        return memberid;
    }

    //Method to borrow the Book
    public void borrowBook(Book book, String borrowDate, String duedate){
        if(book.getAvailableCopies() > 0){
            BorrowedBook borrowedbook = new BorrowedBook(book, borrowDate, duedate);
            borrowedbooksList.add(borrowedbook);
            book.modifyCopies(-1);
        }else{
            System.out.println("Book or Member not available");
        }
    }

    //Method to return the book
    public void returnBook(Book book){
        BorrowedBook borrowedbookToReturn = null;

        //find the borrowedBook in the member's borrowed List
        for(BorrowedBook borrowedbook : borrowedbooksList){
            if(borrowedbook.getBook().equals(book)){
                borrowedbookToReturn = borrowedbook;
                break;
            }
        }

        if(borrowedbookToReturn != null){
            borrowedbooksList.remove(borrowedbookToReturn);
            book.modifyCopies(1);
        }else{
            System.out.println("This book is not borrowed by this member");
        }
    }
}
