package factory;

import database.IDBConnector;
import database.PostgresqlConnector;
import exceptions.DBConnectException;

import java.sql.SQLException;

// переключение между БД: MySQL, PostgreSQL
public class DBFactory {
    private final String dbType = System.getenv("db_type");

    public IDBConnector getDbConnector() throws SQLException {
        switch (dbType) {
            case "postgresql" -> {
                return new PostgresqlConnector();
            }
        }
        throw new DBConnectException(dbType);
    }

}
