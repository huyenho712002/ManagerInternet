
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.helper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class databaseHelper {
private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String dburl = "jdbc:sqlserver://localhost:1433; databaseName = ManagerViking_Internet;encrypt=true;trustServerCertificate=true;";
    private static final String userName = "sa";
    private static final String password = "123456";

    public static void main(String[] args)  {
       
    try {
        Connection con=null;
        con=createConnection(driver, dburl, userName, password);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
               
    }
    public static Connection createConnection(String driver, String dburl, String userName,
            String password) throws SQLException {
        
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dburl, userName, password);
            System.out.println("Connect database thành công");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connect database thất bại");
        }
        return con;
    }
     
}
