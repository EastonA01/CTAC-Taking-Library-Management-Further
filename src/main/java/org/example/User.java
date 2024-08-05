package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    // Variables
    private String name;
    private String libraryCardNumber;
    private List<Book> loanedBooks;

    // Constructor
    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.loanedBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void addBookToLoanedList(Book book) {
        loanedBooks.add(book);
    }

    public void removeBookFromLoanedList(Book book) {
        loanedBooks.remove(book);
    }

    // Calculate late fees
    public double calculateLateFees() {
        final double LATE_FEE_PER_DAY = 0.5;
        final int LOAN_PERIOD_DAYS = 14;
        return loanedBooks.stream()
                .filter(book -> book.getLoanDate() != null)
                .filter(book -> book.getLoanDate().plusDays(LOAN_PERIOD_DAYS).isBefore(LocalDate.now()))
                .mapToDouble(book -> LocalDate.now().until(book.getLoanDate().plusDays(LOAN_PERIOD_DAYS)).getDays() * LATE_FEE_PER_DAY)
                .sum();
    }
}

