package v002.repository;

import v002.domain.Book;

import java.util.List;

/**
 * Created by yasha on 23.11.2016.
 */
public interface BookRepository {
    public void addBook(Book autor);
    public void updateBook(Book autor);
    public void removeBook(Long id);
    public Book getBookById(Long id);
    public List<Book> listBook();
}
