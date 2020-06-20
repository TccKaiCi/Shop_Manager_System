package ShoesManager.BUS;

import ShoesManager.DAO.PhieuNhapDAO;
import ShoesManager.DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {
    private ArrayList<PhieuNhapDTO> list_TK;
    /**
     * Xử lý các lệnh trong SQL
     */
    private PhieuNhapDAO tkDAO;
    
    public PhieuNhapBUS() throws Exception {
        list_TK = new ArrayList<>();
        tkDAO = new PhieuNhapDAO();
        list_TK = tkDAO.docDB();
    }
    
    public void add(PhieuNhapDTO pn) {
        list_TK.add(pn);
    }
    
    public void deleteAll() {
        list_TK.removeAll(list_TK);
    }
    
    public void docDB() throws Exception {
        list_TK = new ArrayList<>();
        tkDAO = new PhieuNhapDAO();
        list_TK = tkDAO.docDB();
    }

    public ArrayList<PhieuNhapDTO> getList_TK() {
        return list_TK;
    }

    public void setList_TK(ArrayList<PhieuNhapDTO> list_TK) {
        this.list_TK = list_TK;
    }
    
    public int getNumb() {
        return list_TK.size();
    }
    
    public PhieuNhapDTO getInfor(int i){
        int iCount =0;
        for (PhieuNhapDTO hd : list_TK) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    
    public String getDefaultMaPN() {
        if (list_TK.size() == 0)
            return "PN001";
        else {
            String s = "PN";
            int iNumb = 0;
            
            for (PhieuNhapDTO hoadon : list_TK) {
                String[] maPN = hoadon.getStrMaPN().split("PN");
                iNumb = Integer.parseInt( maPN[1] );
                iNumb++;
            }
            switch (demSoChuSo(iNumb)) {
                case 1:
                    s +="0";
                case 2:
                    s +="0";
                case 3:  
            }
            s += iNumb;
            return s;
        }
    }
    
     public ArrayList<PhieuNhapDTO> timKiem_MaPN(String strMaPN) {
        ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
        for (PhieuNhapDTO hoadon : list_TK) {
            if ( hoadon.getStrMaPN().indexOf(strMaPN) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaPN() );
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
    public ArrayList<PhieuNhapDTO> timKiem_MaNV(String strMaNV) {
        ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
        for (PhieuNhapDTO hoadon : list_TK) {
            if ( hoadon.getStrMaNV().indexOf(strMaNV) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaPN() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }
    
    public ArrayList<PhieuNhapDTO> timKiem_MaNCC(String strMaNCC) {
        ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
        for (PhieuNhapDTO hoadon : list_TK) {
            if ( hoadon.getStrMaNCC().indexOf(strMaNCC) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaPN() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }
    
    public ArrayList<PhieuNhapDTO> timKiem_TongTien(String strTT) {
        ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
        for (PhieuNhapDTO hoadon : list_TK) {
            if ( String.valueOf(hoadon.getTongTien()).indexOf(strTT) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaPN() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }
    
    
    /**
     * thêm 1 tài khoản vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(PhieuNhapDTO tk) throws Exception{
        if ( tkDAO.them(tk) ) {
            list_TK.add(tk);
        }
        return false;
    }
    
    /**
     * xóa 1 tài khoản khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(PhieuNhapDTO tk) throws Exception {
        if ( tkDAO.xoa(tk) ) {
            
            // duyệt từng phẩn tử
            for ( PhieuNhapDTO taikhoan : list_TK ) {
                if (taikhoan.getStrMaPN().equals(tk.getStrMaPN())){
                    list_TK.remove(taikhoan);
                break;
                }
            }
        }
        
        return false;
    }
    
    /**
     * sửa thông tin của 1 tài khoản <br>
     * - Trừ thông tin đăng nhập của tài khoản đó
     * @return true nếu thực hiện thành công
     */
    public Boolean sua(PhieuNhapDTO tk) throws Exception {
        if ( tkDAO.sua(tk) ) {
            
            // duyệt từng phẩn tử
            for ( PhieuNhapDTO taikhoan : list_TK ) {
                if (taikhoan.getStrMaPN().equals(tk.getStrMaPN())){
                    taikhoan.setStrMaNCC(tk.getStrMaNCC());
                    taikhoan.setStrMaNV(tk.getStrMaNV());
                    taikhoan.setStrMaPN(tk.getStrMaPN());
                    taikhoan.setStrNgayNhap(tk.getStrNgayNhap());
                    taikhoan.setTongTien(tk.getTongTien());
                    return true;
                }
            }
        }
        
        return false;
    }

}
