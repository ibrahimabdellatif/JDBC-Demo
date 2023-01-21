package com.example.jdbcdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {
        String user = "ibrahim";
        String pass = "MyNewPassword@0";
        String url = "jdbc:mysql://localhost:3306/learn";

        try {
//            set up the connection
            Connection connection = DriverManager.getConnection(url , user , pass);
//            create a statement to write the update SQL Query
            Statement statement = connection.createStatement();

            String sqlDeleteCommand = "delete from Students where Last_Name='Ali'";

            statement.executeUpdate(sqlDeleteCommand);

            System.out.println("Delete is complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
