/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.BUS;

import ShoesManager.DAO.XuatXuDAO;
import ShoesManager.DTO.XuatXuDTO;
import java.util.ArrayList;

public class XuatXuBUS {
    private ArrayList <XuatXuDTO> list_XuatXu;
     /**
     * Xử lý các lệnh trong SQL
     */
    private XuatXuDAO XXDAO;
    
    public XuatXuBUS() throws Exception {
        list_XuatXu = new ArrayList<>();
        XXDAO = new XuatXuDAO();
        list_XuatXu = XXDAO.docDB();
    }

    public ArrayList<XuatXuDTO> getList_XuatXu() {
        return list_XuatXu;
    }

    public void setList_XuatXu(ArrayList<XuatXuDTO> list_XuatXu) {
        this.list_XuatXu = list_XuatXu;
    }

   
    public int getNumbXuatXu() {
        return list_XuatXu.size();
    }
}
