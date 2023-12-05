package SQLTemplate;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

public class SelectT extends SQLT{
    public enum OrderType {
        ASC, DESC
    }
    public StringBuffer selectSQL;
    public List<String> columns = new ArrayList<>();
    public List<String> tables = new ArrayList<>();
    public List<String> orders = new ArrayList<>();
    public Integer limit = null;

    public SelectT(String table) {
        this.table = table;
        this.selectSQL = new StringBuffer("SELECT ");
    }

    /** TODO: Write methods addressing the columns collisions (maybe create a new subclass). */
    /** TODO: Write methods enable MySQL expressions (like arithmetics and functions), and alias ("AS"). */
    /** TODO: Write methods enable grouping functions (MAX, MIN, AVG). */

    public SelectT AddOrder(String attri) {
        this.orders.add(attri);
        return this;
    }
    public SelectT AddOrder(String attri, OrderType ot) {
        this.orders.add(attri + ' ' + switch (ot) {
            case ASC -> "ASC";
            case DESC -> "DESC";
        });
        return this;
    }
    public SelectT Limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public String toSQL() {
        if (this.columns.isEmpty()) {
            this.selectSQL.append("*");
        } else {
            this.selectSQL.append(String.join(", ", this.columns));
        }
        this.selectSQL.append(" \nFROM ");
        if (this.tables.isEmpty()) {
            this.selectSQL.append(this.table);
        } else {
            this.selectSQL.append(String.join(", ", this.tables));
        }
        if (! this.conditions.isEmpty()) {
            this.selectSQL.append(" \nWHERE ").append(String.join(" AND ", this.conditions));
        }
        if (! this.orders.isEmpty()) {
            this.selectSQL.append(" \nORDER BY ").append(String.join(", ", this.orders));
        }
        if (this.limit != null) {
            this.selectSQL.append(" \nLIMIT ").append(Integer.toString(this.limit));
        }
        return this.selectSQL.append(';').toString();
    }

}
