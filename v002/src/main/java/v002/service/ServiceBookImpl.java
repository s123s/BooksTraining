package v002.service;

import org.springframework.transaction.annotation.Transactional;
import v002.domain.Book;
import v002.repository.BookReposImpl;

import java.util.List;

/**
 * Created by yasha on 21.11.2016.
 */
public class ServiceBookImpl implements ServiceBook{

    private BookReposImpl bookReposImpl;

    public void setBookReposImpl(BookReposImpl bookReposImpl){
        this.bookReposImpl = bookReposImpl;
    }




    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookReposImpl.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookReposImpl.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(Long id) {
        this.bookReposImpl.removeBook(id);

    }

    @Override
    @Transactional
    public Book getBookById(long id) {
        return this.bookReposImpl.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookReposImpl.listBook();
    }
}
