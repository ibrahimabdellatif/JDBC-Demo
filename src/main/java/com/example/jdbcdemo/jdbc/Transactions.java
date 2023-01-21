package com.example.jdbcdemo.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Transactions {
    public static void main(String[] args) {
        String user = "ibrahim";
        String pass = "MyNewPassword@0";
        String url = "jdbc:mysql://localhost:3306/learn";

        /*
        what is Transactions in database?
        transaction is a group of tasks linked together to do a specific task like, delete the student that have a bad degree then update the salary of student
        - after finish these operations you have the option to commit all of this sequence task and commit it, or you can rollBack and don't save the changes that happened
        - in JDBC by default the auto commit for transaction to true so, before you start you need to make it false.
         */
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);

            String sqlDeleteCommand = "delete from Students where ID=1";
            String sqlUpdateSalary = "update Students set Salary=10000";

            Statement statement = connection.createStatement();

//            first transaction to delete the student that have id =1
            statement.executeUpdate(sqlDeleteCommand);

//            second transaction is update salary to all Students
            statement.executeUpdate(sqlUpdateSalary);

            System.out.println("all Transactions are ready");

//            ask the user if save it or not before he commit the result
            boolean ok;
            System.out.println("please enter yes for commit the changes\nand no for rollback or not save the changes");
            Scanner scanner = new Scanner(System.in);
            String ask = scanner.next();
            if (ask.equals("yes")) {
                ok = true;
            } else {
                ok = false;
            }

            if (ok) {
                connection.commit();
                System.out.println("the transaction is committed successfully");
            } else {
                connection.rollback();
                System.out.println("the transaction is rollback");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
