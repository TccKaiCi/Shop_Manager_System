/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoesManager.GUI;

import ShoesManager.BUS.ChiTietHDBUS;
import ShoesManager.BUS.ChiTietKMBUS;
import ShoesManager.BUS.KhachHangBUS;
import ShoesManager.BUS.KhuyenMaiBUS;
import ShoesManager.BUS.SanPhamBUS;
import ShoesManager.DTO.ChiTietHDDTO;
import ShoesManager.DTO.ChiTietKMDTO;
import ShoesManager.DTO.HoaDonDTO;
import ShoesManager.DTO.KhachHangDTO;
import ShoesManager.DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class InHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form fPrintInHoaDon
     */
    public InHoaDon() {
        this.setUndecorated(true);
        
        initComponents();
        init();
    }
    
    private HoaDonDTO hoadon;
    private JLabel[] list_lbl;
    
    public InHoaDon(HoaDonDTO hoadon) {
        this.hoadon = hoadon;
        
        initComponents();
        init();
    }
    
    public void init() {
        KhachHangBUS bus = null;
        
        try {
            bus = new KhachHangBUS();
        } catch (Exception ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        KhachHangDTO dto = new KhachHangDTO();
        dto = bus.getInfor(hoadon.getStrMaKH());
        
        jLabelsophieunhap.setText("Mã hóa dơn: " + hoadon.getStrMaHD());
        jLabelnhanvien.setText(jLabelnhanvien.getText() + Memory.nhanvien.getStrHo() + " " +Memory.nhanvien.getStrTen());
        jLabelnhanvien1.setText(jLabelnhanvien1.getText() + dto.getStrHo() + " " +dto.getStrTen());
        jLabelthoigian.setText(jLabelthoigian.getText() + hoadon.getStrNgayBan());
        jLabelTenSP7.setText(jLabelTenSP7.getText() + String.valueOf(hoadon.getTongTien()));
        
    }

    private JPanel createPanel_CTHD() {
        JPanel panel = new JPanel();
        ChiTietHDBUS bus = null;
        SanPhamBUS spbus = null;
        ChiTietKMBUS kmbus = null;
        
        try {
            kmbus = new ChiTietKMBUS();
        } catch (Exception ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            spbus = new SanPhamBUS();
        } catch (Exception ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
             bus = new ChiTietHDBUS();
        } catch (Exception ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        panel.setLayout(null);
        int iNumbSP = 0;
        int toadox = 0, toadoy = 0;
        
        for (int i=0 ; i < bus.getNumbChiTietHD() ; i++) {
            ChiTietHDDTO dto = new ChiTietHDDTO();
            
            dto = bus.getInfor(i);
                    
            if (hoadon.getStrMaHD().equals(dto.getStrMaHD())) {
                SanPhamDTO sp = spbus.getInfor(dto.getStrMaGiay());
                ChiTietKMDTO km = kmbus.getInfor(dto.getStrMaGiay(), hoadon.getStrMaKM());
                JPanel p = createPanel_SP(dto, sp, km.getTiLeKM());
                iNumbSP++;
                p.setBounds(toadox, toadoy, 1050, 30);
                panel.add(p);
                toadoy += 30;
            }
        }
        
        panel.setSize(1050, 30 * iNumbSP);
        jPanel3.setSize(1050, 30 * iNumbSP);
        return panel;
    }
    
    private JPanel createPanel_SP(ChiTietHDDTO hd, SanPhamDTO sp, double tilekm) {
        JPanel panel = new JPanel();
        list_lbl = new JLabel[5];
        list_lbl[0] = new JLabel();
        list_lbl[1] = new JLabel();
        list_lbl[2] = new JLabel();
        list_lbl[3] = new JLabel();
        list_lbl[4] = new JLabel();
        
        panel.setLayout(null);
        
        System.out.println(sp.toString());
        System.out.println(hd.toString());
        
        list_lbl[0].setText(sp.getStrTenGiay());
        list_lbl[1].setText(String.valueOf(hd.getiSoLuong()));
        list_lbl[2].setText(String.valueOf(sp.getiGia()) + " đồng");
        list_lbl[3].setText((tilekm * 100) + "%");
        
        double giatien = Integer.valueOf(hd.getiSoLuong()) 
                * Integer.valueOf(hd.getiGiaBan())
                * (1 - tilekm);
        list_lbl[4].setText(String.valueOf(giatien));
        
        list_lbl[0].setBounds(  0, 0, 270, 30);
        list_lbl[1].setBounds(280, 0, 100, 30);
        list_lbl[2].setBounds(400, 0, 150, 30);
        list_lbl[3].setBounds(600, 0, 100, 30);
        list_lbl[4].setBounds(750, 0, 200, 30);
        
        list_lbl[0].setFont(new Font("Arial", Font.PLAIN, 20));
        list_lbl[1].setFont(new Font("Arial", Font.PLAIN, 20));
        list_lbl[2].setFont(new Font("Arial", Font.PLAIN, 20));
        list_lbl[3].setFont(new Font("Arial", Font.PLAIN, 20));
        list_lbl[4].setFont(new Font("Arial", Font.PLAIN, 20));
        
        list_lbl[0].setBackground(new Color(255,255,255));
        list_lbl[1].setBackground(new Color(255,255,255));
        list_lbl[2].setBackground(new Color(255,255,255));
        list_lbl[3].setBackground(new Color(255,255,255));
        list_lbl[4].setBackground(new Color(255,255,255));
        
        panel.add(list_lbl[0]);
        panel.add(list_lbl[1]);
        panel.add(list_lbl[2]);
        panel.add(list_lbl[3]);
        panel.add(list_lbl[4]);
        
        panel.setBackground(new Color(255,255,255));
        return panel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelsophieunhap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelnhanvien = new javax.swing.JLabel();
        jLabelthoigian = new javax.swing.JLabel();
        jLabelnhanvien1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelControl = new javax.swing.JPanel();
        jButtonPrint = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTenSP = new javax.swing.JLabel();
        jLabelTenSP1 = new javax.swing.JLabel();
        jLabelTenSP2 = new javax.swing.JLabel();
        jLabelTenSP3 = new javax.swing.JLabel();
        jLabelTenSP4 = new javax.swing.JLabel();
        jPanel5 = createPanel_CTHD();
        jPanel4 = new javax.swing.JPanel();
        jLabelTenSP7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("In Thông Tin Phiếu Nhập");
        setResizable(false);

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jLabelsophieunhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelsophieunhap.setText("Mã hóa đon:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel9.setText("Cửa hàng giày");

        jLabelnhanvien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelnhanvien.setText("Nhân viên:");

        jLabelthoigian.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelthoigian.setText("Thời gian :");

        jLabelnhanvien1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelnhanvien1.setText("Khách Hàng:");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addGap(0, 434, Short.MAX_VALUE)
                        .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(48, 48, 48)))
                        .addGap(162, 162, 162)))
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelthoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelsophieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelnhanvien1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabelsophieunhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelnhanvien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelnhanvien1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelthoigian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanelControl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPrint.setText("In");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jButtonThoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlLayout = new javax.swing.GroupLayout(jPanelControl);
        jPanelControl.setLayout(jPanelControlLayout);
        jPanelControlLayout.setHorizontalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelControlLayout.setVerticalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrint)
                    .addComponent(jButtonThoat))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sản Phẩm");

        jLabelTenSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSP.setText("Tên :");

        jLabelTenSP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSP1.setText("Số Lượng:");

        jLabelTenSP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSP2.setText("Giá:");

        jLabelTenSP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSP3.setText("Thành tiền:");

        jLabelTenSP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSP4.setText("Tỉ lệ khuyến mãi:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTenSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTenSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTenSP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelTenSP)
                    .addComponent(jLabelTenSP1)
                    .addComponent(jLabelTenSP2)
                    .addComponent(jLabelTenSP3)
                    .addComponent(jLabelTenSP4))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTenSP7.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabelTenSP7.setText("Tổng tiền:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTenSP7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTenSP7))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        jPanelControl.setVisible(false);
        try
        {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            this.paint(graphics2D);
            ImageIO.write(image,"png", new File("./src/ShoesManager/In ấn/hoadon_" 
                    + hoadon.getStrMaHD() + "_" +hoadon.getStrNgayBan()+".png"));
        }
        catch(Exception exception)
        {
        }
        KhachHangBUS khbus = null;
        KhachHangDTO dtokh;
        try {
            khbus =new KhachHangBUS();
        } catch (Exception ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        dtokh = khbus.getInfor(hoadon.getStrMaKH());
        dtokh.setiTongChiTieu(hoadon.getTongTien() + dtokh.getiTongChiTieu());
        try {
            khbus.sua(dtokh);
        } catch (Exception ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        //dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTenSP;
    private javax.swing.JLabel jLabelTenSP1;
    private javax.swing.JLabel jLabelTenSP2;
    private javax.swing.JLabel jLabelTenSP3;
    private javax.swing.JLabel jLabelTenSP4;
    private javax.swing.JLabel jLabelTenSP7;
    private javax.swing.JLabel jLabelnhanvien;
    private javax.swing.JLabel jLabelnhanvien1;
    private javax.swing.JLabel jLabelsophieunhap;
    private javax.swing.JLabel jLabelthoigian;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
