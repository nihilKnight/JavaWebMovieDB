# Entity

## Brief Description

*Entity* is one-to-one to the tables in database.

## Class Explanation

For each class, there is a kind of method return `SQLUtil.DataInfo`, like this:
```java
public SQLUtil.DataInfo MovieId() {
            return new SQLUtil.DataInfo("id", SQLUtil.DataType.BIGINT, this.movie_id);
        }
```
`SQLUtil.DataInfo` is designed to be convenient for SQLTemplates to generate SQL statements. 

The constructor of `SQLUtil.DataInfo` is like:
```java
public DataInfo(String attri_name, DataType attri_type, SomeType value)
```
The first parameter is the constant column/attribute name of an *Entity*; the second is the database(MySQL) type of this column/attribute; and the third is the actual value of this column/attribute in Java.
