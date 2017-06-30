package com.css.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * SQLite connecting to database.
 * This will shows how to connect to exisiting database.
 * If database does not exist, then it will be created and finally a
 * database object will be returned.
 *
 */
public class SQLiteJDBC {
    public static void main( String[] args ) {
        Statement stmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            //Connect of sqlite database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/tmp/test.db");
            System.out.println("Opened test.db database successfully");


            stmt = connection.createStatement();
            //Create table in
          String sql1 = "CREATE TABLE main.\"EMPLOYEE\" (\"EMP_ID\" INTEGER NOT NULL PRIMARY KEY ,"
                    +"\"FIRSTNAME\" TEXT,"
                    +"\"LASTNAME\" TEXT,"
                    +"\"STREET\" TEXT,"
                    +"\"CITY\" TEXT,"
                    +"\"STATE\" TEXT,"
                    +"\"ZIP\" TEXT,"
                    +"\"BIRTHDATE\" TEXT,"
                    +"\"PICURL\" TEXT,"
                    +"\"JOB_TITLE\" TEXT,"
                    +"\"DEPT_ID\" INTEGER,"
                    +"\"USERNAME\" TEXT,"
                    +"\"PASSWORD\" TEXT,"
                    +"\"ROLE\" TEXT,"
                    +"\"MANAGER_ID\" INTEGER,"
                    +"\"TENANT_ID\" INTEGER)";
            //System.out.println(sql1);
            //stmt.executeUpdate(sql1);

          String sql2 = "CREATE TABLE main.\"ACCOUNT\" (\"ID\" INTEGER NOT NULL,\n" +
                  "\"NAME\" TEXT NOT NULL,\n" +
                  "\"BALANCE\" INTEGER,\n" +
                  "PRIMARY KEY(\"ID\",\"NAME\"))";
            System.out.println(sql2);
            stmt.executeUpdate(sql2);

            String sql = new StringBuffer("CREATE TABLE main.\"USER\" (\"USER_ID\" INTEGER NOT NULL,"
            +"\"USERNAME\" TEXT,"
                    +"\"PASSWORD\" TEXT,"
                    +"\"ROLE\" TEXT,"
                    +"\"TENANT_ID\" INTEGER,"
                    +"PRIMARY KEY(\"USER_ID\"))").toString();
            //System.out.println(sql);
            //stmt.executeUpdate(sql);

            /*sql += "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL);";
            stmt.executeUpdate(sql);
            System.out.println("Created COMPANY table successfully");

            connection.setAutoCommit(false);
            sql += "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql += "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql += "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql += "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";

            stmt.executeUpdate(sql);
            System.out.println("Inserted data into COMPANY table successfully...!");

            rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                stmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }
}
