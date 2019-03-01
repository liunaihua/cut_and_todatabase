package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseConn {
    public static void close(Connection conn, PreparedStatement ps){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn=null;
        }

        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps=null;
        }
    }
    public static void close(Connection conn, PreparedStatement ps1,PreparedStatement ps2, ResultSet rs){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn=null;
        }

        try {
            if(ps1!=null){
                ps1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps1=null;
        }

        try {
            if(ps2!=null){
                ps2.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps2=null;
        }

        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs=null;
        }
    }
}
