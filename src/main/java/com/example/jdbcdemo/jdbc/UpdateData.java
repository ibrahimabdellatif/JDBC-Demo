package com.example.jdbcdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {
        String user = "ibrahim";
        String pass = "MyNewPassword@0";
        String url = "jdbc:mysql://localhost:3306/learn";

        try {
//            set up the connection
            Connection connection = DriverManager.getConnection(url, user, pass);
//            create a statement to write the update SQL Query
            Statement statement = connection.createStatement();

            String sqlUpdateCommand = "update Students " +
                    "set City='Aswan' where ID=6";

            statement.executeUpdate(sqlUpdateCommand);

            System.out.println("Update is complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
