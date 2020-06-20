package ShoesManager.DAO;

import ShoesManager.DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class KhuyenMaiDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<KhuyenMaiDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblkhuyenmai", condition, orderBy);
        ArrayList<KhuyenMaiDTO> khuyenmais = new ArrayList<>();
        while ( result.next() ) {
            KhuyenMaiDTO khuyenmai = new KhuyenMaiDTO();
            khuyenmai.setStrDieuKien(result.getString("DieuKien"));
            khuyenmai.setStrLoaiChuongTrinh(result.getString("LoaiChuongtrinh"));
            khuyenmai.setStrMaKM(result.getString("MaKM"));
            khuyenmai.setStrNgayBatDau(result.getString("Ngaybatdau"));
            khuyenmai.setStrNgayKetThuc(result.getString("ngayketthuc"));
            khuyenmai.setStrTenChuongTrinh(result.getString("tenchuongtrinh"));
            
            khuyenmais.add(khuyenmai);
        }
        connect.Close();
        return khuyenmais;
    }
    
    public ArrayList<KhuyenMaiDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<KhuyenMaiDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 kmách hàng dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(KhuyenMaiDTO km) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("dieukien", km.getStrDieuKien());
        insertValues.put("loaichuongtrinh", km.getStrLoaiChuongTrinh());
        insertValues.put("makm", km.getStrMaKM());
        insertValues.put("ngaybatdau", km.getStrNgayBatDau());
        insertValues.put("ngayketthuc", km.getStrNgayKetThuc());
        insertValues.put("tenchuongtrinh", km.getStrTenChuongTrinh());
        
        Boolean check = connect.Insert("tblkhuyenmai", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param km chuyền vào dữ liệu kmách hàng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(KhuyenMaiDTO km) throws Exception {
        connect = new MyConnectUnit();
        String condition = " makm = '"+km.getStrMaKM()+"'";
        
        Boolean check = connect.Delete("tblkhuyenmai", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param km truyền vào dữ liệu kmách hàng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 kmách hàng
     * @return true nếu thành công
     */
    public Boolean sua(KhuyenMaiDTO km) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("dieukien", km.getStrDieuKien());
        insertValues.put("loaichuongtrinh", km.getStrLoaiChuongTrinh());
        insertValues.put("ngaybatdau", km.getStrNgayBatDau());
        insertValues.put("ngayketthuc", km.getStrNgayKetThuc());
        insertValues.put("tenchuongtrinh", km.getStrTenChuongTrinh());
        
        String condition = " MaKM = '"+km.getStrMaKM()+"'";
        
        Boolean check = connect.Update("tblkhuyenmai", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
