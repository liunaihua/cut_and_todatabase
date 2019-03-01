import utils.CloseConn;
import utils.GetConn;
import utils.GetYserterday;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class JDBC {

    public static void insert(int total_container){
        Connection conn = GetConn.getConnection();
        ResourceBundle bundle=ResourceBundle.getBundle("pro");
        String path = bundle.getString("hdfs_path");
        String today = LocalDate.now().format(ISO_LOCAL_DATE);
        String yesterday = GetYserterday.getSpecifiedDayBefore(today);
        PreparedStatement ps=null;
        PreparedStatement ps_isexists=null;
        ResultSet rs = null;
        try {
            for(int i=1;i<=total_container;i++){
                String sql="insert into hdfs_path values(?,0)";
                String sql_isexists="select * from hdfs_path where path = ?";
                ps = conn.prepareStatement(sql);
                ps_isexists = conn.prepareStatement(sql_isexists);
                String hdfs_path=path+yesterday+"/";
                hdfs_path=hdfs_path+i;
                ps_isexists.setString(1,hdfs_path);
                ps.setString(1,hdfs_path);
                rs = ps_isexists.executeQuery();
                boolean next = rs.next();
                if(!next){
                    boolean execute = ps.execute();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseConn.close(conn,ps,ps_isexists,rs);
        }
    }
}
