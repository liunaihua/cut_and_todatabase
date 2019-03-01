import utils.CloseConn;
import utils.GetConn;
import utils.GetYserterday;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class Main {
    public static void main(String[] args) {
        String today = LocalDate.now().format(ISO_LOCAL_DATE);
        String yesterday = GetYserterday.getSpecifiedDayBefore(today);
        ResourceBundle bundle=ResourceBundle.getBundle("pro");
        String readFile_path = bundle.getString("readFile_path");
        String wirteFile_parh = bundle.getString("wirteFile_parh");
        int total_container= 3;
        try {
            total_container = ReadFile.read(readFile_path,
                    wirteFile_parh+yesterday+"/");
            JDBC.insert(total_container);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }




    }
}
