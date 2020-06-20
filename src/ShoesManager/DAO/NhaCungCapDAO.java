package ShoesManager.DAO;

import ShoesManager.DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


public class NhaCungCapDAO {
    MyConnectUnit connect;
     
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<NhaCungCapDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblnhacungcap", condition, orderBy);
        ArrayList<NhaCungCapDTO> nhaccs = new ArrayList<>();
        while ( result.next() ) {
            NhaCungCapDTO nhacc = new NhaCungCapDTO();
            nhacc.setStrMaNCC(result.getString("mancc"));
            nhacc.setStrTeNCC(result.getString("tenncc"));
            nhacc.setStrDiaChi(result.getString("DiaChi"));
            nhacc.setStrEmail(result.getString("Email"));
            nhaccs.add(nhacc);
        }
        connect.Close();
        return nhaccs;
    }
    
    public ArrayList<NhaCungCapDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<NhaCungCapDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 nhacc dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(NhaCungCapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("mancc", nv.getStrMaNCC());
        insertValues.put("tenncc", nv.getStrTeNCC());
        insertValues.put("DiaChi", nv.getStrDiaChi());
        insertValues.put("Email", nv.getStrEmail());
        
        Boolean check = connect.Insert("tblnhacungcap", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(NhaCungCapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = " mancc = '"+nv.getStrMaNCC()+"'";
        
        Boolean check = connect.Delete("tblnhacungcap", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     */
    public Boolean sua(NhaCungCapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("tenncc", nv.getStrTeNCC());
        insertValues.put("DiaChi", nv.getStrDiaChi());
        insertValues.put("Email", nv.getStrEmail());
        
        String condition = " mancc = '"+nv.getStrMaNCC()+"'";
        
        Boolean check = connect.Update("tblnhacungcap", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
