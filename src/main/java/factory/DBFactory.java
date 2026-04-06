package factory;

import database.IDBConnector;
import database.PostgresqlConnector;

import java.sql.SQLException;

// переключение между БД: MySQL, PostgreSQL
public class DBFactory {
    private String dbType = System.getenv("db_type");

    public IDBConnector getDbConnector() throws SQLException {
        switch (dbType) {
            case "postgresql" -> {
                return new PostgresqlConnector();
            }
        }
        throw new RuntimeException("DB connection error");
    }

}
