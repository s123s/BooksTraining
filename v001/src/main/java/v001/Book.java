package v001;

import java.sql.*;


/**
 * Created by yasha on 16.11.2016.
 */
public class Book {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/book";
    static final String USER = "root";
    static final String PASSWORD = "root";
    Connection connection = null;
    Statement statement = null;

    int idBook;
    String bookName;
    String isdn;
    int idAutor;
    String autor;
    String sql;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Book book = new Book();
        book.addBook("test","12345",2);
        book.deleteBook(4);
        book.selectBook();
        book.selectAutor();


    }

    public void selectBook() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        sql = "SELECT * FROM book.book";

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            idBook = resultSet.getInt("id");
            bookName = resultSet.getString("name");
            isdn = resultSet.getString("isdn");
            idAutor = resultSet.getInt("autor_id");

            System.out.println("id: " + idBook);
            System.out.println("Name: " + bookName);
            System.out.println("ISDN: " + isdn);
            System.out.println("Autor: " + idAutor);


        }
    }

    public void selectAutor() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql2 = "SELECT * FROM book.autor";
        ResultSet resultSet2 = statement.executeQuery(sql2);

        while (resultSet2.next()) {
            idAutor = resultSet2.getInt("id");
            autor = resultSet2.getString("name");
            System.out.print(idAutor + " " + autor);
        }
    }
    public void deleteBook(int idDel) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sqldel = "DELETE FROM book.book WHERE id=" + idDel;
        statement.executeUpdate(sqldel);
    }

    public void addBook(String bookN, String kod, int autId) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sqlAdd = "INSERT INTO `book`.`book` (`name`, `isdn`, `autor_id`) VALUES ('bookN', 'kod', '1')";
        statement.executeUpdate(sqlAdd);
    }

    public void updateBook(){}
    }


