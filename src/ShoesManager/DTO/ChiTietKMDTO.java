package ShoesManager.DTO;

public class ChiTietKMDTO {
    String strMaKM, strMaGiay;
    double TiLeKM;

    public String getStrMaKM() {
        return strMaKM;
    }

    public void setStrMaKM(String strMaKM) {
        this.strMaKM = strMaKM;
    }

    public String getStrMaGiay() {
        return strMaGiay;
    }

    public void setStrMaGiay(String strMaGiay) {
        this.strMaGiay = strMaGiay;
    }

    public double getTiLeKM() {
        return TiLeKM;
    }

    public void setTiLeKM(double TiLeKM) {
        this.TiLeKM = TiLeKM;
    }

    @Override
    public String toString() {
        return "ChiTietKMDTO{" + "strMaKM=" + strMaKM + ", strMaGiay=" + strMaGiay + ", TiLeKM=" + TiLeKM + '}';
    }

    public ChiTietKMDTO(String strMaKM, String strMaGiay, double TiLeKM) {
        this.strMaKM = strMaKM;
        this.strMaGiay = strMaGiay;
        this.TiLeKM = TiLeKM;
    }

    public ChiTietKMDTO() {
    }
    
    public static int maSPTangdan(ChiTietKMDTO a, ChiTietKMDTO b){
        return a.getStrMaGiay().compareTo(b.getStrMaGiay());
    }
    
}
