package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
    // Books and loaned Books are separated
    private List<Book> books;
    private Set<Book> loanedBooks;
    // Predicate to check if a book is on loan
    private final Predicate<Book> isBookOnLoan = book -> book.isOnLoan();

    public Library() {
        books = new ArrayList<>();
        loanedBooks = new HashSet<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the library by title
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    // Find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Find the book with the most pages
    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    // Find all books with more than n pages
    public List<Book> findBooksWithMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    // Print all book titles in the library, sorted alphabetically
    public void printSortedBookTitles() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }

    // Find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Loan out a book
    public void loanBook(User user, Book book) {
        // Check if the book is not on loan using the predicate
        if (!isBookOnLoan.test(book)) {
            // Set status
            book.setOnLoan(true);
            // Set loan date
            book.setLoanDate(LocalDate.now());
            // Add to loaned set
            loanedBooks.add(book);
            // Add to the user's list of books loaned
            user.addBookToLoanedList(book);
        } else {
            System.out.println("Book is already on loan.");
        }
    }

    // Return a book
    public void returnBook(User user, Book book) {
        // Same idea as loanBook
        if (isBookOnLoan.test(book)) {
            book.setOnLoan(false);
            book.setLoanDate(null);
            loanedBooks.remove(book);
            user.removeBookFromLoanedList(book);
        } else {
            System.out.println("Book was not on loan.");
        }
    }
}

