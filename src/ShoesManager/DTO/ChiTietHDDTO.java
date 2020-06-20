package ShoesManager.DTO;

public class ChiTietHDDTO {
    private String strMaGiay, strMaHD;
    private int iSoLuong, iGiaBan;
//    private 

    public ChiTietHDDTO() {
    }

    public ChiTietHDDTO(String strMaGiay, String strMaHD, int iSoLuong, int iGiaBan) {
        this.strMaGiay = strMaGiay;
        this.strMaHD = strMaHD;
        this.iSoLuong = iSoLuong;
        this.iGiaBan = iGiaBan;
    }

    @Override
    public String toString() {
        return "ChiTietHDDTO{" + "strMaGiay=" + strMaGiay + ", strMaHD=" + strMaHD + ", iSoLuong=" + iSoLuong + ", iGiaBan=" + iGiaBan + '}';
    }
    
    

    public String getStrMaGiay() {
        return strMaGiay;
    }

    public void setStrMaGiay(String strMaGiay) {
        this.strMaGiay = strMaGiay;
    }

    public String getStrMaHD() {
        return strMaHD;
    }

    public void setStrMaHD(String strMaHD) {
        this.strMaHD = strMaHD;
    }

    public int getiSoLuong() {
        return iSoLuong;
    }

    public void setiSoLuong(int iSoLuong) {
        this.iSoLuong = iSoLuong;
    }

    public int getiGiaBan() {
        return iGiaBan;
    }

    public void setiGiaBan(int iGiaBan) {
        this.iGiaBan = iGiaBan;
    }
    
    public static int maSPTangdan(ChiTietHDDTO a, ChiTietHDDTO b){
        return a.getStrMaGiay().compareTo(b.getStrMaGiay());
    }
    public static int maSPGiamdan(ChiTietHDDTO a, ChiTietHDDTO b){
        return b.getStrMaGiay().compareTo(a.getStrMaGiay());
    }
    
    public static int soLuongTangdan(ChiTietHDDTO a, ChiTietHDDTO b){
        if (a.getiSoLuong()< b.getiSoLuong()) {
            return -1;
        } 
        else {
            if (a.getiSoLuong() == a.getiSoLuong()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public static int soLuongGiamdan(ChiTietHDDTO a, ChiTietHDDTO b){
        if (a.getiSoLuong() > b.getiSoLuong()) {
            return -1;
        } 
        else {
            if (a.getiSoLuong() == a.getiSoLuong()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}
