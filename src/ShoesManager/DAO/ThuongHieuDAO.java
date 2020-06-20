/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.DAO;

import ShoesManager.DTO.ThuongHieuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ThuongHieuDAO {
    MyConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<ThuongHieuDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("tblthuonghieu", condition, orderBy);
        ArrayList<ThuongHieuDTO> thuonghieus = new ArrayList<>();
        while ( result.next() ) {
            ThuongHieuDTO thuonghieu = new ThuongHieuDTO();
            thuonghieu.setStrMathuonghieu(result.getString("Mathuonghieu"));
            thuonghieu.setStrTenthuonghieu(result.getString("Tenthuonghieu"));
            thuonghieu.setStrDiachi(result.getString("Diachi"));
            thuonghieu.setStrEmail(result.getString("Email"));
            thuonghieus.add(thuonghieu);
        }
        connect.Close();
        return thuonghieus;
    }
    
    public ArrayList<ThuongHieuDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<ThuongHieuDTO> docDB() throws Exception {
        return docDB(null);
    }
    
}
