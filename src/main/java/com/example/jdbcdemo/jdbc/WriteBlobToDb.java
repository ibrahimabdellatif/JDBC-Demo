package com.example.jdbcdemo.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WriteBlobToDb {

    /*
    the blob type in database have bigest size is 64kb
    TINYBLOB ≈ 255 bytes, BLOB ≈ 64KB, MEDIUMBLOB ≈ 16MB and LONGBLOB ≈ 4GB Run
    - Use Alter table command as per your Space requirements:

ALTER TABLE 'TABLE_NAME' MODIFY 'FIELD_NAME' MEDIUMBLOB;

>> Note: It is always recommended to save a Link but not the actual file (having large sizes) in DB.
    because the database storage is so expensive and valuable but if you want to store a file add the link or path of it
    and store this in database and the file in the Disk or Cloud.
     */

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/learn";
        String user = "ibrahim";
        String pass = "MyNewPassword@0";
        try {
//            1.SetUp the connection
            Connection connection = DriverManager.getConnection(url , user, pass);

//            2. SQL Command and prepared statement
            String sql = "update Students set Attachment=? where ID=2";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            3.
            File file = new File("/home/ibrahim/Documents/http-status-codes.pdf");
            FileInputStream input = new FileInputStream(file);

            preparedStatement.setBinaryStream(1 , input);

            System.out.println("Reading input file: " + file.getAbsolutePath());

            System.out.println("\nStoring the file in database: " + file);
            System.out.println(sql);

            preparedStatement.executeUpdate();
            System.out.println("The Update is Complete");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
