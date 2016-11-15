package v001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestJdbc {
	@Test
	public void testQuery() {

		Connection conn = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/book?useSSL=false&"
							+ "user=stas&password=qwn19c");

			Statement st = conn.createStatement();
			boolean execute = st.execute("select * from book");
			ResultSet rSet = st.getResultSet();

			while (rSet.next()) {
				System.out.println("Id= " + rSet.getInt("id") + ", name= "
						+ rSet.getString("name"));
			}

		} catch (SQLException ex) {
			assertNull(ex);
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Test
	public void testFactory() {
/*		 try {
			Class.forName(MyQueryFactory.class.getName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
*/		try (MyQueryFactory instance = new MyQueryFactory()) {
			instance.initConnection();
			
			ArrayList<Book> books = instance.returnBooksArrayList();
			for (Book book : books) {
				System.out.println(book);
			}

		} catch (Exception e) {
			assertNull(e);
			e.printStackTrace();
		}
	}
}
