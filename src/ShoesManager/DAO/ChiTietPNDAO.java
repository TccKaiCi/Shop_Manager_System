package ShoesManager.DAO;
import ShoesManager.DTO.ChiTietPNDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ChiTietPNDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<ChiTietPNDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblchitietpn", condition, orderBy);
        ArrayList<ChiTietPNDTO> hoadons = new ArrayList<>();
        while ( result.next() ) {
            ChiTietPNDTO hoadon = new ChiTietPNDTO();
            hoadon.setStrMaGiay(result.getString("Magiay"));
            hoadon.setStrMaPN(result.getString("MaPN"));
            hoadon.setiGiaNhap(result.getInt("Gianhap"));
            hoadon.setiSoLuong(result.getInt("soluong"));
            hoadons.add(hoadon);
        }
        connect.Close();
        return hoadons;
    }
    
    public ArrayList<ChiTietPNDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<ChiTietPNDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 pnách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(ChiTietPNDTO pn) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("mapn", pn.getStrMaPN());
        insertValues.put("magiay", pn.getStrMaGiay());
        insertValues.put("soluong", pn.getiSoLuong());
        insertValues.put("gianhap", pn.getiGiaNhap());
        
        Boolean check = connect.Insert("tblchitietpn", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param pn chuyền vào dữ liệu pnách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(ChiTietPNDTO pn) throws Exception {
        connect = new MyConnectUnit();
        String condition = " mapn = '"+pn.getStrMaPN()+"' && magiay = '"+pn.getStrMaGiay()+"'";
        
        Boolean check = connect.Delete("tblchitietpn", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param pn truyền vào dữ liệu pnách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 pnách hàng
     * @return true nếu thành công
     */
    public Boolean sua(ChiTietPNDTO pn) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("soluong", pn.getiSoLuong());
        insertValues.put("gianhap", pn.getiGiaNhap());
        
        String condition = " mapn = '"+pn.getStrMaPN()+"' && magiay = '"+pn.getStrMaGiay()+"'";
        
        Boolean check = connect.Update("tblchitietpn", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
