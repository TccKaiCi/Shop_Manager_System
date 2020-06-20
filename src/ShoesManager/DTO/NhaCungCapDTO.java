package ShoesManager.DTO;

public class NhaCungCapDTO {
    String strMaNCC, strTeNCC, strDiaChi, strEmail;

    public NhaCungCapDTO() {
    }

    public NhaCungCapDTO(String strMaNCC, String strTeNCC, String strDiaChi, String strEmail) {
        this.strMaNCC = strMaNCC;
        this.strTeNCC = strTeNCC;
        this.strDiaChi = strDiaChi;
        this.strEmail = strEmail;
    }

    public String getStrMaNCC() {
        return strMaNCC;
    }

    public void setStrMaNCC(String strMaNCC) {
        this.strMaNCC = strMaNCC;
    }

    public String getStrTeNCC() {
        return strTeNCC;
    }

    public void setStrTeNCC(String strTeNCC) {
        this.strTeNCC = strTeNCC;
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

    @Override
    public String toString() {
        return "NhaCungCapDTO{" + "strMaNCC=" + strMaNCC + ", strTeNCC=" + strTeNCC + ", strDiaChi=" + strDiaChi + ", strEmail=" + strEmail + '}';
    }
    
    
    
}
