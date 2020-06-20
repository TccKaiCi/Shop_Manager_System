/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.BUS;

import ShoesManager.DAO.LoaiDAO;
import ShoesManager.DTO.LoaiDTO;
import java.util.ArrayList;

public class LoaiBUS {
    private ArrayList <LoaiDTO> list_Loai;
     /**
     * Xử lý các lệnh trong SQL
     */
    private LoaiDAO LDAO;
    
    public LoaiBUS() throws Exception {
        list_Loai = new ArrayList<>();
        LDAO = new LoaiDAO();
        list_Loai = LDAO.docDB();
    }

    public ArrayList<LoaiDTO> getList_Loai() {
        return list_Loai;
    }

    public void setList_Loai(ArrayList<LoaiDTO> list_Loai) {
        this.list_Loai = list_Loai;
    }
    public int getNumbLoai() {
        return list_Loai.size();
    }
}
