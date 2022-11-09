    
package Connect;


import edu.poly.display.Main;
import edu.poly.model.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author ADMIN
 */
public class ConnectDatabase {
private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String dburl = "jdbc:sqlserver://localhost:1433; databaseName =MangerViking_Internet;encrypt=true;trustServerCertificate=true;";
    private static final String userName = "sa";
    private static final String password = "123456";

  
    Connection connection = null;
    public static Connection dbConnect() throws SQLException {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dburl, userName, password);
            System.out.println("Connect database successed");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connect database failured");
            ex.printStackTrace();
        }
        return con;
    }
    
}