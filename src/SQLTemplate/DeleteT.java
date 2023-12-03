package SQLTemplate;

import java.util.List;

public class DeleteT extends SQLT{
    public StringBuffer deleteSQL;
    public DeleteT(String table) {
        this.table = table;
        this.deleteSQL = new StringBuffer("DELETE FROM \n").append(table).append(" \n");
    }

    @Override
    public String toSQL() {
        if (! conditions.isEmpty()) {
            this.deleteSQL.append("WHERE ");
            for (int i = 0; i < conditions.size(); i ++) {
                this.deleteSQL.append(conditions.get(i));
                if (i < conditions.size()-1) {
                    this.deleteSQL.append(" AND ");
                }
            }
        }
        return this.deleteSQL.append(';').toString();
    }
}
