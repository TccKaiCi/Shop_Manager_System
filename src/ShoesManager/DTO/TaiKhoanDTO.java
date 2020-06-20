package ShoesManager.DTO;

/**
 * Primary Key: <h4>TenDangNhap</h4> là thuộc tính duy nhất và khác null
 */
public class TaiKhoanDTO {
    private String strTenDangNhap;
    private String strMatKhau;
    private int iCapBac;
    
    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String strTenDangNhap, String strMatKhau, int iCapBac) {
        this.strTenDangNhap = strTenDangNhap;
        this.strMatKhau = strMatKhau;
        this.iCapBac = iCapBac;
    }

    public String getStrTenDangNhap() {
        return strTenDangNhap;
    }

    public void setStrTenDangNhap(String strTenDangNhap) {
        this.strTenDangNhap = strTenDangNhap;
    }

    public String getStrMatKhau() {
        return strMatKhau;
    }

    public void setStrMatKhau(String strMatKhau) {
        this.strMatKhau = strMatKhau;
    }

    public int getiCapBac() {
        return iCapBac;
    }

    public void setiCapBac(int iCapBac) {
        this.iCapBac = iCapBac;
    }
  
}
