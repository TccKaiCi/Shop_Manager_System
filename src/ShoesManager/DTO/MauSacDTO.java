/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DTO;

public class MauSacDTO {
    private String strMamau;
    private String strTenmau;
    public MauSacDTO(){    
    }
    public MauSacDTO(String strMamau,String strTenmau){
        this.strMamau=strMamau;
        this.strTenmau=strTenmau;
    }

    public String getStrMamau() {
        return strMamau;
    }

    public void setStrMamau(String strMamau) {
        this.strMamau = strMamau;
    }

    public String getStrTenmau() {
        return strTenmau;
    }

    public void setStrTenmau(String strTenmau) {
        this.strTenmau = strTenmau;
    }
    
}
