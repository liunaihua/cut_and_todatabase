package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GetConn {
    static ResourceBundle bundle = ResourceBundle.getBundle("pro");
    static String driver=bundle.getString("rdpe.driver");
    static String url=bundle.getString("rdpe.url");
    static String user=bundle.getString("rdpe.username");
    static String password=bundle.getString("rdpe.password");
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return conn;
    }
}
