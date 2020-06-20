/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.BUS;

import ShoesManager.DAO.MauSacDAO;
import ShoesManager.DTO.MauSacDTO;
import java.util.ArrayList;

public class MauSacBUS {
    private ArrayList <MauSacDTO> list_MauSac;
     /**
     * Xử lý các lệnh trong SQL
     */
    private MauSacDAO MSDAO;
    
    public MauSacBUS() throws Exception {
        list_MauSac = new ArrayList<>();
        MSDAO = new MauSacDAO();
        list_MauSac = MSDAO.docDB();
    }

    public ArrayList<MauSacDTO> getList_MauSac() {
        return list_MauSac;
    }

    public void setList_MauSac(ArrayList<MauSacDTO> list_MauSac) {
        this.list_MauSac = list_MauSac;
    }
    public int getNumbMauSac() {
        return list_MauSac.size();
    }
}
    