package com.example.jdbcdemo.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class ReadBlobFromDb {

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
            String sql = "select Attachment from Students where ID=2";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            File file = new File("http-status-codes-after.pdf");
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            if (resultSet.next()){
                InputStream inputStream = resultSet.getBinaryStream("Attachment");
                byte[] buffer = new byte[1024];
                while (inputStream.read(buffer) > 0){
                    fileOutputStream.write(buffer);
                }
                System.out.println("Complete");
            }




        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
