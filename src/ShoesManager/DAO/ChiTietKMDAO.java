package ShoesManager.DAO;
import ShoesManager.DTO.ChiTietKMDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ChiTietKMDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<ChiTietKMDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblchitietkm", condition, orderBy);
        ArrayList<ChiTietKMDTO> khuyemais = new ArrayList<>();
        while ( result.next() ) {
            ChiTietKMDTO khuyemai = new ChiTietKMDTO();
            khuyemai.setStrMaGiay(result.getString("Magiay"));
            khuyemai.setStrMaKM(result.getString("MaKM"));
            khuyemai.setTiLeKM(result.getDouble("TiLeKm"));
            khuyemais.add(khuyemai);
        }
        connect.Close();
        return khuyemais;
    }
    
    public ArrayList<ChiTietKMDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<ChiTietKMDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 hdách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(ChiTietKMDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("makm", hd.getStrMaKM());
        insertValues.put("magiay", hd.getStrMaGiay());
        insertValues.put("tilekm", hd.getTiLeKM());
        
        Boolean check = connect.Insert("tblchitietkm", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param hd chuyền vào dữ liệu hdách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(ChiTietKMDTO hd) throws Exception {
        connect = new MyConnectUnit();
        String condition = " makm = '"+hd.getStrMaKM()+"' && magiay = '"+hd.getStrMaGiay()+"'";
        
        Boolean check = connect.Delete("tblchitietkm", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param hd truyền vào dữ liệu hdách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 hdách hàng
     * @return true nếu thành công
     */
    public Boolean sua(ChiTietKMDTO hd) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("magiay", hd.getStrMaGiay());
        insertValues.put("tilekm", hd.getTiLeKM());
        
        String condition = " makm = '"+hd.getStrMaKM()+"' && magiay = '"+hd.getStrMaGiay()+"'";
        
        Boolean check = connect.Update("tblchitietkm", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
