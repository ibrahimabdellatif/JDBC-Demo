package com.example.jdbcdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        String user = "ibrahim";
        String pass = "MyNewPassword@0";
        String url = "jdbc:mysql://localhost:3306/learn";

        try {
//            set up the connection
            Connection connection = DriverManager.getConnection(url, user, pass);
//            create a statement
            Statement statement = connection.createStatement();
//            create an insert sql command
            String sqlInsertCommand = "insert into Students (ID ,First_Name  , Last_Name , Address , City , Birth_Date , Salary) " +
                    "values ('6','Ali' , 'Samer' , 'Home Street' , 'KaferElsheik', '1989-01-29', '9800')";
//            statement.executeUpdate(sqlInsertCommand);

            System.out.println("Insert is complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
