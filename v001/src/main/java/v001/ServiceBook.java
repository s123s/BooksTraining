package v001;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by yasha on 16.11.2016.
 */
public class ServiceBook {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/book";
    static final String USER = "root";
    static final String PASSWORD = "root";
    Connection connection = null;
    Statement statement = null;
    PreparedStatement prepStat = null;
    String sql;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       ServiceBook book = new ServiceBook();
       /*
        book.addBook("prep","stat",1);
        book.updateBook(9, "testupd","999",1 );
        book.deleteBook(5);
        book.selectBook();
        book.selectAutor();
*/
        System.out.println("" + book.selectAutorId(book.selectAutor(3)));
    }

    public ArrayList<Book> selectBook() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        sql = "SELECT * FROM book.book";
        ArrayList<Book> bookList = new ArrayList<Book>();
        ResultSet resultSet = statement.executeQuery(sql);
       while (resultSet.next()) {
            int idBook = resultSet.getInt("id");
            String bookName = resultSet.getString("name");
            String isdn = resultSet.getString("isdn");
            int idAutor = resultSet.getInt("autor_id");
           Book book = new Book(idBook, bookName, isdn, idAutor);
           bookList.add(book);
        }

        resultSet.close();
        connection.close();
        statement.close();
        return bookList;
    }
    public ArrayList<String> listAutor() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        sql = "SELECT * FROM book.autor";
        ArrayList<String> list = new ArrayList<String>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            list.add(name);
        }

        resultSet.close();
        connection.close();
        statement.close();
        return list;
    }
    public String selectAutor(int idAutor) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql2 = "SELECT * FROM book.autor";
        String name = null;
        ResultSet resultSet2 = statement.executeQuery(sql2);
            while (name == null&&resultSet2.next()) {
            int id = resultSet2.getInt("id");
                if(id==(idAutor)){
            name = resultSet2.getString("name");}

        }



        resultSet2.close();
        statement.close();
        connection.close();
        return name;
    }
    public int selectAutorId(String name) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql2 = "SELECT * FROM book.autor";
        int id = -1;
        ResultSet resultSet2 = statement.executeQuery(sql2);
        while (id == -1 && resultSet2.next()) {
             String name1 = resultSet2.getString("name");
            if(name1.equals(name)){
                id = resultSet2.getInt("id");}

        }



        resultSet2.close();
        statement.close();
        connection.close();
        return id;
    }
    public void deleteBook(int idDel) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        prepStat = connection.prepareStatement("DELETE FROM book.book WHERE id= ?");
        prepStat.setInt(1, idDel);
        prepStat.executeUpdate();

        prepStat.close();
        connection.close();

    }
    public void deleteAutor(int idDel) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        prepStat = connection.prepareStatement("DELETE FROM book.autor WHERE id= ?");
        prepStat.setInt(1, idDel);
        prepStat.executeUpdate();

        prepStat.close();
        connection.close();

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
    public void addAutor(String autor) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        prepStat = connection.prepareStatement("INSERT INTO book.autor (`name`) VALUES (?)");
        prepStat.setString(1, autor);

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


