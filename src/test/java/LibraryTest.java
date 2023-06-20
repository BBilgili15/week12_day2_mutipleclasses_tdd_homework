import com.codeclan.example.Book;
import com.codeclan.example.Borrower;
import com.codeclan.example.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private Borrower borrower;

    @Before
    public void before() {
        ArrayList<Book> booksForLibrary = new ArrayList<>();
        book1 = new Book("To Kill a Mockingbird", "Harper Lee", "Novel");
        booksForLibrary.add(book1);
        book2 = new Book("Animal Farm", "George Orwell", "Satire");
        booksForLibrary.add(book2);
        book3 = new Book("Lord of the Flies", "William Golding", "Novel");
        booksForLibrary.add(book3);
        book4 = new Book("Dracula", "Dram Stoker", "Horror Fiction");
        booksForLibrary.add(book4);
        book5 = new Book("Frankenstein", "Mary Shelley", "Horror Fiction");
        book6 = new Book("Don Quixote", "Miguel de Cervantes", "Satire");
        library = new Library(5, booksForLibrary);
        ArrayList<Book> booksForBorrower = new ArrayList<>();
        borrower = new Borrower(booksForBorrower);
    }

    @Test
    public void numOfBooksInLibrary() {
        assertEquals(4, library.totalBooks());
    }

    @Test
    public void canAddBook() {
        library.addBook(book5);
        assertEquals(5, library.totalBooks());
    }

    @Test
    public void canRejectBookIfFull() {
        library.addBook(book5);
        library.addBook(book6);
        assertEquals(5, library.totalBooks());
    }

    @Test
    public void borrowerCanBorrowBook() {
        borrower.addBookFromLibrary(book1, library);
        assertEquals(3, library.totalBooks());
        assertEquals(1, borrower.collectionCount());
    }

    @Test
    public void getBooksByGenre() {
        assertEquals(2, library.booksByGenre("Novel"));
    }
}
