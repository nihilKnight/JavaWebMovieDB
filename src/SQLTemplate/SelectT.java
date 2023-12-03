package SQLTemplate;

import java.util.ArrayList;
import java.util.List;

public class SelectT extends SQLT{
    public StringBuffer selectSQL;
    public List<String> selects = new ArrayList<>();
    public List<String> tables = new ArrayList<>();

    public SelectT(String table) {
        this.table = table;
        this.selectSQL = new StringBuffer("SELECT ");
    }

    /** TODO: Write methods addressing the selects collisions (maybe create a new subclass). */

    @Override
    public String toSQL() {
        if (selects.isEmpty()) {
            this.selectSQL.append("*");
        } else {
            this.selectSQL.append(String.join(", ", this.selects));
        }
        this.selectSQL.append(" \nFROM ");
        if (tables.isEmpty()) {
            this.selectSQL.append(this.table);
        } else {
            this.selectSQL.append(String.join(", ", this.tables));
        }
        this.selectSQL.append(" \n");
        if (! conditions.isEmpty()) {
            this.selectSQL.append("WHERE ");
            for (int i = 0; i < conditions.size(); i ++) {
                this.selectSQL.append(conditions.get(i));
                if (i < conditions.size()-1) {
                    this.selectSQL.append(" AND ");
                }
            }
        }
        return this.selectSQL.append(';').toString();
    }

}
