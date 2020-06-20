package ShoesManager.DTO;

public class HoaDonDTO {
    private String strMaHD, strMaNV, strMaKH, strMaKM, strNgayBan;
    private double tongTien;
    
    public HoaDonDTO() {
    }

    public HoaDonDTO(String strMaHD, String strMaNV, String strMaKH, String strMaKM, String strNgayBan, double tongTien) {
        this.strMaHD = strMaHD;
        this.strMaNV = strMaNV;
        this.strMaKH = strMaKH;
        this.strMaKM = strMaKM;
        this.strNgayBan = strNgayBan;
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" + "strMaHD=" + strMaHD + ", strMaNV=" + strMaNV + ", strMaKH=" + strMaKH + ", strMaKM=" + strMaKM + ", strNgayBan=" + strNgayBan + ", tongTien=" + tongTien + '}';
    }

    
    public String getStrMaHD() {
        return strMaHD;
    }

    public void setStrMaHD(String strMaHD) {
        this.strMaHD = strMaHD;
    }

    public String getStrMaNV() {
        return strMaNV;
    }

    public void setStrMaNV(String strMaNV) {
        this.strMaNV = strMaNV;
    }

    public String getStrMaKH() {
        return strMaKH;
    }

    public void setStrMaKH(String strMaKH) {
        this.strMaKH = strMaKH;
    }

    public String getStrMaKM() {
        return strMaKM;
    }

    public void setStrMaKM(String strMaKM) {
        this.strMaKM = strMaKM;
    }

    public String getStrNgayBan() {
        return strNgayBan;
    }

    public void setStrNgayBan(String strNgayBan) {
        this.strNgayBan = strNgayBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    

    public static int maHDTangdan(HoaDonDTO a, HoaDonDTO b){
        return a.getStrMaHD().compareTo(b.getStrMaHD());
    }
    public static int maHDGiamdan(HoaDonDTO a, HoaDonDTO b){
        return b.getStrMaHD().compareTo(a.getStrMaHD());
    }
    
    public static int maKHTangdan(HoaDonDTO a, HoaDonDTO b){
        return a.getStrMaKH().compareTo(b.getStrMaKH());
    }
    public static int maKHGiamdan(HoaDonDTO a, HoaDonDTO b){
        return b.getStrMaKH().compareTo(a.getStrMaKH());
    }
    
    public static int maKMTangdan(HoaDonDTO a, HoaDonDTO b){
        return a.getStrMaKM().compareTo(b.getStrMaKM());
    }
    public static int maKMGiamdan(HoaDonDTO a, HoaDonDTO b){
        return b.getStrMaKM().compareTo(a.getStrMaKM());
    }
    
    public static int maNVTangdan(HoaDonDTO a, HoaDonDTO b){
        return a.getStrMaNV().compareTo(b.getStrMaNV());
    }
    public static int maNVGiamdan(HoaDonDTO a, HoaDonDTO b){
        return b.getStrMaNV().compareTo(a.getStrMaNV());
    }
    
    public static int tongTienTangdan(HoaDonDTO a, HoaDonDTO b){
        if (a.getTongTien()< b.getTongTien()) {
            return -1;
        } 
        else {
            if (a.getTongTien() == a.getTongTien()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public static int tongTienGiamdan(HoaDonDTO a, HoaDonDTO b){
        if (a.getTongTien() > b.getTongTien()) {
                    return -1;
        } 
        else {
            if (a.getTongTien() == a.getTongTien()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}
