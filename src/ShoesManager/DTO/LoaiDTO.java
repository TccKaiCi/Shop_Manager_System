/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DTO;

public class LoaiDTO {
    private String strMaloai;
    private String strTenloai;
    public LoaiDTO(){
    }
    public LoaiDTO(String strMaloai,String strTenloai){
        this.strMaloai=strMaloai;
        this.strTenloai=strTenloai;
    }

    public String getStrMaloai() {
        return strMaloai;
    }

    public void setStrMaloai(String strMaloai) {
        this.strMaloai = strMaloai;
    }

    public String getStrTenloai() {
        return strTenloai;
    }

    public void setStrTenloai(String strTenloai) {
        this.strTenloai = strTenloai;
    }
    
}
