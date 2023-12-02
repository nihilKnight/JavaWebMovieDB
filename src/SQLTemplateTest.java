import SQLTemplate.*;
import util.DBConnector;

import java.sql.*;
import static org.junit.Assert.*;

public class SQLTemplateTest {
    public final static String table = "test";
    public static void main(String[] args) {
        TestInsertT();
    }

    static class TestDao {
        public int attri_1;
        public int attri_2;
        public String attri_3;
        public double attri_4;
        public int attri_5;

        public TestDao() {}
        public TestDao(int attri_1, int attri_2, String attri_3, double attri_4, int attri_5) {
            this.attri_1 = attri_1;
            this.attri_2 = attri_2;
            this.attri_3 = attri_3;
            this.attri_4 = attri_4;
            this.attri_5 = attri_5;
        }

        public int getAttri1() {
            return attri_1;
        }

        public void setAttri1(int attri_1) {
            this.attri_1 = attri_1;
        }

        public int getAttri2() {
            return attri_2;
        }

        public void setAttri2(int attri_2) {
            this.attri_2 = attri_2;
        }

        public String getAttri3() {
            return attri_3;
        }

        public void setAttri3(String attri_3) {
            this.attri_3 = attri_3;
        }

        public double getAttri4() {
            return attri_4;
        }

        public void setAttri4(double attri_4) {
            this.attri_4 = attri_4;
        }

        public int getAttri5() {
            return attri_5;
        }

        public void setAttri5(int attri_5) {
            this.attri_5 = attri_5;
        }
    }

    public static void TestInsertT() {
        /** Test whether the insert SQL is correctly generated by Template.*/
        TestDao td = new TestDao(5, 2, "WORLD", 10.4, 10);
        String expected = """
                INSERT INTO\s
                test(attri_1, attri_2, attri_3, attri_4, attri_5)\s
                VALUES(5, 2, 'WORLD', 10.4, 10);""";
        String actual = new InsertT(table)
                .AddKeyValuePair("attri_1", Integer.toString(td.attri_1))
                .AddKeyValuePair("attri_2", Integer.toString(td.attri_2))
                .AddKeyValuePair("attri_3", "'" + td.attri_3 + "'")
                .AddKeyValuePair("attri_4", Double.toString(td.attri_4))
                .AddKeyValuePair("attri_5", Integer.toString(td.attri_5))
                .toSQL();
        assertEquals(expected, actual);

        /** Test whether the execution result is right.*/
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(actual);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnector.closeConnection(conn, pstmt, rs);
        }
        assertTrue( count > 0);
    }
}
