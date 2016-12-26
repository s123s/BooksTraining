package v003.service;

import java.util.List;

import org.springframework.stereotype.Service;

import v003.dao.BookDao;
import v003.model.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Override
	public List<Book> readAll() {
		return bookDao.readAll();
	}

	public Book read(Integer o) {
		return bookDao.read(o);
	}


	public void update(Book o) {
		bookDao.update(o);
	}

	public int markDeleted(Integer k) {
		return bookDao.markDeleted(k);
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
