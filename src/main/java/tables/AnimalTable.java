package tables;

import java.sql.SQLException;

public class AnimalTable extends AbsTable {

    public AnimalTable() throws SQLException {
        super("animalsZ");
        this.createTable("name VARCHAR(50) NOT NULL",
                "age VARCHAR(2) NOT NULL");
    }
}
