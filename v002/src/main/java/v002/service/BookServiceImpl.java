package v002.service;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import v002.DAO.BookDAO;
import v002.model.Autor;
import v002.model.Book;

@Service
public class BookServiceImpl implements Closeable {

	private BookDAO bookDao; 
	
	private static Connection conn = null;

	public void initConnection() throws SQLException, ClassNotFoundException {

		
		
		
		
		// Let's load library from "/web-inf/lib" direcory
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		conn = DriverManager
				.getConnection("jdbc:mysql://localhost/book?useSSL=false&useUnicode=true&characterEncoding=UTF-8&"
						+ "user=stas&password=qwn19c");

	}

	public void close() throws IOException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new IOException("MyQueryFactory exception", e);
		}
	}

	public List<Book> getBooks() {
		return bookDao.readAll();
	}

	public ArrayList<Autor> getAutors() throws SQLException {

		ArrayList<Autor> autors = new ArrayList<Autor>();

		try (PreparedStatement st = conn
				.prepareStatement("select * from autor");
				ResultSet rSet = st.executeQuery();) {

			while (rSet.next()) {
				Autor a = new Autor(rSet.getInt("id"), rSet.getString("name"));
				autors.add(a);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return autors;
	}

	public boolean markBookDeleted(Integer idBook) throws SQLException {
		try (Statement st = conn.createStatement()) {
			return st .execute("update book set  deleted=1 where id = " + idBook);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	public Book getBook(Integer id) throws Exception {

		Statement st = conn.createStatement();
		st.execute("select * from book where id = " + id);
		ResultSet rSet = st.getResultSet();

		while (rSet.next()) {
			Book b = new Book(rSet.getInt("id"), rSet.getString("name"),
					rSet.getString("isdn"), rSet.getInt("autor_id"));
			return b;
		}
		throw new Exception("Нет такой книги (book)" + id);
	}

	public int saveEditedBook(Book book) throws SQLException {

		System.out.println("updating book " + book);
		PreparedStatement prepareStatement = conn
				.prepareStatement("update book set  name=?, isdn=?, autor_id=? where id = ?");
		prepareStatement.setString(1, book.name);
		prepareStatement.setString(2, book.isdn);
		prepareStatement.setInt(3, book.getAutorId());
		prepareStatement.setInt(4, book.id);

		return prepareStatement.executeUpdate();
	}

	public int saveNewBook(Book book) throws SQLException {

		System.out.println("insert book " + book);
		PreparedStatement prepareStatement = conn
				.prepareStatement("insert into book (name, isdn, autor_id) values (?, ?, ?)");
		prepareStatement.setString(1, book.name);
		prepareStatement.setString(2, book.isdn);
		prepareStatement.setInt(3, book.getAutorId());

		return prepareStatement.executeUpdate();
	}

	

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}
}