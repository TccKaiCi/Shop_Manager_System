package ShoesManager.DAO;

import ShoesManager.DTO.PhieuNhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


public class PhieuNhapDAO {
    MyConnectUnit connect;
     
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<PhieuNhapDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblphieunhap", condition, orderBy);
        ArrayList<PhieuNhapDTO> nhaccs = new ArrayList<>();
        while ( result.next() ) {
            PhieuNhapDTO nhacc = new PhieuNhapDTO();
            nhacc.setStrMaPN(result.getString("mapn"));
            nhacc.setStrMaNCC(result.getString("mancc"));
            nhacc.setStrMaNV(result.getString("manv"));
            nhacc.setStrNgayNhap(result.getString("ngaynhap"));
            nhacc.setTongTien(result.getDouble("tongtien"));
            nhaccs.add(nhacc);
        }
        connect.Close();
        return nhaccs;
    }
    
    public ArrayList<PhieuNhapDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<PhieuNhapDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 nhacc dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(PhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("mancc", nv.getStrMaNCC());
        insertValues.put("manv", nv.getStrMaNV());
        insertValues.put("mapn", nv.getStrMaPN());
        insertValues.put("ngaynhap", nv.getStrNgayNhap());
        insertValues.put("tongtien", nv.getTongTien());
        
        Boolean check = connect.Insert("tblphieunhap", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(PhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = " mapn = '"+nv.getStrMaPN()+"'";
        
        Boolean check = connect.Delete("tblphieunhap", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     */
    public Boolean sua(PhieuNhapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("mancc", nv.getStrMaNCC());
        insertValues.put("manv", nv.getStrMaNV());
        insertValues.put("ngaynhap", nv.getStrNgayNhap());
        insertValues.put("tongtien", nv.getTongTien());
        
        String condition = " mapn = '"+nv.getStrMaPN()+"'";
        
        Boolean check = connect.Update("tblphieunhap", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
