package ShoesManager.DTO;

public class PhieuNhapDTO {
    String strMaPN, strMaNCC, strMaNV, strNgayNhap;
    double tongTien;

    public PhieuNhapDTO() {
    }

    
    
    public PhieuNhapDTO(String strMaPN, String strMaNCC, String strMaNV, String strNgayNhap, double tongTien) {
        this.strMaPN = strMaPN;
        this.strMaNCC = strMaNCC;
        this.strMaNV = strMaNV;
        this.strNgayNhap = strNgayNhap;
        this.tongTien = tongTien;
    }

    public String getStrMaPN() {
        return strMaPN;
    }

    public void setStrMaPN(String strMaPN) {
        this.strMaPN = strMaPN;
    }

    public String getStrMaNCC() {
        return strMaNCC;
    }

    public void setStrMaNCC(String strMaNCC) {
        this.strMaNCC = strMaNCC;
    }

    public String getStrMaNV() {
        return strMaNV;
    }

    public void setStrMaNV(String strMaNV) {
        this.strMaNV = strMaNV;
    }

    public String getStrNgayNhap() {
        return strNgayNhap;
    }

    public void setStrNgayNhap(String strNgayNhap) {
        this.strNgayNhap = strNgayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" + "strMaPN=" + strMaPN + ", strMaNCC=" + strMaNCC + ", strMaNV=" + strMaNV + ", strNgayNhap=" + strNgayNhap + ", tongTien=" + tongTien + '}';
    }
    
}
