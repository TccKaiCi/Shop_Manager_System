package ShoesManager.DAO;
/**
 * Mã hdách hàng là hdóa chính
 */
import ShoesManager.DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class HoaDonDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<HoaDonDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblhoadon", condition, orderBy);
        ArrayList<HoaDonDTO> hoadons = new ArrayList<>();
        while ( result.next() ) {
            HoaDonDTO hoadon = new HoaDonDTO();
            hoadon.setStrMaHD(result.getString("mahd"));
            hoadon.setStrMaKH(result.getString("makh"));
            hoadon.setStrMaKM(result.getString("makm"));
            hoadon.setStrMaNV(result.getString("manv"));
            hoadon.setStrNgayBan(result.getString("ngayban"));
            hoadon.setTongTien(result.getDouble("Tongtien"));
            hoadons.add(hoadon);
        }
        connect.Close();
        return hoadons;
    }
    
    public ArrayList<HoaDonDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<HoaDonDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 hdách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(HoaDonDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("mahd", hd.getStrMaHD());
        insertValues.put("makh", hd.getStrMaKH());
        insertValues.put("makm", hd.getStrMaKM());
        insertValues.put("manv", hd.getStrMaNV());
        insertValues.put("ngayban", hd.getStrNgayBan());
        insertValues.put("tongtien", hd.getTongTien());
        
        Boolean check = connect.Insert("tblhoadon", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param hd chuyền vào dữ liệu hdách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(HoaDonDTO hd) throws Exception {
        connect = new MyConnectUnit();
        String condition = " mahd = '"+hd.getStrMaHD()+"'";
        
        Boolean check = connect.Delete("tblhoadon", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param hd truyền vào dữ liệu hdách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 hdách hàng
     * @return true nếu thành công
     */
    public Boolean sua(HoaDonDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("makh", hd.getStrMaKH());
        insertValues.put("makm", hd.getStrMaKM());
        insertValues.put("manv", hd.getStrMaNV());
        insertValues.put("ngayban", hd.getStrNgayBan());
        insertValues.put("tongtien", hd.getTongTien());
        
        String condition = " MaHD = '"+hd.getStrMaHD()+"'";
        
        Boolean check = connect.Update("tblhoadon", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
