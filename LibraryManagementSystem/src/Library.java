import java.util.List;
import java.util.ArrayList;
public class Library {
    private List<Book> BooksList;
    private List<Member> MembersList;

    //Contructor to initialize Library
    public Library() {
        this.BooksList = new ArrayList<>();
        this.MembersList = new ArrayList<>();
    }

    //Methods to add Book to library
    public void addBook(Book newBook){
        BooksList.add(newBook);
    }

    public void registerMember(Member newMember){
        MembersList.add(newMember);
    }

    public void lendBook(String memberId, int ISBN, String borrowDate, String dueDate){
        Book bookToLend = null;
        Member memberToLend = null;

        //to check the availability for the book to lend
        for(Book book : BooksList){
            if(book.getISBN() == ISBN){
                bookToLend = book;
                break;
            }
        }

        //to the check if the member is registered
        for(Member member : MembersList){
            if(member.getMemberid() == memberId){
                memberToLend = member;
            }
        }

        //Lend the book if member and book is available
        if(bookToLend !=null && memberToLend != null){
            memberToLend.borrowBook(bookToLend, borrowDate, dueDate);
        }
    }

    public void returnBook(String memberId,int ISBN){
        Book bookToReturn =  null;
        Member memeberIsReturning = null;

        //to check the availability for the book to lend
        for(Book book : BooksList){
            if(book.getISBN() == ISBN){
                bookToReturn = book;
                break;
            }
        }

        //to the check if the member is registered
        for(Member member : MembersList){
            if(member.getMemberid() == memberId){
                memeberIsReturning = member;
            }
        }

        //Returning the book if book and member is available
        if (bookToReturn != null && memeberIsReturning != null){
            memeberIsReturning.returnBook(bookToReturn);
        }
    }

    public void displayMemberDetails(String memberid){
        for(Member member : MembersList){
            if(member.getMemberid().equals(memberid)){
                System.out.println("Member Name: " + member.getName());
                System.out.println("Borrowed Books:");
                member.displayBorrowedBooks();
                return;
            }
        }
    }

    public void displayAllBooks(){
        for(Book book: BooksList){
            System.out.println("Title: " + book.getTitle() +
            ", Author: " + book.getAuthor() +
                    ", ISBN: " + book.getISBN() +
                    ", Available Copies: " + book.getAvailableCopies());
        }
    }

    public void displayAvailableBooks(){
        for(Book book : BooksList){
            if(book.getAvailableCopies() > 0){
                System.out.println("Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", ISBN: " + book.getISBN() +
                        ", Available Copies: " + book.getAvailableCopies());
            }
        }
    }
}
