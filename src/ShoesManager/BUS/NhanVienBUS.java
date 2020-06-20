package ShoesManager.BUS;

import ShoesManager.DAO.NhanVienDAO;
import ShoesManager.DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
    private ArrayList<NhanVienDTO> list_NV;
    /**
     * Xử lý các lệnh trong SQL
     */
    private NhanVienDAO nvDAO;
    
    public NhanVienBUS() throws Exception {
        list_NV = new ArrayList<>();
        nvDAO = new NhanVienDAO();
        list_NV = nvDAO.docDB();
    }
    
    /**
     * thêm 1 nhân viên vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(NhanVienDTO nv) throws Exception{
        if ( nvDAO.them(nv) ) {
            list_NV.add(nv);
        }
        return false;
    }
    
    /**
     * xóa 1 nhân viên khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(NhanVienDTO nv) throws Exception {
        if ( nvDAO.xoa(nv) ) {
            
            // duyệt từng phẩn tử
            for ( NhanVienDTO nhanvien : list_NV ) {
                if (nhanvien.getstrMaNV() == nv.getstrMaNV()){
                    list_NV.remove(nhanvien);
                break;
                }
            }
        }
        
        return false;
    }
    
    /**
     * sửa thông tin của 1 nhân viên <br>
     * - Trừ thông tin đăng nhập của nhân viên đó
     * @return true nếu thực hiện thành công
     */
    public Boolean sua(NhanVienDTO nv) throws Exception {
        if ( nvDAO.sua(nv) ) {
            
            // duyệt từng phẩn tử
            for ( NhanVienDTO nhanvien : list_NV ) {
                if (nhanvien.getstrMaNV() == nv.getstrMaNV()){
                break;
                }
            }
        }
        
        return false;
    }
    
    public NhanVienDTO getNhanVien_MaNV(String strMaNV) {
        for ( NhanVienDTO nhanvien : list_NV ) {
            if (nhanvien.getstrMaNV().equals(strMaNV)) {
                return nhanvien;
            }
        }
        return null;
    }
        
}
