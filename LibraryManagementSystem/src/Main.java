public class Main {
    public static void main(String[] args) {
       Library library = new Library();

        // Add some books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456, 5));
        library.addBook(new Book("1984", "George Orwell", 789012, 3));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 345678, 4));


        library.displayAllBooks();

        // Register some members
        Member member1 = new Member("Alice", "M001");
        Member member2 = new Member("Bob", "M002");
        library.registerMember(member1);
        library.registerMember(member2);

        // Lend a book to a member
        library.lendBook("M001", 123456, "2024-08-09", "2024-08-16");

        // Display all available books
        library.displayAvailableBooks();

        // Display member details after returning the book
        library.displayMemberDetails("M001");

        // Return a book
        library.returnBook("M001", 123456);

        // Display all available books
        library.displayAvailableBooks();


    }
}