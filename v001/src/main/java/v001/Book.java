package v001;

import java.sql.*;


/**
 * Created by yasha on 16.11.2016.
 */
public class Book {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/book*";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM book.book";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String isdn = resultSet.getString("isdn");
            int autor_id = resultSet.getInt("autor_id");

            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + isdn);
            System.out.println("Autor: " + autor_id);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
