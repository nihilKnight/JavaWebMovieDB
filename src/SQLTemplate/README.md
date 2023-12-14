# SQLTemplate

## Brief Description

This *SQLTemplate* is designed obeying the below principles:
- **"Data Separated from Program"**: When generating SQL statements from SQLTemplates, the programmer need not take account of the exact table name or column name sent to the database;
- **Write SQL statements in Java way**: Envelop the SQL functionality into Java Objects, leverage the Java syntax check to avoid easy SQL syntax errors.
- **Method Chaining**: Apply method chain design, make the template easier and more flexible to generate more generic SQL statements.

## Class Explanation

### Commonality

All the four classes `InsertT, DeleteT, UpdateT, SelectT` extend from the abstract class `SQLT`, which abstracts the fundamental structure and elements of the four kinds of SQL statements.

Every class extending the `SQLT` must implement the abstract method `toSQL`, which convert the whole Java `SQLT`-extended instance into `String`(the final SQL statement).

For more, please read the source code [here](SQLT.java).

### Difference

Following are the detailed explanation on the methods shared or no-shared in `InsertT, DeleteT, UpdateT, SelectT`:
- `AddKeyValuePair`: Add a new key/column and value pair to a/an *Insert*/*Update* statement.
- `AddCondition`: Add a new condition to a/an *Insert*/*Delete*/*Select* statement.
- `AddColumn`: Add a new selected column to a *Select* statement.
- `AddOrder`: Add a new order (asc or desc) to a *Select* statement.
- `AddGroup`: Add a new group rule to a *Select* statement.
- `Limit`: Limit the query result number of a *Select* statement.

### Example

```java
// Select all columns of a person given his id.
public Person SelectById(Integer id) {
        Person wanted = new Person();
        wanted.setId(id);

        return QueryAndResolve(
                new SelectT(TableName.person_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.Id()))
                        .toSQL()
            ).get(0);
        }
```
