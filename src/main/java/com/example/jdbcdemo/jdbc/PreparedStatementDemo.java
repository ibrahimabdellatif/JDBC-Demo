package com.example.jdbcdemo.jdbc;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        String user = "ibrahim";
        String pass = "MyNewPassword@0";
        String url = "jdbc:mysql://localhost:3306/learn";

        /*
        Prepared statement means you can modify and add variable to you sql query instead of write a hardcode by adding
        this symbol (?) , then in other place in code you will write setString or setDouble according to the type of (?)
        this make sql query more flexible
         */
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            String sqlPreparedStatement = "select * from Students where Salary<?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlPreparedStatement);

            preparedStatement.setDouble(1, 1100);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Prepared statement is complete");

            while (resultSet.next()) {
                System.out.println("Firstname: " + resultSet.getString("First_Name") +
                        ", " + "Lastname: " + resultSet.getString("Last_Name") +
                        "\n" + "The Salary: " + resultSet.getString("Salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
