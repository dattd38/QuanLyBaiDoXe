package Controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class DAL {
    private static DAL instance;
    public static Connection con;
    private Statement st;
    
    private DAL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                + "databasename=QUANLYBAIDOXE;"
                + "username=sa;password=010620");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public static DAL getInstance() {
        if(instance == null){
            instance = new DAL();           
        }
        return instance;
    }

    // Thực hiện cho Update, delete, add
    // Return int cho so hàng bị thay đổi
    // Return 0 nếu không có hàng nào thay đổi
    public int executeQueryUpdate(String query) {
        try {
            if (con == null){
                new DAL();
            }
            Statement statement= con.createStatement();
            return statement.executeUpdate(query);
        }
        catch(Exception ex) {
            return -1;
        }
    }	
    // Trả về ResultSet tương ứng với bảng dữ liệu trong table
    public ResultSet executeQueryToGetData(String query) {
            try {
                if (con == null){
                    new DAL();
                }
                Statement statement= con.createStatement();
                ResultSet rs=statement.executeQuery(query);
                return rs;
            }
            catch(Exception ex) {
                ex.printStackTrace();
                return null;
            }
    }

    public void closeConnection() {
        try {
            if (con != null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
