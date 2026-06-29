package database;

import java.sql.*;

public abstract class AbsConnector implements IDBConnector {
    private static Statement statement = null;
    private static Connection connection = null;

    private final String jdbcUrl = System.getProperty("jdbc");
    private final String username = System.getProperty("username");
    private final String password = System.getProperty("password");

    //открываем коннект с БД
    public AbsConnector() throws SQLException {
        if (connection != null) {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        }
        if (statement != null) {
            statement = connection.createStatement();
        }
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public void execute(String sqlRequest) throws SQLException {
        statement.execute(sqlRequest);
    }

    public ResultSet executeWithData(String sqlRequest) throws SQLException {
        return statement.executeQuery(sqlRequest);
    }
}
