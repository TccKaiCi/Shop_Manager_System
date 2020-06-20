/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DAO;

import ShoesManager.DTO.LoaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LoaiDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<LoaiDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblloai", condition, orderBy);
        ArrayList<LoaiDTO> loais = new ArrayList<>();
        while ( result.next() ) {
            LoaiDTO loai = new LoaiDTO();
            loai.setStrMaloai(result.getString("Maloai"));
            loai.setStrTenloai(result.getString("Tenloai"));
            loais.add(loai);
        }
        connect.Close();
        return loais;
    }
    
    public ArrayList<LoaiDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<LoaiDTO> docDB() throws Exception {
        return docDB(null);
    }
    
}
