package tables;

import database.IDBConnector;
import factory.DBFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbsTable {

    private DBFactory dbFactory = new DBFactory();
    private IDBConnector dbConnector;
    private String tableName;

    public AbsTable(String tableName){
        this.tableName = tableName;

        try {
            this.dbConnector = dbFactory.getDbConnector();
        } catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
    }

    public void createTable(String...columns) throws SQLException{
        String sqlRequest = String.format("CREATE TABLE %s IF NOT EXIST (%s)", tableName,
                String.join(",", columns));
        this.dbConnector.execute(sqlRequest);
    }

    public List<Map<String,String>> listDataFromTable(String predicates, String...columns) throws SQLException{

        String sqlColumns = "*";
        if (columns.length != 0){
            sqlColumns = String.join(",",columns);
        }

        String sqlRequest = String.format("SELECT %s FROM %s WHERE ", sqlColumns,tableName);
        if (!predicates.isEmpty()){
            sqlRequest += String.format("WHERE %s", predicates);
        }

        ResultSet resultSet = this.dbConnector.executeWithData(sqlRequest);
        List<Map<String,String>> result = new ArrayList<>();

        while (resultSet.next()){
            Map<String, String> stroka = new HashMap<>();
            for (String columnName: columns) {
                stroka.put(columnName, resultSet.getString(columnName));
            }
            result.add(stroka);
        }
        return result;
    }

}
