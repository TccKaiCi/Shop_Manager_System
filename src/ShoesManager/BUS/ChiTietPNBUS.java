package ShoesManager.BUS;

import ShoesManager.DAO.ChiTietPNDAO;
import ShoesManager.DTO.ChiTietPNDTO;
import java.util.ArrayList;
import java.util.Collections;

public class ChiTietPNBUS {
    private ArrayList<ChiTietPNDTO> list_PN;
    /**
     * Xử lý các lệnh trong SQL
     */
    private ChiTietPNDAO pnDAO;
    
    public void docDB() throws Exception {
        list_PN = new ArrayList<>();
        pnDAO = new ChiTietPNDAO();
        list_PN = pnDAO.docDB();
    }
    public void add(ChiTietPNDTO pn) {
        list_PN.add(pn);
    }
    public void deleteAll() {
        list_PN.removeAll(list_PN);
    }

    
    public ChiTietPNBUS() throws Exception {
        list_PN = new ArrayList<>();
        pnDAO = new ChiTietPNDAO();
        list_PN = pnDAO.docDB();
    }

    public ArrayList<ChiTietPNDTO> getList_PN() {
        return list_PN;
    }

    public void setList_PN(ArrayList<ChiTietPNDTO> list_PN) {
        this.list_PN = list_PN;
    }

    public ChiTietPNDAO getHdDAO() {
        return pnDAO;
    }

    public void setHdDAO(ChiTietPNDAO pnDAO) {
        this.pnDAO = pnDAO;
    }
    
    public int getNumbChiTietPN() {
        return list_PN.size();
    }
    
    public ChiTietPNDTO getInfor(int i){
        int iCount =0;
        for (ChiTietPNDTO pn : list_PN) {
            if (iCount == i)
                return pn;
            iCount++;
        }
        return null;
    }

    public ArrayList<ChiTietPNDTO> timKiem_MaSP(String strMaSP1, String strMaSP2) {
        ArrayList<ChiTietPNDTO> arr = new ArrayList<>();
        
        Collections.sort(list_PN, ChiTietPNDTO::maSPTangdan);
        
        int flag = 0;
        if (strMaSP1.equals(strMaSP2))
            for (ChiTietPNDTO hoadon : list_PN) {
                if ( hoadon.getStrMaGiay().indexOf(strMaSP1) != -1 ) {
                    arr.add(hoadon);
                    System.out.println("Tim thay SP1" + hoadon.getStrMaPN() );
                }
            }
        else    
            for (ChiTietPNDTO hoadon : list_PN) {
                if ( hoadon.getStrMaGiay().indexOf(strMaSP1) != -1 ) {
                    flag = 1;
                    System.out.println("Tim thay SP1" + hoadon.getStrMaPN() );
                }
                if ( hoadon.getStrMaGiay().indexOf(strMaSP2) != -1 ) {
                    flag = 2;
                    System.out.println("Tim thay SP2" + hoadon.getStrMaPN() );
                }
                
                if ( flag == 2 )
                    if ( hoadon.getStrMaGiay().indexOf(strMaSP2) == -1 )
                        break;
                
                if ( flag == 1 || flag == 2 )
                    arr.add(hoadon);
                
            }
        
        return arr;
    }
    
    public ArrayList<ChiTietPNDTO> timKiem_SoLuong(int SL1, int SL2) {
        ArrayList<ChiTietPNDTO> arr = new ArrayList<>();
        for (ChiTietPNDTO hoadon : list_PN) {
            if ( hoadon.getiSoLuong() >= SL1 && hoadon.getiSoLuong() <= SL2) {
                System.out.println("Tim thay " + hoadon.getStrMaPN() );
                arr.add(hoadon);
            }
        }
        
        return arr;
    }
    
    /**
     * @return true nếu tìm thấy 
     */
    public boolean kiemTraKhoachinh(ChiTietPNDTO pn) {
        for (ChiTietPNDTO hoadon : list_PN) {
            if (hoadon.getStrMaPN().equals(pn.getStrMaPN()) &&
                    hoadon.getStrMaGiay().equals(pn.getStrMaGiay())){
                System.out.println("Bị trùng");
                return true;
            }
        }
        return false;
    }
    
    //-----------------------------------------------------------------------------------------------
    /**
     * thêm 1hóa đơn vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(ChiTietPNDTO pn) throws Exception{
        if ( !kiemTraKhoachinh(pn) ) {
            if ( pnDAO.them(pn) ) {
                list_PN.add(pn);
                System.out.println("thêm phiếu nhập");
            }
        }
        return false;
    }
    
    /**
     * xóa 1hóa đơn pnỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(ChiTietPNDTO pn) throws Exception {
        if ( pnDAO.xoa(pn) ) {
            
            // duyệt từng phẩn tử
            for ( ChiTietPNDTO hoadon : list_PN ) {
                if (hoadon.getStrMaGiay().equals(pn.getStrMaGiay())
                        && hoadon.getStrMaPN().equals(pn.getStrMaPN())){
                    list_PN.remove(hoadon);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * sửa thông tin của 1hóa đơn <br>
     * - Trừ thông tin đăng nhập củahóa đơn đó
     * @return true nếu thực hiện thành công
     */
    public Boolean sua(ChiTietPNDTO pn) throws Exception {
        if ( pnDAO.sua(pn) ) {
            
            // duyệt từng phẩn tử
            for ( ChiTietPNDTO hoadon : list_PN ) {
                if (hoadon.getStrMaPN().equals(pn.getStrMaPN())
                        && hoadon.getStrMaGiay().equals(pn.getStrMaGiay())){
                    hoadon.setStrMaGiay(pn.getStrMaGiay());
                    hoadon.setStrMaPN(pn.getStrMaPN());
                    hoadon.setiGiaNhap(pn.getiGiaNhap());
                    hoadon.setiSoLuong(pn.getiSoLuong());
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
}
