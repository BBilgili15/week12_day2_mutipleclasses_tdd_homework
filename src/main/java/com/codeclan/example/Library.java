package com.codeclan.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private int capacity;
    private ArrayList<Book> books;


    public Library(int capacity, ArrayList<Book> books) {
        this.capacity = capacity;
        this.books = books;
    }

    public int totalBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (this.books.size() < 5) {
            this.books.add(book);
        }
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public int booksByGenre(String genre) {
        HashMap<String, Integer> genreCount = new HashMap<>();
        for (Book book: this.books) {
            if (!genreCount.containsKey(book.genre)) {
                genreCount.put(book.genre, 1);
            } else {
                genreCount.put(book.genre, genreCount.get(book.genre) + 1);
            }
        }
        return genreCount.get(genre);
    }
}
