package v001;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyQueryFactory implements Closeable{
	
	private static Connection conn = null;
	
	public void initConnection () throws SQLException, ClassNotFoundException {
		
		//Let's load library from "/web-inf/lib" direcory
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/book?useSSL=false&"
				+ "user=stas&password=qwn19c");

	}

	public void close() throws IOException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new IOException("MyQueryFactory exception", e); 
		}
	}

	
	
	public ArrayList<Book> returnBooksArrayList() throws SQLException   {
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		Statement st = conn.createStatement();
		st.execute("select * from book");
		ResultSet rSet = st.getResultSet();

		while (rSet.next()) {
			Book b = new Book(rSet.getInt("id"), rSet.getString("name"), rSet.getString("isdn"), rSet.getInt("autor_id"));
			books.add(b);
		}
		return books;
	}
	
	
}
