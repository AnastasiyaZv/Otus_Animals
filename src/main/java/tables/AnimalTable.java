package tables;

import java.sql.SQLException;

public class AnimalTable extends AbsTable {

    public AnimalTable() throws SQLException {
        super("animal");
        this.createTable(
                "name VARCHAR(50) NOT NULL",
                "type VARCHAR(10) NOT NULL",
                "color VARCHAR(10) NOT NULL",
                "age INTEGER NOT NULL",
                "weight INTEGER NOT NULL",
                "id INTEGER PRIMARY KEY");
    }
}
