package SQLTemplate;

public class InsertT extends SQLT{
    public StringBuffer insertSQL;

    public InsertT(String table) {
        this.table = table;
        this.insertSQL = new StringBuffer("INSERT INTO ").append(table);
    }
    @Override
    public String toSQL() {
        this.insertSQL.append("( ");
        this.insertSQL.append(String.join(", ", this.keys));
        this.insertSQL.append(") VALUES(");
        this.insertSQL.append(String.join(", ", this.values));
        return this.insertSQL.append(");").toString();
    }
}
