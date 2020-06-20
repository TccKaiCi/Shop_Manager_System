package ShoesManager.GUI;

import ShoesManager.BUS.NhanVienBUS;
import ShoesManager.DTO.NhanVienDTO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.MatteBorder;

public class Home extends JFrame{

    public Home() throws Exception {
        init();
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
    }
    
    int x_Mouse, y_Mouse;
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
         x_Mouse = evt.getX();
         y_Mouse = evt.getY();
    }                                 

    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        setLocation(x - x_Mouse, y - y_Mouse);
    }  
    
    public void init() throws Exception {
        // JFrame
        this.setUndecorated(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (Memory.iCapBac == 1)
            this.setSize(1280, 540);
        else 
            this.setSize(1280, 340);
        this.setLayout(new BorderLayout());  
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        list_nv = new NhanVienBUS();
        nhanvien = list_nv.getNhanVien_MaNV(Memory.maNV);
        Memory.nhanvien = nhanvien;
        
        border= new MatteBorder(1, 1, 1, 1, Color.black);
        pnTop = new JPanel();
        colorText = Memory.colorText;
        colorPanel_Top = Memory.colorThemes;
        colorPanel_Bot = Memory.colorThemes_2;
        fontNormal = new Font("Serif", Font.PLAIN, 40);
        fontLogout = new Font("Serif", Font.ITALIC, 40);
        lblAva = new JLabel();
        Color color = new Color(0,0,0);
        if ( Memory.colorThemes.getRGB() == color.getRGB())
            lblLogout = new JLabel(new ImageIcon("./src/ShoesManager/images/Thoat trang.png"));
        else
            lblLogout = new JLabel(new ImageIcon("./src/ShoesManager/images/Thoat den.png"));
            
        lblMaNV = new JLabel("ID:" + nhanvien.getstrMaNV());
        lblHoten = new JLabel("Họ Tên:" + nhanvien.getStrHo() 
                + " " + nhanvien.getStrTen());
        lblRole = new JLabel("Chức vụ:" + nhanvien.getStrChucVu());
        pnCenter_Btn = new JPanel();
        
        
        lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        imgAva = new ImageIcon("./src/ShoesManager/images/Avatar/130_100/" + 
                nhanvien.getStrAnh() + ".png");

      
        //-----------panelTop--------------
        pnTop.setBackground(colorPanel_Top);
        pnTop.setPreferredSize(new Dimension(0, 120));
        pnTop.setLayout(null);
        
        lblAva.setIcon(imgAva);
        lblMaNV.setFont(fontNormal);
        lblHoten.setFont(fontNormal);
        lblRole.setFont(fontNormal);
        lblLogout.setFont(fontLogout);
       
        pnTop.add(lblAva);
        pnTop.add(lblMaNV);
        pnTop.add(lblHoten);
        pnTop.add(lblRole);
        pnTop.add(lblLogout);
        
        lblMaNV.setForeground(colorText);
        lblRole.setForeground(colorText);
        lblHoten.setForeground(colorText);
        
        lblAva.setBounds(20, 10, 130, 100);
        lblMaNV.setBounds(180, 20, 200, 40);
        lblRole.setBounds(400, 20, 900, 45);
        lblHoten.setBounds(180, 70, 900, 50);
        lblLogout.setBounds(1130, 20, 100, 100);
        lblLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Login lg = new Login();
                    setVisible(false);
                    lg.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        lblAva.setBackground(Color.BLUE);
        this.add(pnTop, BorderLayout.NORTH);
        
        //------------panelBottom------------------
        pnBottom = new JPanel();
        pnBottom.setBackground(colorPanel_Bot);
        pnBottom.setLayout(null);
        lblHoadon = new JLabel();
        lblKhuyenmai = new JLabel();
        lblHanghoa = new JLabel();
        lblNhaphang = new JLabel();
        lblThongke = new JLabel();
        lblXuatexcel = new JLabel();
        //--------------img
        lblHoadon.setBounds(135, 150, 303, 131);
        lblHoadon.setIcon(new ImageIcon("./src/ShoesManager/images/bill.png"));
        lblKhuyenmai.setBounds(488, 150, 303, 131);
        lblKhuyenmai.setIcon(new ImageIcon("./src/ShoesManager/images/currency.png"));
        lblHanghoa.setBounds(841, 150, 303, 131);
        lblHanghoa.setIcon(new ImageIcon("./src/ShoesManager/images/goods.png"));
        lblNhaphang.setBounds(135, 331, 303, 131);
        lblNhaphang.setIcon(new ImageIcon("./src/ShoesManager/images/import.png"));
        lblThongke.setBounds(488, 331, 303, 131);
        lblThongke.setIcon(new ImageIcon("./src/ShoesManager/images/statis.png"));
        lblXuatexcel.setBounds(841, 331, 303, 131);
        lblXuatexcel.setIcon(new ImageIcon("./src/ShoesManager/images/excel.png"));
        lblHoadon.setBorder(border);
        lblKhuyenmai.setBorder(border);
        lblHanghoa.setBorder(border);
        lblNhaphang.setBorder(border);
        lblThongke.setBorder(border);
        lblXuatexcel.setBorder(border);
        //--------------mouseAction
        lblHoadon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                
            }
            @Override
            public void mousePressed(MouseEvent me) {
                lblHoadon.setIcon(new ImageIcon("./src/ShoesManager/images/bill2.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                lblHoadon.setIcon(new ImageIcon("./src/ShoesManager/images/bill1.png"));
                HoaDon hd;
                try {
                    hd = new HoaDon();
                    hd.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                lblHoadon.setIcon(new ImageIcon("./src/ShoesManager/images/bill1.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                lblHoadon.setIcon(new ImageIcon("./src/ShoesManager/images/bill.png"));
            }
});
        lblNhaphang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    PhieuNhap a = new PhieuNhap();
                    a.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mousePressed(MouseEvent me) {
                lblNhaphang.setIcon(new ImageIcon("./src/ShoesManager/images/import2.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                lblNhaphang.setIcon(new ImageIcon("./src/ShoesManager/images/import1.png"));
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                lblNhaphang.setIcon(new ImageIcon("./src/ShoesManager/images/import1.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                lblNhaphang.setIcon(new ImageIcon("./src/ShoesManager/images/import.png"));
            }
});
        lblKhuyenmai.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                KhuyenMai dm;
                try {
                    dm = new KhuyenMai();
                    dm.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mousePressed(MouseEvent me) {
                lblKhuyenmai.setIcon(new ImageIcon("./src/ShoesManager/images/currency2.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                lblKhuyenmai.setIcon(new ImageIcon("./src/ShoesManager/images/currency1.png"));
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                lblKhuyenmai.setIcon(new ImageIcon("./src/ShoesManager/images/currency1.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                lblKhuyenmai.setIcon(new ImageIcon("./src/ShoesManager/images/currency.png"));
            }
});
        lblHanghoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    Sanpham sp = new Sanpham();
                    sp.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mousePressed(MouseEvent me) {
                lblHanghoa.setIcon(new ImageIcon("./src/ShoesManager/images/goods2.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                lblHanghoa.setIcon(new ImageIcon("./src/ShoesManager/images/goods1.png"));
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                lblHanghoa.setIcon(new ImageIcon("./src/ShoesManager/images/goods1.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                lblHanghoa.setIcon(new ImageIcon("./src/ShoesManager/images/goods.png"));
            }
});
        lblThongke.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }
            @Override
            public void mousePressed(MouseEvent me) {
                ThongKe tk;
                try {
                    tk = new ThongKe();
                    
                tk.setVisible(true);
                setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                lblThongke.setIcon(new ImageIcon("./src/ShoesManager/images/statis1.png"));
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                lblThongke.setIcon(new ImageIcon("./src/ShoesManager/images/statis1.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                lblThongke.setIcon(new ImageIcon("./src/ShoesManager/images/statis.png"));
            }
});
        lblXuatexcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Excel dm = new Excel();
                dm.setVisible(true);
                setVisible(false);
                lblKhuyenmai.setIcon(new ImageIcon("./src/ShoesManager/images/excel2.png"));
            }
            @Override
            public void mousePressed(MouseEvent me) {
                lblXuatexcel.setIcon(new ImageIcon("./src/ShoesManager/images/excel2.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                lblXuatexcel.setIcon(new ImageIcon("./src/ShoesManager/images/excel1.png"));
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                lblXuatexcel.setIcon(new ImageIcon("./src/ShoesManager/images/excel1.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                lblXuatexcel.setIcon(new ImageIcon("./src/ShoesManager/images/excel.png"));
            }
});
        //rgb(243, 104, 224) 1
        //rgb(232, 67, 147) 2
        
        pnBottom.add(pnCenter_Btn);
        
        pnCenter_Btn.setBounds(20, 0, 1200, 400);
        pnCenter_Btn.setBackground(colorPanel_Bot);
        pnCenter_Btn.setLayout(new FlowLayout(0 , 80 , 50));
        
        
        this.add(pnBottom);
        
        kiemTraCapBac();
        //------------------End-----------------------------
    }
    
    /**
     * Hàm kiểm tra xem cập bậc của nó 
     * 1 : Admin FULL POWER
     * 2 : Nhập xuất file Excel và Thống Kê
     * 3 : Kiểm tra hàng hóa
     * 4 : Nhập Hàng
     * 5 : Khuyến mãi
     * 6 : Hóa đơn
     */
    public void kiemTraCapBac(){
        // truyền tham số cấp bậc chức vụ vào
        int iKey = Memory.iCapBac;
        
        switch (iKey) {
            case 1:
                pnCenter_Btn.add(lblHoadon);
                pnCenter_Btn.add(lblKhuyenmai);
                pnCenter_Btn.add(lblNhaphang);
                pnCenter_Btn.add(lblHanghoa);
                pnCenter_Btn.add(lblThongke);
                pnCenter_Btn.add(lblXuatexcel);
                break;
            case 2:
                pnCenter_Btn.add(lblThongke);
                pnCenter_Btn.add(lblXuatexcel);
                break;
            case 3:
                pnCenter_Btn.add(lblHanghoa);
                break;
            case 4:
                pnCenter_Btn.add(lblNhaphang);
                break;
            case 5:
                pnCenter_Btn.add(lblKhuyenmai);
                break;
            case 6:
                pnCenter_Btn.add(lblHoadon);
                break;
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        new Home().setVisible(true);
    }
    
    private NhanVienBUS list_nv;
    private NhanVienDTO nhanvien;
    private JPanel pnTop,pnBottom,pnCenter_Btn;
    private JLabel lblAva,lblMaNV,lblRole,lblHoten,lblLogout;
    private JLabel lblHoadon,lblKhuyenmai,lblHanghoa,lblNhaphang,lblXuatexcel, lblThongke; 
    private Color colorPanel_Top, colorPanel_Bot, colorText;
    private ImageIcon imgAva;
    private Font fontNormal, fontLogout;
    private MatteBorder border;
}
