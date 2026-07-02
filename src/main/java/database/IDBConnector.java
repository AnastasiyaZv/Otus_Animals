package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBConnector {

    void close() throws SQLException;

    int execute(String sqlRequest) throws SQLException;

    ResultSet executeWithData(String sqlRequest) throws SQLException;

}
