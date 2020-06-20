package ShoesManager.BUS;

import ShoesManager.DAO.HoaDonDAO;
import ShoesManager.DTO.HoaDonDTO;
import java.util.ArrayList;
import java.util.Collections;

public class HoaDonBUS {
    private ArrayList<HoaDonDTO> list_HD;
    /**
     * Xử lý các lệnh trong SQL
     */
    private HoaDonDAO hdDAO;
    
    public void docDB() throws Exception{
        list_HD = new ArrayList<>();
        hdDAO = new HoaDonDAO();
        list_HD = hdDAO.docDB();
        
    }
    
    public HoaDonBUS() throws Exception {
        list_HD = new ArrayList<>();
        hdDAO = new HoaDonDAO();
        list_HD = hdDAO.docDB();
    }

    public void add(HoaDonDTO hd) {
        list_HD.add(hd);
    }
    
    public void deleteAll() {
        list_HD.removeAll(list_HD);
    }
    
    public HoaDonDAO getHdDAO() {
        return hdDAO;
    }

    public void setHdDAO(HoaDonDAO hdDAO) {
        this.hdDAO = hdDAO;
    }
    
    public int getNumbHoaDon() {
        return list_HD.size();
    }
    
    public HoaDonDTO getInfor(int i){
        int iCount =0;
        for (HoaDonDTO hd : list_HD) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public HoaDonDTO getInfor(String strMaHD){
        for (HoaDonDTO hd : list_HD) {
            if (hd.getStrMaHD().equals(strMaHD))
                return hd;
        }
        HoaDonDTO hd = new HoaDonDTO();
        hd.setStrMaHD("null");
        return hd;
    }
    
    
    public String getMaKM(String MaHD) {
        for (HoaDonDTO hoadon : list_HD) {
            if (hoadon.getStrMaHD().equals(MaHD))
                return hoadon.getStrMaKM();
        }
        return "null";
    }
    
    public ArrayList<HoaDonDTO> timKiem_MaHD(String strMaHD,boolean sapxep) {
        ArrayList<HoaDonDTO> arr = new ArrayList<>();
        for (HoaDonDTO hoadon : list_HD) {
            if ( hoadon.getStrMaHD().indexOf(strMaHD) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaHD() );
                arr.add(hoadon);
            }
        }
        if(sapxep){
            Collections.sort(arr, HoaDonDTO::maHDTangdan);
        }
        else{
            Collections.sort(arr, HoaDonDTO::maHDGiamdan);
        }
        
        return arr;
    }
    
    public ArrayList<HoaDonDTO> timKiem_MaNV(String strMaNV,boolean sapxep) {
        ArrayList<HoaDonDTO> arr = new ArrayList<>();
        for (HoaDonDTO hoadon : list_HD) {
            if ( hoadon.getStrMaNV().indexOf(strMaNV) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaHD() );
                arr.add(hoadon);
            }
        }
        if(sapxep){
            Collections.sort(arr, HoaDonDTO::maNVTangdan);
        }
        else{
            Collections.sort(arr, HoaDonDTO::maNVGiamdan);
        }
        
        return arr;
    }
    
    public ArrayList<HoaDonDTO> timKiem_MaKH(String strMaKH,boolean sapxep) {
        ArrayList<HoaDonDTO> arr = new ArrayList<>();
        for (HoaDonDTO hoadon : list_HD) {
            if ( hoadon.getStrMaKH().indexOf(strMaKH) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaHD() );
                arr.add(hoadon);
            }
        }
        if(sapxep){
            Collections.sort(arr, HoaDonDTO::maKHTangdan);
        }
        else{
            Collections.sort(arr, HoaDonDTO::maKHGiamdan);
        }
        
        return arr;
    }
    
    public ArrayList<HoaDonDTO> timKiem_MaKM(String strMaKM,boolean sapxep) {
        ArrayList<HoaDonDTO> arr = new ArrayList<>();
        for (HoaDonDTO hoadon : list_HD) {
            if ( hoadon.getStrMaKM().indexOf(strMaKM) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaHD() );
                arr.add(hoadon);
            }
        }
        if(sapxep){
            Collections.sort(arr, HoaDonDTO::maKMTangdan);
        }
        else{
            Collections.sort(arr, HoaDonDTO::maKMGiamdan);
        }
        
        return arr;
    }
    
    public ArrayList<HoaDonDTO> timKiem_TongTien(String strTT,boolean sapxep) {
        ArrayList<HoaDonDTO> arr = new ArrayList<>();
        for (HoaDonDTO hoadon : list_HD) {
            if ( String.valueOf(hoadon.getTongTien()).indexOf(strTT) != -1 ) {
                System.out.println("Tim thay " + hoadon.getStrMaHD() );
                arr.add(hoadon);
            }
        }
        if(sapxep){
            Collections.sort(arr, HoaDonDTO::tongTienTangdan);
        }
        else{
            Collections.sort(arr, HoaDonDTO::tongTienGiamdan);
        }
        
        return arr;
    }
    
    public String getDefaultMaHD() {
        if (list_HD.size() == 0)
            return "HD001";
        else {
            String s = "HD";
            int iNumb  = 0;
            
            for (HoaDonDTO hoadon : list_HD) {
                String[] maHD = hoadon.getStrMaHD().split("HD");
                iNumb = Integer.parseInt( maHD[1] );
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
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    
    //-----------------------------------------------------------------------------------
    /**
     * thêm 1hóa đơn vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(HoaDonDTO hd) throws Exception{
        if ( hdDAO.them(hd) ) {
            list_HD.add(hd);
        }
        return false;
    }
    
    /**
     * xóa 1hóa đơn hdỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(HoaDonDTO hd) throws Exception {
        if ( hdDAO.xoa(hd) ) {
            
            // duyệt từng phẩn tử
            for ( HoaDonDTO hoadon : list_HD ) {
                if (hoadon.getStrMaHD().equals(hd.getStrMaHD())){
                    list_HD.remove(hoadon);
                break;
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
    public Boolean sua(HoaDonDTO hd) throws Exception {
        if ( hdDAO.sua(hd) ) {
            
            // duyệt từng phẩn tử
            for ( HoaDonDTO hoadon : list_HD ) {
                if (hoadon.getStrMaHD().equals(hd.getStrMaHD())){
                     hoadon.setStrMaHD(hd.getStrMaHD());
                     hoadon.setStrMaKH(hd.getStrMaKH());
                     hoadon.setStrMaKM(hd.getStrMaKM());
                     hoadon.setStrMaNV(hd.getStrMaNV());
                     hoadon.setStrNgayBan(hd.getStrNgayBan());
                     hoadon.setTongTien(hd.getTongTien());
                break;
                }
            }
        }
        
        return false;
    }

    public ArrayList<HoaDonDTO> getList_HD() {
        return list_HD;
    }

    public void setList_HD(ArrayList<HoaDonDTO> list_HD) {
        this.list_HD = list_HD;
    }
    
    
}
