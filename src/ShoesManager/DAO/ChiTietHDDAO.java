package ShoesManager.DAO;
import ShoesManager.DTO.ChiTietHDDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ChiTietHDDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<ChiTietHDDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblchitiethd", condition, orderBy);
        ArrayList<ChiTietHDDTO> hoadons = new ArrayList<>();
        while ( result.next() ) {
            ChiTietHDDTO hoadon = new ChiTietHDDTO();
            hoadon.setStrMaGiay(result.getString("Magiay"));
            hoadon.setStrMaHD(result.getString("MaHD"));
            hoadon.setiGiaBan(result.getInt("GiaBan"));
            hoadon.setiSoLuong(result.getInt("soluong"));
            hoadons.add(hoadon);
        }
        connect.Close();
        return hoadons;
    }
    
    public ArrayList<ChiTietHDDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<ChiTietHDDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 hdách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(ChiTietHDDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("mahd", hd.getStrMaHD());
        insertValues.put("magiay", hd.getStrMaGiay());
        insertValues.put("soluong", hd.getiSoLuong());
        insertValues.put("giaban", hd.getiGiaBan());
        
        Boolean check = connect.Insert("tblchitiethd", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param hd chuyền vào dữ liệu hdách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(ChiTietHDDTO hd) throws Exception {
        connect = new MyConnectUnit();
        String condition = " mahd = '"+hd.getStrMaHD()+"' && magiay = '"+hd.getStrMaGiay()+"'";
        
        Boolean check = connect.Delete("tblchitiethd", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param hd truyền vào dữ liệu hdách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 hdách hàng
     * @return true nếu thành công
     */
    public Boolean sua(ChiTietHDDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("soluong", hd.getiSoLuong());
        insertValues.put("giaban", hd.getiGiaBan());
        
        String condition = " mahd = '"+hd.getStrMaHD()+"' && magiay = '"+hd.getStrMaGiay()+"'";
        
        Boolean check = connect.Update("tblchitiethd", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
