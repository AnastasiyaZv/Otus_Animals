package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlConnector extends AbsConnector {


    private static Statement statement = null;
    private static Connection connection = null;
    private final String jdbUrl = System.getenv("jdbc");
    private final String username = System.getenv("username");
    private final String password = System.getenv("password");

    //открываем коннект с БД
    public PostgresqlConnector() throws SQLException {
        if (connection != null) {
            connection = DriverManager.getConnection(jdbUrl, username, password);
        }

        if (statement != null) {
            statement = connection.createStatement();
        }
    }

    //закрываем коннект
    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

}
