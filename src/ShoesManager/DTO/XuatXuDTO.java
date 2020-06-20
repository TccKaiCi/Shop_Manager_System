/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DTO;

public class XuatXuDTO {
    private String strMaxuatxu;
    private String strTennuoc;
    public XuatXuDTO(){
    }
    public XuatXuDTO(String strMaxuatxu,String strTennuoc){
        this.strMaxuatxu=strMaxuatxu;
        this.strTennuoc=strTennuoc;
    }

    public String getStrMaxuatxu() {
        return strMaxuatxu;
    }

    public void setStrMaxuatxu(String strMaxuatxu) {
        this.strMaxuatxu = strMaxuatxu;
    }

    public String getStrTennuoc() {
        return strTennuoc;
    }

    public void setStrTennuoc(String strTennuoc) {
        this.strTennuoc = strTennuoc;
    }
    
}
