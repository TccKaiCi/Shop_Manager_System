package ShoesManager.DAO;
/**
 * Mã khách hàng là khóa chính
 */
import ShoesManager.DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class KhachHangDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<KhachHangDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblkhachhang", condition, orderBy);
        ArrayList<KhachHangDTO> khachhangs = new ArrayList<>();
        while ( result.next() ) {
            KhachHangDTO khachhang = new KhachHangDTO();
            khachhang.setStrMaKH(result.getString("MaKH"));
            khachhang.setStrHo(result.getString("Ho"));
            khachhang.setStrTen(result.getString("Ten"));
            khachhang.setStrDiaChi(result.getString("DiaChi"));
            khachhang.setStrEmail(result.getString("Email"));
            khachhang.setStrGioiTinh(result.getString("GioiTinh"));
            khachhang.setStrLoai(result.getString("Loai"));
            khachhang.setiTongChiTieu(result.getDouble("TongChiTieu"));
            khachhangs.add(khachhang);
        }
        connect.Close();
        return khachhangs;
    }
    
    public ArrayList<KhachHangDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<KhachHangDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 khách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(KhachHangDTO kh) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("diachi", kh.getStrDiaChi());
        insertValues.put("Email", kh.getStrEmail());
        insertValues.put("GioiTinh", kh.getStrGioiTinh());
        insertValues.put("ho", kh.getStrHo());
        insertValues.put("loai", kh.getStrLoai());
        insertValues.put("makh", kh.getStrMaKH());
        insertValues.put("ten", kh.getStrTen());
        insertValues.put("tongchitieu", kh.getiTongChiTieu());
        
        Boolean check = connect.Insert("tblkhachhang", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param kh chuyền vào dữ liệu khách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(KhachHangDTO kh) throws Exception {
        connect = new MyConnectUnit();
        String condition = " makh = '"+kh.getStrMaKH()+"'";
        
        Boolean check = connect.Delete("tblkhachhang", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param kh truyền vào dữ liệu khách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 khách hàng
     * @return true nếu thành công
     */
    public Boolean sua(KhachHangDTO kh) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("diachi", kh.getStrDiaChi());
        insertValues.put("Email", kh.getStrEmail());
        insertValues.put("GioiTinh", kh.getStrGioiTinh());
        insertValues.put("ho", kh.getStrHo());
        insertValues.put("loai", kh.getStrLoai());
        insertValues.put("ten", kh.getStrTen());
        insertValues.put("tongchitieu", kh.getiTongChiTieu());
        
        String condition = " MaKH = '"+kh.getStrMaKH()+"'";
        
        Boolean check = connect.Update("tblkhachhang", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
