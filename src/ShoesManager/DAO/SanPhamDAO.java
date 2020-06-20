package ShoesManager.DAO;
import ShoesManager.DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class SanPhamDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<SanPhamDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblsanpham", condition, orderBy);
        ArrayList<SanPhamDTO> sanphams = new ArrayList<>();
        while ( result.next() ) {
            SanPhamDTO sanpham = new SanPhamDTO();
            sanpham.setStrMaGiay(result.getString("Magiay"));
            sanpham.setStrChatLieu(result.getString("ChatLieu"));
            sanpham.setStrDoiTuongSD(result.getString("doituongsd"));
            sanpham.setStrMaLoai(result.getString("maloai"));
            sanpham.setStrMaMau(result.getString("mamau"));
            sanpham.setStrMaThuongHieu(result.getString("mathuonghieu"));
            sanpham.setStrMaxx(result.getString("maxx"));
            sanpham.setStrTenGiay(result.getString("tengiay"));
            sanpham.setiGia(result.getInt("gia"));
            sanpham.setiSize(result.getInt("Size"));
            sanpham.setiSoLuong(result.getInt("soluong"));
            
            sanphams.add(sanpham);
        }
        connect.Close();
        return sanphams;
    }
    
    public ArrayList<SanPhamDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<SanPhamDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 hdách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(SanPhamDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("magiay", hd.getStrMaGiay());
        insertValues.put("soluong", hd.getiSoLuong());
        insertValues.put("gia", hd.getiGia());
        insertValues.put("size", hd.getiSize());
        insertValues.put("chatlieu", hd.getStrChatLieu());
        insertValues.put("doituongsd", hd.getStrDoiTuongSD());
        insertValues.put("maloai", hd.getStrMaLoai());
        insertValues.put("mamau", hd.getStrMaMau());
        insertValues.put("mathuonghieu", hd.getStrMaThuongHieu());
        insertValues.put("maxx", hd.getStrMaxx());
        insertValues.put("tengiay", hd.getStrTenGiay());
        
        Boolean check = connect.Insert("tblsanpham", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param hd chuyền vào dữ liệu hdách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(SanPhamDTO hd) throws Exception {
        connect = new MyConnectUnit();
        String condition = " magiay = '"+hd.getStrMaGiay()+"'";
        
        Boolean check = connect.Delete("tblmagiay", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param hd truyền vào dữ liệu hdách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 hdách hàng
     * @return true nếu thành công
     */
    public Boolean sua(SanPhamDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("soluong", hd.getiSoLuong());
        insertValues.put("gia", hd.getiGia());
        insertValues.put("size", hd.getiSize());
        insertValues.put("chatlieu", hd.getStrChatLieu());
        insertValues.put("doituongsd", hd.getStrDoiTuongSD());
        insertValues.put("maloai", hd.getStrMaLoai());
        insertValues.put("mamau", hd.getStrMaMau());
        insertValues.put("mathuonghieu", hd.getStrMaThuongHieu());
        insertValues.put("maxx", hd.getStrMaxx());
        insertValues.put("tengiay", hd.getStrTenGiay());
        
        System.out.println(hd.toString());
        
        String condition = " magiay = '"+hd.getStrMaGiay()+"'";
        
        Boolean check = connect.Update("tblsanpham", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
