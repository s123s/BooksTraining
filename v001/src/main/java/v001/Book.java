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
    PreparedStatement prepStat = null;

    int idBook;
    String bookName;
    String isdn;
    int idAutor;
    String autor;
    String sql;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       /* Book book = new Book();
        book.addBook("prep","stat",1);
        book.updateBook(9, "testupd","999",1 );
        book.deleteBook(5);
        book.selectBook();
        book.selectAutor();

*/
    }

    public ResultSet selectBook() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        sql = "SELECT * FROM book.book";

        ResultSet resultSet = statement.executeQuery(sql);
     /*   while (resultSet.next()) {
            idBook = resultSet.getInt("id");
            bookName = resultSet.getString("name");
            isdn = resultSet.getString("isdn");
            idAutor = resultSet.getInt("autor_id");

            System.out.println("id: " + idBook);
            System.out.println("Name: " + bookName);
            System.out.println("ISDN: " + isdn);
            System.out.println("Autor: " + idAutor);


        }
        */

        /*connection.close();
        statement.close();*/
        return resultSet;
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
        resultSet2.close();
        connection.close();
        statement.close();
    }
    public void deleteBook(int idDel) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        prepStat = connection.prepareStatement("DELETE FROM book.book WHERE id= ?");
        prepStat.setInt(1, idDel);
        prepStat.executeUpdate();

        connection.close();
        prepStat.close();
    }

    public void addBook(String bookN, String kod, int autId) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        prepStat = connection.prepareStatement("INSERT INTO book.book (`name`, `isdn`, `autor_id`) VALUES (?, ?, ?)");
        prepStat.setString(1, bookN);
        prepStat.setString(2, kod);
        prepStat.setInt(3, autId);
        prepStat.executeUpdate();

        connection.close();
        prepStat.close();
    }

    public void updateBook(int id, String bookN, String kod, int autId)throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        prepStat = connection.prepareStatement("UPDATE book.book SET name = ?, isdn = ?, autor_id = ? WHERE id = ?");
        prepStat.setString(1, bookN);
        prepStat.setString(2, kod);
        prepStat.setInt(3, autId);
        prepStat.setInt(4, id);
        prepStat.executeUpdate();

        connection.close();
        prepStat.close();
    }
    }


