package ShoesManager.BUS;

import ShoesManager.DAO.NhaCungCapDAO;
import ShoesManager.DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    private ArrayList<NhaCungCapDTO> list_NV;
    /**
     * Xử lý các lệnh trong SQL
     */
    private NhaCungCapDAO nvDAO;

    public ArrayList<NhaCungCapDTO> getList_NV() {
        return list_NV;
    }

    public void setList_NV(ArrayList<NhaCungCapDTO> list_NV) {
        this.list_NV = list_NV;
    }
    
    public NhaCungCapBUS() throws Exception {
        list_NV = new ArrayList<>();
        nvDAO = new NhaCungCapDAO();
        list_NV = nvDAO.docDB();
    }
    
    public int getNumb() {
        return list_NV.size();
    }
    
    /**
     * thêm 1 nhân viên vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(NhaCungCapDTO nv) throws Exception{
        if ( nvDAO.them(nv) ) {
            list_NV.add(nv);
        }
        return false;
    }
    
    /**
     * xóa 1 nhân viên khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(NhaCungCapDTO nv) throws Exception {
        if ( nvDAO.xoa(nv) ) {
            
            // duyệt từng phẩn tử
            for ( NhaCungCapDTO nhanvien : list_NV ) {
                if (nhanvien.getStrMaNCC()== nv.getStrMaNCC()){
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
    public Boolean sua(NhaCungCapDTO nv) throws Exception {
        if ( nvDAO.sua(nv) ) {
            
            // duyệt từng phẩn tử
            for ( NhaCungCapDTO nhanvien : list_NV ) {
                if (nhanvien.getStrMaNCC() == nv.getStrMaNCC()){
                    nhanvien = nv;
                    return true;
                }
            }
        }
        
        return false;
    }
        
}
