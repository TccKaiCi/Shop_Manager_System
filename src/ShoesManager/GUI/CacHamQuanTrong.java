package ShoesManager.GUI;

public class CacHamQuanTrong {
    
    /**
     * Kiểm tra tham số truyền vào có phải là <h2>số</h2> hay không
     * @return true nếu là kiểu dữ liệu số Double
     */
    public boolean isNumeric(String var) {
        try {  
            Double.parseDouble(var);  
            return true;
        
        // return false when "var" can't be converted to double    
        // NumberFormatException will return null
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    /**
     * Kiểm tra tham số truyền vào là kiễu dữ liệu <h2>Số Nguyên</h2> hay không
     * @return true nếu là kiểu dữ liệu số nguyên
     */
    public boolean isInteger(String var) {
        try {  
            Integer.parseInt(var);  
            return true;
        
        // return false when "var" can't be converted to integer    
        // NumberFormatException will return null
        } catch(NumberFormatException e){  
            return false;  
        }
    }
    
    /**
     * Truyền String vào để kiểm tra dữ liệu
     * @return true nếu là dữ liệu số<br>
     * @return false nếu là liệu chuỗi
     */
    public boolean kiemTraDuLieuSo(String var) {
        if (isInteger(var))
            return true;
        
        javax.swing.JOptionPane.showMessageDialog(null, "Dữ liệu phải là số\nvd:123", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return false; 
    }
    
    /**
     * Kiểm tra xem ngày bắt đầu có lớn hơn ngày kết thúc hay không
     * @param Date1 ngày bắt đầu
     * @param Date2 ngày kết thúc
     * @return true nếu Date1 lớn hơn Date2
     */
    public boolean kiemTraDate(String Date1, String Date2) {
         String[] s1 = Date1.split("\\ ");
        String[] s2 = Date2.split("\\ ");
        String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun",
                                  "Jul","Aug","Sep","Oct","Nov","Dec"};
 
        if ( Integer.parseInt(s1[2]) > Integer.parseInt(s2[2])) {
            System.out.println("lỗi năm");
            return false;
        }

        int iThang1 = 0, iThang2 = 0;
        for (int i=0 ; i < strMonths.length ; i++) {
            if (strMonths[i].equals(s1[1]))
                iThang1 = i;
            if (strMonths[i].equals(s2[1]))
                iThang2 = i;
        }
        
        if ( iThang1 > iThang2 ) {
            System.out.println("Lỗi tháng");
            return false;
        }
        
        if ( Integer.parseInt(s1[0]) > Integer.parseInt(s2[0])) {
            System.out.println("lỗi ngày");
            return false;
        }
        return true;
    }
    public boolean kiemtrathang(String monthyear,String date1){
        String[] s1 = monthyear.split("\\ ");
        String[] s2 = date1.split("\\ ");
        String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun",
                                  "Jul","Aug","Sep","Oct","Nov","Dec"};
        if ( Integer.parseInt(s1[1]) != Integer.parseInt(s2[2])) {
            return false;
        }
        int iThang1 = 0, iThang2 = 0;
        for (int i=0 ; i < strMonths.length ; i++) {
            if (strMonths[i].equals(s1[0]))
                iThang1 = i;
            if (strMonths[i].equals(s2[1]))
                iThang2 = i;
        }
        
        if ( iThang1 != iThang2 ) {
            System.out.println("Lỗi tháng");
            return false;
        }
        return true;
        }
    public boolean kiemtranam(String year,String date1){
        
        String[] s2 = date1.split("\\ ");
        String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun",
                                  "Jul","Aug","Sep","Oct","Nov","Dec"};
        if ( Integer.parseInt(year) != Integer.parseInt(s2[2])) {
            return false;
        }
        
        return true;
        }
    }
    

