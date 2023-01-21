package com.example.jdbcdemo.jdbc;

import java.sql.*;

public class GetDataFromDB {
    public static void main(String[] args) {


        try{

            /*
            (learn) is the name of database.
            (ibrahim) is username in mysql.
            (MyNewPassword@0) is the password of user.
            if you want to open in terminal use this command (mysql -u ibrahim -p) Enter then type the password.
             */
            //            get the connection to Database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn" , "ibrahim","MyNewPassword@0");
//            create a statement used to write the sql statement
            Statement statement = connection.createStatement();
//            Execute SQL Query then excute the query and save it in the Result set
            ResultSet resultSet = statement.executeQuery("select * from Company");
//            process the result set

            while (resultSet.next()){
                System.out.println(resultSet.getString("cname") + ", " + resultSet.getString("cnumber"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
