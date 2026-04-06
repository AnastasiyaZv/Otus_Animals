package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlConnector  implements IDBConnector {


    private String jdbUrl = System.getenv("jdbc"); //"jdbc:postgresql://sql.otus.kartushin.su:5432/stage";
    private String username = System.getenv("username"); //"student";
    private String password = System.getenv("password"); //"student";

    private static Statement statement = null;
    private static Connection connection = null;

    //открываем коннект с БД
    public PostgresqlConnector() throws SQLException {
        if (connection != null){
            connection = DriverManager.getConnection(jdbUrl, username, password);
        }

        if (statement != null){
            statement = connection.createStatement();
        }
    }

    //закрываем коннект
    public void close() throws SQLException {
        if (statement != null){
            statement.close();
        }

        if (connection != null){
            connection.close();
        }
    }

}
