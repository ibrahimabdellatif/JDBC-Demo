package com.example.jdbcdemo.jdbc;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GetMetaDataInfo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/learn";
        String user = "ibrahim";
        String pass = "MyNewPassword@0";

        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String columnNamePattern = null;
        String[] type = null;

        /*
        get all metadata for the database like DB driver name and versions, all Schemas, all Table, the Columns in specific table and a lot more
         */
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println("List of Tables in 'learn' Database schema");
            ResultSet tableResultSet = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, type);

//            while (tableResultSet.next()){
//                System.out.println(tableResultSet.getString("TABLE_NAME"));
//            }

            ResultSet schemas = databaseMetaData.getColumns(catalog, schemaPattern, "Students", columnNamePattern);
            while (schemas.next()) {
                System.out.println(schemas.getString("COLUMN_NAME"));
            }
            System.out.println(databaseMetaData.getDatabaseProductName());
            System.out.println(databaseMetaData.getDatabaseProductVersion());
            System.out.println(databaseMetaData.getDriverName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
