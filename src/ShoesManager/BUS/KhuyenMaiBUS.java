package ShoesManager.BUS;

import ShoesManager.DAO.KhuyenMaiDAO;
import ShoesManager.DTO.KhuyenMaiDTO;
import java.util.ArrayList;

public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> list_KM;
    /**
     * Xử lý các lệnh trong SQL
     */
    private KhuyenMaiDAO khDAO;
    
    public void docDB() throws Exception {
        list_KM = new ArrayList<>();
        khDAO = new KhuyenMaiDAO();
        list_KM = khDAO.docDB();
    }
    
    public int getNumb() {
        return list_KM.size();
    }
    
    public KhuyenMaiDTO getInfor(int i){
        int iCount =0;
        for (KhuyenMaiDTO hd : list_KM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public KhuyenMaiDTO getInfor(String strMaKM){
        for (KhuyenMaiDTO hd : list_KM) {
            if (hd.getStrMaKM().equals(strMaKM))
                return hd;
        }
        return null;
    }
    
    public KhuyenMaiBUS() throws Exception {
        list_KM = new ArrayList<>();
        khDAO = new KhuyenMaiDAO();
        list_KM = khDAO.docDB();
    }
    public int getNumbKM(){
        return list_KM.size();
    }
    
    public String getDefaultMaKM() {
        if (list_KM.size() == 0)
            return "KM001";
        else {
            String s = "KM";
            int iNumb = 0;
            
            for (KhuyenMaiDTO hoadon : list_KM) {
                String[] maHD = hoadon.getStrMaKM().split("KM");
                iNumb = Integer.parseInt( maHD[1] );
                iNumb++;
            }
            s += iNumb;
            return s;
        }
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    public ArrayList<KhuyenMaiDTO> getList_KM() {
        return list_KM;
    }

    public void setList_KM(ArrayList<KhuyenMaiDTO> list_KM) {
        this.list_KM = list_KM;
    }
    
    public ArrayList<KhuyenMaiDTO> timKiem_MaKM(String strMaKM) {
        ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
        for (KhuyenMaiDTO hoadon : list_KM) {
            if ( hoadon.getStrMaKM().indexOf(strMaKM) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaKM());
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
    public ArrayList<KhuyenMaiDTO> timKiem_TenCT(String strTenCT) {
        ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
        for (KhuyenMaiDTO km : list_KM) {
            if (km.getStrTenChuongTrinh().indexOf(strTenCT) != -1)
                arr.add(km);
        }
        return arr;
    }

    
    /**
     * thêm 1khuyến mãi vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(KhuyenMaiDTO kh) throws Exception{
        if ( khDAO.them(kh) ) {
            list_KM.add(kh);
        }
        return false;
    }
    
    /**
     * xóa 1khuyến mãi khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(KhuyenMaiDTO kh) throws Exception {
        if ( khDAO.xoa(kh) ) {
            
            // duyệt từng phẩn tử
            for ( KhuyenMaiDTO taikhoan : list_KM ) {
                if (taikhoan.getStrMaKM().equals(kh.getStrMaKM())){
                    list_KM.remove(taikhoan);
                break;
                }
            }
        }
        
        return false;
    }
    
    /**
     * sửa thông tin của 1khuyến mãi <br>
     * - Trừ thông tin đăng nhập củakhuyến mãi đó
     * @return true nếu thực hiện thành công
     */
    public Boolean sua(KhuyenMaiDTO kh) throws Exception {
        if ( khDAO.sua(kh) ) {
            
            // duyệt từng phẩn tử
            for ( KhuyenMaiDTO taikhoan : list_KM ) {
                if (taikhoan.getStrMaKM().equals(kh.getStrMaKM())){
                     taikhoan.setStrDieuKien(kh.getStrDieuKien());
                     taikhoan.setStrLoaiChuongTrinh(kh.getStrLoaiChuongTrinh());
                     taikhoan.setStrMaKM(kh.getStrMaKM());
                     taikhoan.setStrNgayBatDau(kh.getStrNgayBatDau());
                     taikhoan.setStrNgayKetThuc(kh.getStrNgayKetThuc());
                     taikhoan.setStrTenChuongTrinh(kh.getStrTenChuongTrinh());
                break;
                }
            }
        }
        
        return false;
    }
}
