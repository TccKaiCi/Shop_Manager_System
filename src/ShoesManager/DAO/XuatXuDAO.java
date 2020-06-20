/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DAO;

import ShoesManager.DTO.LoaiDTO;
import ShoesManager.DTO.XuatXuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;


public class XuatXuDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<XuatXuDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblxuatxu", condition, orderBy);
        ArrayList<XuatXuDTO> xuatxus = new ArrayList<>();
        while ( result.next() ) {
            XuatXuDTO xuatxu = new XuatXuDTO();
            xuatxu.setStrMaxuatxu(result.getString("MaXX"));
            xuatxu.setStrTennuoc(result.getString("Tennuoc"));
            xuatxus.add(xuatxu);
        }
        connect.Close();
        return xuatxus;
    }
    
    public ArrayList<XuatXuDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<XuatXuDTO> docDB() throws Exception {
        return docDB(null);
    }
    
}
