package org.example;

public class Main {
    public static void main(String[] args) {
        // Create library and users
        Library library = new Library();
        User user1 = new User("Alice", "12345");
        User user2 = new User("Bob", "67890");

        // Create and add books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1976, 222, "Fiction");
        Book book2 = new Book("Hackers", "John CarMichael", 1999, 256, "Science");
        Book book3 = new Book("1984", "George Orwell", 1949, 328, "Fiction");
        Book book4 = new Book("How To Program", "Michael Wozniak", 1999, 900, "Science");
        Book book5 = new Book("Hatchet", "Jeremy Lenner", 2001, 385, "Fiction");
        Book book6 = new Book("Driving", "Ryan Gosling", 2001, 2009, "Fiction");
        Book book7 = new Book("How to Program for Real", "Michael Wozniak", 2002, 544, "Science");

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        // Loan out a book
        System.out.println("Loaning a book to Alice....");
        library.loanBook(user1, book1);
        // Try to loan out the same book twice
        System.out.println("Loaning a book to Bob....");
        library.loanBook(user2, book1);
        // Return books
        System.out.println("Alice is returning a book....");
        library.returnBook(user1, book1);
        System.out.println("Alice is trying to returning a book twice...?");
        library.returnBook(user1, book1);
        System.out.println("\n");

        // Print books
        System.out.println("Getting all books...");
        library.printSortedBookTitles();
        System.out.println("\n");

        System.out.println("Getting books of Category: Fiction....");
        System.out.println(library.findBooksByCategory("Fiction") + "\n");

        // Calculate late fees
        System.out.println("Late fees for Alice: $" + user1.calculateLateFees());

        // Remove book
        library.removeBook("Driving");

        // Find all books published within year 2001
        System.out.println(library.findBooksByYear(2001));

        // Find all books by author
        System.out.println(library.findBooksByAuthor("Michael Wozniak"));

        // Find the book with the most pages.
        System.out.println(library.findBookWithMostPages());

        // Find all books with more than 200 pages.
        System.out.println(library.findBooksWithMoreThanNPages(300));


        // Showoff User Getters/Setters
        user1.getName();
        user1.setName("Allison");
        user1.getLibraryCardNumber();
        user1.setLibraryCardNumber("2313123");
        user1.getLoanedBooks();

    }
}
