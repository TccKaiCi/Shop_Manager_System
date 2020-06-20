/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.BUS;

import ShoesManager.DAO.ThuongHieuDAO;
import ShoesManager.DTO.ThuongHieuDTO;
import java.util.ArrayList;

public class ThuongHieuBUS {
    private ArrayList <ThuongHieuDTO> list_ThuongHieu;
     /**
     * Xử lý các lệnh trong SQL
     */
    private ThuongHieuDAO THDAO;
    
    public ThuongHieuBUS() throws Exception {
        list_ThuongHieu = new ArrayList<>();
        THDAO = new ThuongHieuDAO();
        list_ThuongHieu = THDAO.docDB();
    }

    public ArrayList<ThuongHieuDTO> getList_ThuongHieu() {
        return list_ThuongHieu;
    }

    public void setList_ThuongHieu(ArrayList<ThuongHieuDTO> list_ThuongHieu) {
        this.list_ThuongHieu = list_ThuongHieu;
    }
    public int getNumbThuongHieu() {
        return list_ThuongHieu.size();
    }
}
    