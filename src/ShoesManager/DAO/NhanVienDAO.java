package ShoesManager.DAO;

import ShoesManager.DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


public class NhanVienDAO {
    MyConnectUnit connect;
     
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<NhanVienDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblnhanvien", condition, orderBy);
        ArrayList<NhanVienDTO> nhanviens = new ArrayList<>();
        while ( result.next() ) {
            NhanVienDTO nhanvien = new NhanVienDTO();
            nhanvien.setstrMaNV(result.getString("MaNV") );
            nhanvien.setiLuong(Integer.parseInt( result.getString("Luong")) );
            nhanvien.setiDienThoai(Integer.parseInt( result.getString("DienThoai")));
            nhanvien.setStrAnh(result.getString("Anh"));
            nhanvien.setStrChucVu(result.getString("ChucVu"));
            nhanvien.setStrDiaChi(result.getString("DiaChi"));
            nhanvien.setStrEmail(result.getString("Email"));
            nhanvien.setStrGioiTinh(result.getString("GioiTinh"));
            nhanvien.setStrHo(result.getString("Ho"));
            nhanvien.setStrTen(result.getString("Ten"));
            nhanviens.add(nhanvien);
        }
        connect.Close();
        return nhanviens;
    }
    
    public ArrayList<NhanVienDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<NhanVienDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /**
     * Tạo thêm 1 nhanvien dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(NhanVienDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaNV", nv.getstrMaNV());
        insertValues.put("Ho", nv.getStrHo());
        insertValues.put("Ten", nv.getStrTen());
        insertValues.put("GioiTinh", nv.getStrGioiTinh());
        insertValues.put("DiaChi", nv.getStrDiaChi());
        insertValues.put("DienThoai", nv.getiDienThoai());
        insertValues.put("Email", nv.getStrEmail());
        insertValues.put("Luong", nv.getiLuong());
        insertValues.put("Anh", nv.getStrAnh());
        
        Boolean check = connect.Insert("tblnhanvien", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(NhanVienDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = " tendangnhap = '"+nv.getstrMaNV()+"'";
        
        Boolean check = connect.Delete("tblnhanvien", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     */
    public Boolean sua(NhanVienDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("Ho", nv.getStrHo());
        insertValues.put("Ten", nv.getStrTen());
        insertValues.put("GioiTinh", nv.getStrGioiTinh());
        insertValues.put("DiaChi", nv.getStrDiaChi());
        insertValues.put("DienThoai", nv.getiDienThoai());
        insertValues.put("Email", nv.getStrEmail());
        insertValues.put("Luong", nv.getiLuong());
        insertValues.put("Anh", nv.getStrAnh());
        
        String condition = " tendangnhap = '"+nv.getstrMaNV()+"'";
        
        Boolean check = connect.Update("tblnhanvien", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
