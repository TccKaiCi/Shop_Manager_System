package ShoesManager.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

/**
 * Kết nối SQL cơ bản
 */
public class MySQLConnection {
    String Host = "";
    String Username = "";
    String Password = "";
    String Database = "";
    
    Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public MySQLConnection(String Host, String Username, String Password, String Database) {
        this.Host = Host;
        this.Username = Username;
        this.Password = Password;
        this.Database = Database;
    }
    
    protected void driveTest () throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new Exception("My SQl not found driveTest");
        }
    }
    
    protected Connection getConnect() throws Exception {
//        nếu connection null thì khởi tạo mới
        if (this.connect == null) {
//            kiểm tra Driver
            driveTest();
            
//            Tạo url để kết nối tới Database
            String url = "jdbc:mysql://" + this.Host + ":3306/" + this.Database
                    + "?serverTimezone=" + TimeZone.getDefault().getID();
            // lay time zone neu ko the ket noi MySQL bang cách binh thuong
            try{
//                tạo connet thông qua url
                this.connect = DriverManager.getConnection(url, this.Username, this.Password);
            }        
            catch (SQLException e) {
                throw new Exception("không thể kết nối tới Database" + url +e.getMessage());
            }
        }
        
        return this.connect;
    }
    
//    tạo statement để thực thi Queury
    protected Statement getStatement() throws Exception {
//        kiểm tra stament đã đóng chưa
        if (this.statement == null) {
//            khởi tạo statement mới
            this.statement = getConnect().createStatement();
        }
        else {
            this.statement.isClosed();
        }
        return this.statement;
    }
    
    //hàm thực thi các câu lệnh SQl 
    public ResultSet excuteQuery(String Query) throws Exception{
        try {
            // thực thi câu lệnh
            this.resultSet = getStatement().executeQuery(Query);
            
        } catch (Exception e) {
            throw new Exception("Error excuteQuery " + e.getMessage());
        }
        
        return this.resultSet;
    }
    
//    thực thi các Insert, Update, Delete
    public int executeUpdate(String Query) throws Exception {
        //khai báo biến int để lưu trữ kết quả torng quá trình thực thi
        int res = Integer.MIN_VALUE;
        
        try {
            //thực thi câu lệnh
            res = getStatement().executeUpdate(Query);
        } catch (Exception e) {
            throw new Exception("Error " + e.getMessage());
        }
        
        return res;
    }
    
    //hàm đóng kết nối
    public void Close() throws Exception {
        if (this.resultSet != null && this.resultSet.isClosed()) {
            this.resultSet.close();
            this.resultSet = null;
        }
        if (this.statement != null && this.statement.isClosed()) {
            this.statement.close();
            this.statement = null;
        }
        if (this.connect != null && this.connect.isClosed()) {
            this.connect.close();
            this.connect = null;
        }
    }
}
