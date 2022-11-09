/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.DAO;

import edu.poly.helper.databaseHelper;
import edu.poly.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */

public class MemberDAO {
     private static final  String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final  String dburl = "jdbc:sqlserver://localhost:1433; databaseName =ManagerViking_Internet;encrypt=true;trustServerCertificate=true;";
    private static final  String userName = "sa";
    private static final  String password = "123456";
    public Member checkLogin(String Name_Member, String PassWord) throws Exception{

        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection con = null;
         
            try{ 
                con = databaseHelper.createConnection(driver, dburl, userName, password);
                String sql;
                sql = "select * from Member where Name_Member=? and PassWord =?";
                ptmt = con.prepareStatement(sql);
                ptmt.setString(1, Name_Member);
                ptmt.setString(2, PassWord);
                
                resultSet = ptmt.executeQuery();
                while (resultSet.next()) {
                    Member member = new Member();
                    member.setName_Member(Name_Member);

                
                    return member;
                }
                 resultSet.close();
                 con.close();
            } catch (SQLException ex){ 
        }
     

        return null;
    }
}
    

