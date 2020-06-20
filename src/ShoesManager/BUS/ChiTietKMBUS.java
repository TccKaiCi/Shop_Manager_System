package ShoesManager.BUS;

import ShoesManager.DAO.ChiTietKMDAO;
import ShoesManager.DTO.ChiTietKMDTO;
import java.util.ArrayList;
import java.util.Collections;

public class ChiTietKMBUS {
    private ArrayList<ChiTietKMDTO> list_KM;
    /**
     * Xử lý các lệnh trong SQL
     */
    private ChiTietKMDAO kmDAO;
    
    public void docDB() throws Exception {
        list_KM = new ArrayList<>();
        kmDAO = new ChiTietKMDAO();
        list_KM = kmDAO.docDB();
    }
     
    public ChiTietKMBUS() throws Exception {
        list_KM = new ArrayList<>();
        kmDAO = new ChiTietKMDAO();
        list_KM = kmDAO.docDB();
    }
    public int getNumbKM(){
        return list_KM.size();
    }
    public ArrayList<ChiTietKMDTO> getList_KM() {
        return list_KM;
    }

    public void setList_KM(ArrayList<ChiTietKMDTO> list_KM) {
        this.list_KM = list_KM;
    }
    
    public boolean kiemTraKhoachinh(ChiTietKMDTO hd) {
        for (ChiTietKMDTO khuyemai : list_KM) {
            if ( khuyemai.getStrMaGiay().equals(hd.getStrMaGiay())
                    && khuyemai.getStrMaKM().equals(hd.getStrMaKM())){
                System.out.println("Bị trùng");
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param strMaGiay ma giày
     * @param strMaKM
     * @return 
     */
    public ChiTietKMDTO getInfor(String strMaGiay, String strMaKM) {
        for (ChiTietKMDTO km : list_KM) {
            if ( km.getStrMaGiay().equals(strMaGiay) 
                    && km.getStrMaKM().equals(strMaKM)) {
                return km;
            }
        }
        ChiTietKMDTO khuyenmai = new ChiTietKMDTO("null", "null", 0);
        return khuyenmai;
    }
    
    public ChiTietKMDTO getInfor(String strMaGiay) {
        for (ChiTietKMDTO km : list_KM) {
            if ( km.getStrMaGiay().equals(strMaGiay) ) {
                System.out.println(km.toString());
                return km;
            }
        }
        return null;
    }
    
    public ChiTietKMDTO getInfor(int i){
        int iCount =0;
        for (ChiTietKMDTO hd : list_KM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    //-----------------------------------------------------------------------------------------------
    /**
     * thêm 1sản phẩm vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(ChiTietKMDTO hd) throws Exception{
        if ( !kiemTraKhoachinh(hd) ) {
            if ( kmDAO.them(hd) ) {
                list_KM.add(hd);
                System.out.println("thêm sản phẩm");
            }
        }
        return false;
    }
    
    /**
     * xóa 1khuyến mãi khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(ChiTietKMDTO kh) throws Exception {
        if ( kmDAO.xoa(kh) ) {
            
            // duyệt từng phẩn tử
            for ( ChiTietKMDTO khuyemai : list_KM ) {
                if (khuyemai.getStrMaKM().equals(kh.getStrMaKM())
                        &&khuyemai.getStrMaGiay().equals(kh.getStrMaGiay())){
                    list_KM.remove(khuyemai);
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
    public Boolean sua(ChiTietKMDTO kh) throws Exception {
        if ( kmDAO.sua(kh) ) {
            
            // duyệt từng phẩn tử
            for ( ChiTietKMDTO khuyemai : list_KM ) {
                if (khuyemai.getStrMaKM().equals(kh.getStrMaKM())){
                     khuyemai.setStrMaKM(kh.getStrMaKM());
                     khuyemai.setStrMaKM(kh.getStrMaGiay());
                     khuyemai.setStrMaKM(kh.getStrMaKM());
                break;
                }
            }
        }
        
        return false;
    }
    
    public ArrayList<ChiTietKMDTO> timKiem_MaSP(String strMaSP1, String strMaSP2) {
        ArrayList<ChiTietKMDTO> arr = new ArrayList<>();
        
        Collections.sort(this.list_KM, ChiTietKMDTO::maSPTangdan);

        int flag = 0;
        if (strMaSP1.equals(strMaSP2))
            for (ChiTietKMDTO hoadon : list_KM) {
                if ( hoadon.getStrMaGiay().indexOf(strMaSP1) != -1 ) {
                    arr.add(hoadon);
                    System.out.println("Tim thay SP1" + hoadon.getStrMaKM() );
                }
            }
        else    
            for (ChiTietKMDTO hoadon : list_KM) {
                if ( hoadon.getStrMaGiay().indexOf(strMaSP1) != -1 ) {
                    flag = 1;
                    System.out.println("Tim thay SP1" + hoadon.getStrMaKM() );
                }
                if ( hoadon.getStrMaGiay().indexOf(strMaSP2) != -1 ) {
                    flag = 2;
                    System.out.println("Tim thay SP2" + hoadon.getStrMaKM() );
                }
                
                if ( flag == 2 )
                    if ( hoadon.getStrMaGiay().indexOf(strMaSP2) == -1 )
                        break;
                
                if ( flag == 1 || flag == 2 )
                    arr.add(hoadon);
                
            }
        
        return arr;
    }
    
    public ArrayList<ChiTietKMDTO> timKiem_TiLeKM(double SL1, double SL2) {
        ArrayList<ChiTietKMDTO> arr = new ArrayList<>();
        for (ChiTietKMDTO hoadon : list_KM) {
            if ( hoadon.getTiLeKM()>= SL1 && hoadon.getTiLeKM()<= SL2) {
                System.out.println("Tim thay " + hoadon.getStrMaKM() );
                arr.add(hoadon);
            }
        }
        return arr;
    }
    
}
