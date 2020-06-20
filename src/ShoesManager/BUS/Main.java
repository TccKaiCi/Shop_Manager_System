package ShoesManager.BUS;

import ShoesManager.DAO.PhieuNhapDAO;
import ShoesManager.DTO.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println(java.time.LocalDateTime.now().getMonth());
//        System.out.println(java.time.LocalDateTime.now().getYear());
//        System.out.println(java.time.LocalDateTime.now().getDayOfMonth());
        
//        PhieuNhapBUS bus = new PhieuNhapBUS();
//        PhieuNhapDTO dto = new PhieuNhapDTO("KH6", "Trần", "An", "Nữ", "Cầu giấy", "123@gmail.com", "bình thường", 321);
//        System.out.println(bus.xoa(dto));
        
//        PhieuNhapBUS bus = new PhieuNhapBUS();
//        PhieuNhapDTO dto = new PhieuNhapDTO("PN6", "a", "a", "a", "a", "a");
//        System.out.println(bus.xoa(dto));
//
//        HoaDonBUS bus = new HoaDonBUS();
//        ArrayList<HoaDonDTO> list_HD = bus.getList_KH();
//        HoaDonDTO hd = new HoaDonDTO();
//        hd.setStrMaHD("HD");
//        
//        for ( HoaDonDTO hoadon : list_HD ) {
//            System.out.println(hoadon.getStrMaHD().indexOf(hd.getStrMaHD()));
//        }
        
//        System.out.println( list_HD.indexOf() );
        
//        ChiTietHDBUS bus = new ChiTietHDBUS();
//        ArrayList<ChiTietHDDTO> list_HD = bus.getList_HD();
//        
//        for ( ChiTietHDDTO hoadon : list_HD ) {
//            System.out.println(hoadon.getStrMaHD().indexOf(hoadon.getStrMaHD()));
//        }
//
//        PhieuNhapBUS bus =new PhieuNhapBUS();
//        ArrayList<PhieuNhapDTO> arr =bus.getList_TK();
//        for (PhieuNhapDTO dto : arr) {
//            System.out.println(dto.toString());
//        }
//    
//        String Date1 = "12 Sep 2019";
//        String Date2 = "12 May 2019";
//        
//        String[] s1 = Date1.split("\\ ");
//        String[] s2 = Date2.split("\\ ");
//        String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun",
//                                  "Jul","Aug","Sep","Oct","Nov","Dec"};
// 
//        if ( Integer.parseInt(s1[2]) > Integer.parseInt(s2[2])) 
//            System.out.println("lỗi năm");
//
//        int iThang1 = 0, iThang2 = 0;
//        for (int i=0 ; i < strMonths.length ; i++) {
//            if (strMonths[i].equals(s1[1]))
//                iThang1 = i;
//            if (strMonths[i].equals(s2[1]))
//                iThang2 = i;
//        }
//        
//        if ( iThang1 > iThang2 ) 
//            System.out.println("Lỗi tháng");
//        
//        if ( Integer.parseInt(s1[0]) > Integer.parseInt(s2[0])) 
//            System.out.println("lỗi ngày");
//
//            String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun",
//                                  "Jul","Aug","Sep","Oct","Nov","Dec"};
//            
//        for (int i=0 ; i < 11 ; i++) {
//            int iPos = LocalDateTime.now().getMonthValue();
//            String date = LocalDateTime.now().getDayOfMonth() + " " +
//                 strMonths[iPos-1] + " " +
//                LocalDateTime.now().getYear();
//            
//            System.out.println(date.toString());
//
//        }
            String s = "HD";
            int iNumb  = 0;
            String hoadon = "HD009";
                String[] maHD = hoadon.split("HD");
                iNumb = Integer.parseInt( maHD[1] );
                iNumb++;
                Main m =new Main();
            switch (m.demSoChuSo(iNumb)) {
                case 1:
                    s +="0";
                case 2:
                    s +="0";
                case 3:  
            }
                    
            s += iNumb;
            System.out.println(s + " ---- " + iNumb );
            
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
}
