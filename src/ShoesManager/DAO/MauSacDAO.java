/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DAO;

import ShoesManager.DTO.MauSacDTO;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MauSacDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<MauSacDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblmausac", condition, orderBy);
        ArrayList<MauSacDTO> mausacs = new ArrayList<>();
        while ( result.next() ) {
            MauSacDTO mausac = new MauSacDTO();
            mausac.setStrMamau(result.getString("Mamau"));
            mausac.setStrTenmau(result.getString("Tenmau"));
            mausacs.add(mausac);
        }
        connect.Close();
        return mausacs;
    }
    
    public ArrayList<MauSacDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<MauSacDTO> docDB() throws Exception {
        return docDB(null);
    }
    
}
