package SQLTemplate;

import java.util.List;

public abstract class SQLT {
    /** An abstract SQL Template without SQL syntax checking. */
    public String table;
    public List<String> keys;
    public List<String> values;
    public List<String> conditions;

    public SQLT AddKeyValuePair(String key, String value) {
        this.keys.add(key);
        this.values.add(value);
        return this;
    }

    public SQLT AddCondition(Condition condition) {
        this.conditions.add(condition.toString());
        return this;
    }

    public SQLT AddCondition(String condition) {
        this.conditions.add(condition);
        return this;
    }

    public abstract String toSQL();
}
