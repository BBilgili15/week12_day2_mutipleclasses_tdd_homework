package com.codeclan.example;

import java.util.ArrayList;

public class Borrower {
    private ArrayList collection;

    public Borrower(ArrayList<Book> collection) {
        this.collection = collection;
    }

    public void addBookFromLibrary(Book book, Library library) {
        library.removeBook(book);
        this.collection.add(book);
    }

    public int collectionCount() {
        return this.collection.size();
    }
}
