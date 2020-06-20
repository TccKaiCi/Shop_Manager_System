package ShoesManager.BUS;

import ShoesManager.DAO.ChiTietHDDAO;
import ShoesManager.DTO.ChiTietHDDTO;
import java.util.ArrayList;
import java.util.Collections;

public class ChiTietHDBUS {
    private ArrayList<ChiTietHDDTO> list_HD;
    /**
     * Xử lý các lệnh trong SQL
     */
    private ChiTietHDDAO hdDAO;
    
    public void docDB() throws Exception {
        list_HD = new ArrayList<>();
        hdDAO = new ChiTietHDDAO();
        list_HD = hdDAO.docDB();
    }

    public void add(ChiTietHDDTO hd) {
        list_HD.add(hd);
    }
    
    public void deleteAll() {
        list_HD.removeAll(list_HD);
    }
    
    public ChiTietHDBUS() throws Exception {
        list_HD = new ArrayList<>();
        hdDAO = new ChiTietHDDAO();
        list_HD = hdDAO.docDB();
    }

    public ArrayList<ChiTietHDDTO> getList_HD() {
        return list_HD;
    }

    public void setList_HD(ArrayList<ChiTietHDDTO> list_HD) {
        this.list_HD = list_HD;
    }

    public ChiTietHDDAO getHdDAO() {
        return hdDAO;
    }

    public void setHdDAO(ChiTietHDDAO hdDAO) {
        this.hdDAO = hdDAO;
    }
    
    public int getNumbChiTietHD() {
        return list_HD.size();
    }
    
    public ChiTietHDDTO getInfor(int i){
        int iCount =0;
        for (ChiTietHDDTO hd : list_HD) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }

    public ArrayList<ChiTietHDDTO> timKiem_MaSP(String strMaSP1, String strMaSP2, int sapxep) {
        ArrayList<ChiTietHDDTO> arr = new ArrayList<>();
        
        Collections.sort(this.list_HD, ChiTietHDDTO::maSPTangdan);

        int flag = 0;
        if (strMaSP1.equals(strMaSP2))
            for (ChiTietHDDTO hoadon : list_HD) {
                if ( hoadon.getStrMaGiay().indexOf(strMaSP1) != -1 ) {
                    arr.add(hoadon);
                    System.out.println("Tim thay SP1" + hoadon.getStrMaHD() );
                }
            }
        else    
            for (ChiTietHDDTO hoadon : list_HD) {
                if ( hoadon.getStrMaGiay().indexOf(strMaSP1) != -1 ) {
                    flag = 1;
                    System.out.println("Tim thay SP1" + hoadon.getStrMaHD() );
                }
                if ( hoadon.getStrMaGiay().indexOf(strMaSP2) != -1 ) {
                    flag = 2;
                    System.out.println("Tim thay SP2" + hoadon.getStrMaHD() );
                }
                
                if ( flag == 2 )
                    if ( hoadon.getStrMaGiay().indexOf(strMaSP2) == -1 )
                        break;
                
                if ( flag == 1 || flag == 2 )
                    arr.add(hoadon);
                
            }
        
        if(sapxep == 1){
            Collections.sort(arr, ChiTietHDDTO::maSPTangdan);
        }
        else if(sapxep == -1) {
            Collections.sort(arr, ChiTietHDDTO::maSPGiamdan);
        }
        return arr;
    }
    
    public ArrayList<ChiTietHDDTO> timKiem_SoLuong(int SL1, int SL2,int sapxep) {
        ArrayList<ChiTietHDDTO> arr = new ArrayList<>();
        for (ChiTietHDDTO hoadon : list_HD) {
            if ( hoadon.getiSoLuong() >= SL1 && hoadon.getiSoLuong() <= SL2) {
                System.out.println("Tim thay " + hoadon.getStrMaHD() );
                arr.add(hoadon);
            }
        }
        if(sapxep == 1){
            Collections.sort(arr, ChiTietHDDTO::soLuongTangdan);
        }
        else if(sapxep == -1){
            Collections.sort(arr, ChiTietHDDTO::soLuongGiamdan);
        }
        
        return arr;
    }
    
    /**
     * @return true nếu tìm thấy 
     */
    public boolean kiemTraKhoachinh(ChiTietHDDTO hd) {
        for (ChiTietHDDTO hoadon : list_HD) {
            if (hoadon.getStrMaHD().equals(hd.getStrMaHD()) &&
                    hoadon.getStrMaGiay().equals(hd.getStrMaGiay())){
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
    public Boolean them(ChiTietHDDTO hd) throws Exception{
        if ( !kiemTraKhoachinh(hd) ) {
            if ( hdDAO.them(hd) ) {
                list_HD.add(hd);
                System.out.println("thêm hóa đơn");
            }
        }
        return false;
    }
    
    /**
     * xóa 1hóa đơn hdỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(ChiTietHDDTO hd) throws Exception {
        if ( hdDAO.xoa(hd) ) {
            
            // duyệt từng phẩn tử
            for ( ChiTietHDDTO hoadon : list_HD ) {
                if (hoadon.getStrMaGiay().equals(hd.getStrMaGiay())
                        && hoadon.getStrMaHD().equals(hd.getStrMaHD())){
                    list_HD.remove(hoadon);
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
    public Boolean sua(ChiTietHDDTO hd) throws Exception {
        if ( hdDAO.sua(hd) ) {
            
            // duyệt từng phẩn tử
            for ( ChiTietHDDTO hoadon : list_HD ) {
                if (hoadon.getStrMaHD().equals(hd.getStrMaHD())
                        && hoadon.getStrMaGiay().equals(hd.getStrMaGiay())){
                    hoadon.setStrMaGiay(hd.getStrMaGiay());
                    hoadon.setStrMaHD(hd.getStrMaHD());
                    hoadon.setiGiaBan(hd.getiGiaBan());
                    hoadon.setiSoLuong(hd.getiSoLuong());
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
}
