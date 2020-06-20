package ShoesManager.DTO;

public class KhuyenMaiDTO {
    private String strMaKM, strTenChuongTrinh, strLoaiChuongTrinh,
            strDieuKien, strNgayBatDau, strNgayKetThuc;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String strMaKM, String strTenChuongTrinh, String strLoaiChuongTrinh, String strDieuKien, String strNgayBatDau, String strNgayKetThuc) {
        this.strMaKM = strMaKM;
        this.strTenChuongTrinh = strTenChuongTrinh;
        this.strLoaiChuongTrinh = strLoaiChuongTrinh;
        this.strDieuKien = strDieuKien;
        this.strNgayBatDau = strNgayBatDau;
        this.strNgayKetThuc = strNgayKetThuc;
    }

    @Override
    public String toString() {
        return "KhuyenMaiDTO{" + "strMaKM=" + strMaKM + ", strTenChuongTrinh=" + strTenChuongTrinh + ", strLoaiChuongTrinh=" + strLoaiChuongTrinh + ", strDieuKien=" + strDieuKien + ", strNgayBatDau=" + strNgayBatDau + ", strNgayKetThuc=" + strNgayKetThuc + '}';
    }

    public String getStrMaKM() {
        return strMaKM;
    }

    public void setStrMaKM(String strMaKM) {
        this.strMaKM = strMaKM;
    }

    public String getStrTenChuongTrinh() {
        return strTenChuongTrinh;
    }

    public void setStrTenChuongTrinh(String strTenChuongTrinh) {
        this.strTenChuongTrinh = strTenChuongTrinh;
    }

    public String getStrLoaiChuongTrinh() {
        return strLoaiChuongTrinh;
    }

    public void setStrLoaiChuongTrinh(String strLoaiChuongTrinh) {
        this.strLoaiChuongTrinh = strLoaiChuongTrinh;
    }

    public String getStrDieuKien() {
        return strDieuKien;
    }

    public void setStrDieuKien(String strDieuKien) {
        this.strDieuKien = strDieuKien;
    }

    public String getStrNgayBatDau() {
        return strNgayBatDau;
    }

    public void setStrNgayBatDau(String strNgayBatDau) {
        this.strNgayBatDau = strNgayBatDau;
    }

    public String getStrNgayKetThuc() {
        return strNgayKetThuc;
    }

    public void setStrNgayKetThuc(String strNgayKetThuc) {
        this.strNgayKetThuc = strNgayKetThuc;
    }
    
    
}
