package ShoesManager.DTO;

public class KhachHangDTO {
    private String strMaKH, strHo, strTen, strGioiTinh, strDiaChi,
            strEmail, strLoai;
    private double TongChiTieu;

    public KhachHangDTO() {
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "strMaKH=" + strMaKH + ", strHo=" + strHo + ", strTen=" + strTen + ", strGioiTinh=" + strGioiTinh + ", strDiaChi=" + strDiaChi + ", strEmail=" + strEmail + ", strLoai=" + strLoai + ", TongChiTieu=" + TongChiTieu + '}';
    }
    
    public KhachHangDTO(String strMaKH, String strHo, String strTen, String strGioiTinh, String strDiaChi, String strEmail, String strLoai, double iTongChiTieu) {
        this.strMaKH = strMaKH;
        this.strHo = strHo;
        this.strTen = strTen;
        this.strGioiTinh = strGioiTinh;
        this.strDiaChi = strDiaChi;
        this.strEmail = strEmail;
        this.strLoai = strLoai;
        this.TongChiTieu = iTongChiTieu;
    }
    
    public String getStrMaKH() {
        return strMaKH;
    }

    public void setStrMaKH(String strMaKH) {
        this.strMaKH = strMaKH;
    }

    public String getStrHo() {
        return strHo;
    }

    public void setStrHo(String strHo) {
        this.strHo = strHo;
    }

    public String getStrTen() {
        return strTen;
    }

    public void setStrTen(String strTen) {
        this.strTen = strTen;
    }

    public String getStrGioiTinh() {
        return strGioiTinh;
    }

    public void setStrGioiTinh(String strGioiTinh) {
        this.strGioiTinh = strGioiTinh;
    }

    public String getStrDiaChi() {
        return strDiaChi;
    }

    public void setStrDiaChi(String strDiaChi) {
        this.strDiaChi = strDiaChi;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrLoai() {
        return strLoai;
    }

    public void setStrLoai(String strLoai) {
        this.strLoai = strLoai;
    }

    public double getiTongChiTieu() {
        return TongChiTieu;
    }

    public void setiTongChiTieu(double iTongChiTieu) {
        this.TongChiTieu = iTongChiTieu;
    }
    
}
