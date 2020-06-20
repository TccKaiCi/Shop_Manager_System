/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DTO;

public class ThuongHieuDTO {
    private String strMathuonghieu,strTenthuonghieu,strDiachi,strEmail;
    public ThuongHieuDTO(){
    }
    public ThuongHieuDTO(String strMathuonghieu,String strTenthuonghieu,String strDiachi,String strEmail){
        this.strMathuonghieu=strMathuonghieu;
        this.strTenthuonghieu=strTenthuonghieu;
        this.strDiachi=strDiachi;
        this.strEmail=strEmail;
    }

    public String getStrMathuonghieu() {
        return strMathuonghieu;
    }

    public void setStrMathuonghieu(String strMathuonghieu) {
        this.strMathuonghieu = strMathuonghieu;
    }

    public String getStrTenthuonghieu() {
        return strTenthuonghieu;
    }

    public void setStrTenthuonghieu(String strTenthuonghieu) {
        this.strTenthuonghieu = strTenthuonghieu;
    }

    public String getStrDiachi() {
        return strDiachi;
    }

    public void setStrDiachi(String strDiachi) {
        this.strDiachi = strDiachi;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }
    
}

