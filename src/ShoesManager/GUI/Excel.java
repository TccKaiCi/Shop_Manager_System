package ShoesManager.GUI;

import ShoesManager.BUS.*;
import ShoesManager.DTO.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
 
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel extends javax.swing.JFrame  implements MouseListener{
    // data_HD to write file
    private Object[][] data_HD = { 
            { "MaHD", "MaNV", "MaKH","MaKM", "NgayBan", "TongTien" }
        };
    private Object[][] data_CTHD = { 
            { "MaHD", "MaGiay", "SoLuong","GiaBan" }
        };
    
    private Object[][] data_PN = { 
            { "MaPN", "MaNCC", "MaNV", "NgayNhap", "TongTien" }
        };
    private Object[][] data_CTPN = { 
            { "MaPN", "MaGiay", "SoLuong","GiaNhap" }
        };
 
    private HoaDonBUS list_HD;
    private PhieuNhapBUS list_PN;
    private ChiTietHDBUS list_CTHD;
    private ChiTietPNBUS list_CTPN;
    private DefaultTableModel model, modelChiTiet;
    
    // create and write new file *.xls
    private void writeFileExcel_HD() {
        WritableWorkbook workbook;
        // create workbook
        try {
            workbook = Workbook.createWorkbook(new File(Memory.filechoose));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("HoaDon", 0);
            WritableSheet sheet2 = workbook.createSheet("ChiTietHoaDon", 1);
            
            // row begin write data_HD
            int rowBegin = 0;
            int colBegin = 0;
 
            for (int row = rowBegin, i = 0; row < data_HD.length + rowBegin; row++, i++) {
                for (int col = colBegin, j = 0; col < data_HD[0].length + colBegin; col++, j++) {
                    Object obj = data_HD[i][j];
                    sheet1.addCell(new Label(col, row, (String) data_HD[i][j]));
                }
            }
            
            for (int row = rowBegin, i = 0; row < data_CTHD.length + rowBegin; row++, i++) {
                for (int col = colBegin, j = 0; col < data_CTHD[0].length + colBegin; col++, j++) {
                    Object obj = data_CTHD[i][j];
                    sheet2.addCell(new Label(col, row, (String) data_CTHD[i][j]));
                }
            }
            
            rowBegin = 1;
            
            for (int row = rowBegin, i = 0; row < list_HD.getNumbHoaDon() + rowBegin; row++, i++) {
                HoaDonDTO hd = new HoaDonDTO();
                hd = list_HD.getInfor(i);
                
                //string
                sheet1.addCell(new Label(0, row, hd.getStrMaHD() ));
                sheet1.addCell(new Label(1, row, hd.getStrMaNV()));
                sheet1.addCell(new Label(2, row, hd.getStrMaKH() ));
                sheet1.addCell(new Label(3, row, hd.getStrMaKM() ));
                sheet1.addCell(new Label(4, row, hd.getStrNgayBan() ));
                //double
                sheet1.addCell(new Label(5, row,String.valueOf(hd.getTongTien()) ));
            }
            
            for (int row = rowBegin, i = 0; row < list_CTHD.getNumbChiTietHD()+ rowBegin; row++, i++) {
                ChiTietHDDTO hd = new ChiTietHDDTO();
                hd = list_CTHD.getInfor(i);
                
                //string
                sheet2.addCell(new Label(0, row, hd.getStrMaHD() ));
                sheet2.addCell(new Label(1, row, hd.getStrMaGiay()));
                sheet2.addCell(new Label(2, row, String.valueOf(hd.getiSoLuong())));
                sheet2.addCell(new Label(3, row, String.valueOf(hd.getiGiaBan())));
            }
            
            
            
            // write file
            workbook.write();
 
            // close
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error create file\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("Error write file\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("Error write file\n" + e.toString());
        }
        System.out.println("create and write success");
    }
 
    // open and read file *.xls
    private void readFileExcel_HD() {
        list_HD.deleteAll();
        list_CTHD.deleteAll();
        
        Workbook workbook;
        try {
            // create workbook to open file
            workbook = Workbook.getWorkbook(new File(Memory.filechoose));
            // get sheet want read
            Sheet sheet = workbook.getSheet(0);
            Sheet sheet1 = workbook.getSheet(1);
            
            // hoa don
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            for (int row = 1; row < rows; row++) {
                String[] arr = new String[cols];
                for (int col = 0; col < cols; col++) {
                    Cell cell = sheet.getCell(col, row);
                    arr[col] = String.valueOf(cell.getContents());
                }
                HoaDonDTO hd = new HoaDonDTO();
                hd.setStrMaHD( arr[0] );
                hd.setStrMaNV(arr[1] );
                hd.setStrMaKH(arr[2] );
                hd.setStrMaKM(arr[3] );
                hd.setStrNgayBan(arr[4] );
                hd.setTongTien(Double.parseDouble(arr[5]) );
                list_HD.add(hd);
                System.out.println(hd.toString());
            }
            
            // chi tiet hoa don
            int rows1 = sheet1.getRows();
            int cols1 = sheet1.getColumns();
            for (int row = 1; row < rows1; row++) {
                String[] arr = new String[cols1];
                for (int col = 0; col < cols1; col++) {
                    Cell cell = sheet1.getCell(col, row);
                    arr[col] = String.valueOf(cell.getContents());
                }
                ChiTietHDDTO cthd = new ChiTietHDDTO();
                cthd.setStrMaHD( arr[0] );
                cthd.setStrMaGiay( arr[1] );
                cthd.setiSoLuong( Integer.parseInt(arr[2]) );
                cthd.setiGiaBan( Integer.parseInt(arr[3]) );
                list_CTHD.add(cthd);
                System.out.println(cthd.toString());
            }
            
            // close
            workbook.close();
        } catch (BiffException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (IOException e) {
            System.out.println("File not found\n" + e.toString());
        }
    }
 
    // create and write new file *.xls
    private void writeFileExcel_PN() {
        WritableWorkbook workbook;
        // create workbook
        try {
            workbook = Workbook.createWorkbook(new File(Memory.filechoose));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("PhieuNhap", 0);
            WritableSheet sheet2 = workbook.createSheet("ChiTietPhieuNhap", 1);
            
            // row begin write data_HD
            int rowBegin = 0;
            int colBegin = 0;
 
            for (int row = rowBegin, i = 0; row < data_PN.length + rowBegin; row++, i++) {
                for (int col = colBegin, j = 0; col < data_PN[0].length + colBegin; col++, j++) {
                    Object obj = data_PN[i][j];
                    sheet1.addCell(new Label(col, row, (String) data_PN[i][j]));
                }
            }
            
            for (int row = rowBegin, i = 0; row < data_CTPN.length + rowBegin; row++, i++) {
                for (int col = colBegin, j = 0; col < data_CTPN[0].length + colBegin; col++, j++) {
                    Object obj = data_CTPN[i][j];
                    sheet2.addCell(new Label(col, row, (String) data_CTPN[i][j]));
                }
            }
            
            rowBegin = 1;
            
            for (int row = rowBegin, i = 0; row < list_PN.getNumb()+ rowBegin; row++, i++) {
                PhieuNhapDTO hd = new PhieuNhapDTO();
                hd = list_PN.getInfor(i);
                
                //string
                sheet1.addCell(new Label(0, row, hd.getStrMaPN() ));
                sheet1.addCell(new Label(1, row, hd.getStrMaNCC()));
                sheet1.addCell(new Label(2, row, hd.getStrMaNV() ));
                sheet1.addCell(new Label(3, row, hd.getStrNgayNhap()));
                //double
                sheet1.addCell(new Label(4, row,String.valueOf(hd.getTongTien()) ));
            }
            
            for (int row = rowBegin, i = 0; row < list_CTPN.getNumbChiTietPN()+ rowBegin; row++, i++) {
                ChiTietPNDTO hd = new ChiTietPNDTO();
                hd = list_CTPN.getInfor(i);
                
                //string
                sheet2.addCell(new Label(0, row, hd.getStrMaGiay() ));
                sheet2.addCell(new Label(1, row, hd.getStrMaPN()));
                sheet2.addCell(new Label(2, row, String.valueOf(hd.getiSoLuong())));
                sheet2.addCell(new Label(3, row, String.valueOf(hd.getiGiaNhap())));
            }
            // write file
            workbook.write();
 
            // close
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error create file\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("Error write file\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("Error write file\n" + e.toString());
        }
        System.out.println("create and write success");
    }
 
    // open and read file *.xls
    private void readFileExcel_PN() {
        list_PN.deleteAll();
        list_CTPN.deleteAll();
        
        Workbook workbook;
        try {
            // create workbook to open file
            workbook = Workbook.getWorkbook(new File(Memory.filechoose));
            // get sheet want read
            Sheet sheet = workbook.getSheet(0);
            Sheet sheet1 = workbook.getSheet(1);
            
            // hoa don
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            for (int row = 1; row < rows; row++) {
                String[] arr = new String[cols];
                for (int col = 0; col < cols; col++) {
                    Cell cell = sheet.getCell(col, row);
                    arr[col] = String.valueOf(cell.getContents());
                }
                PhieuNhapDTO hd = new PhieuNhapDTO();
                hd.setStrMaPN( arr[0] );
                hd.setStrMaNCC(arr[1] );
                hd.setStrMaNV(arr[2] );
                hd.setStrNgayNhap(arr[3] );
                hd.setTongTien(Double.parseDouble(arr[4]) );
                list_PN.add(hd);
                System.out.println(hd.toString());
            }
            
            // chi tiet hoa don
            int rows1 = sheet1.getRows();
            int cols1 = sheet1.getColumns();
            for (int row = 1; row < rows1; row++) {
                String[] arr = new String[cols1];
                for (int col = 0; col < cols1; col++) {
                    Cell cell = sheet1.getCell(col, row);
                    arr[col] = String.valueOf(cell.getContents());
                }
                ChiTietPNDTO cthd = new ChiTietPNDTO();
                cthd.setStrMaPN( arr[0] );
                cthd.setStrMaGiay( arr[1] );
                cthd.setiSoLuong( Integer.parseInt(arr[2]) );
                cthd.setiGiaNhap(Integer.parseInt(arr[3]) );
                list_CTPN.add(cthd);
                System.out.println(cthd.toString());
            }
            
            // close
            workbook.close();
        } catch (BiffException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (IOException e) {
            System.out.println("File not found\n" + e.toString());
        }
    }
 

    public Excel() {
        try {
        list_CTPN = new ChiTietPNBUS();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            list_PN = new PhieuNhapBUS();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list_CTPN.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            list_PN.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            list_HD = new HoaDonBUS();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list_HD.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            list_CTHD = new ChiTietHDBUS();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list_CTHD.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setUndecorated(true);
        init();
        initComponents();

        System.out.println("");
        // các hàm xử lý sau khi vào
        kiemTraCapBac();
        colordefault();
        if (!Memory.flag_Menu) {
            pTop.setVisible(false);
            menuThanhCongcu.setText("Hiện thanh công cụ");
        }

        actionButtondisplayHD();
        actionButtondisplayChiTietHD();
    }
    
    private Color colorPanel_Top, colorPanel_Center, colorText;
    private JLabel[] listLblTop;
    private String[] strArr_Top;
    
    public void init() {
        colorPanel_Top = Memory.colorThemes;
        colorPanel_Center = Memory.colorThemes_2;
        colorText = Memory.colorText;
        
        strArr_Top = new String[10];
        strArr_Top[0] = "Hóa đơn";
        strArr_Top[1] = "Khuyến mãi";
        strArr_Top[2] = "Nhập hàng";
        strArr_Top[3] = "Hàng hóa";
        strArr_Top[4] = "Thống kê";
        strArr_Top[5] = "Excel";
        strArr_Top[6] = "Trở về";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_MauNen = new javax.swing.ButtonGroup();
        pCenter = new javax.swing.JPanel();
        pThongTin = new javax.swing.JPanel();
        btnExcel_1 = new javax.swing.JToggleButton();
        btnExcel_2 = new javax.swing.JToggleButton();
        lblChiTiet_ChiTietHoaDon2 = new javax.swing.JLabel();
        btnExcel_4 = new javax.swing.JToggleButton();
        lblChiTiet_ChiTietHoaDon3 = new javax.swing.JLabel();
        btnExcel_3 = new javax.swing.JToggleButton();
        btnExcel_5 = new javax.swing.JToggleButton();
        btnExcel_6 = new javax.swing.JToggleButton();
        pChiTiet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThongTin1 = new javax.swing.JTable();
        lblChiTiet_ChiTietHoaDon = new javax.swing.JLabel();
        lblChiTiet_ChiTietHoaDon1 = new javax.swing.JLabel();
        pTop = createPanel_LblTop(strArr_Top);
        menubar = new javax.swing.JMenuBar();
        menuTaiKhoan = new javax.swing.JMenu();
        menuTaiKhoan_ThongTin = new javax.swing.JMenuItem();
        menuTaiKhoan_DangXuat = new javax.swing.JMenuItem();
        menuThanhCongcu = new javax.swing.JMenu();
        MenuMauNen = new javax.swing.JMenu();
        rdbtnThongTin_MauCam = new javax.swing.JRadioButtonMenuItem();
        rdbtnThongTin_MauDen = new javax.swing.JRadioButtonMenuItem();
        rdbtnThongTin_Mautrang = new javax.swing.JRadioButtonMenuItem();
        menuTroVe = new javax.swing.JMenu();
        menuThoat = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        pCenter.setBackground(colorPanel_Center);
        pCenter.setPreferredSize(new java.awt.Dimension(1280, 600));

        pThongTin.setBackground(colorPanel_Center);
        pThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(colorPanel_Top, 5));
        pThongTin.setPreferredSize(new java.awt.Dimension(340, 580));
        pThongTin.setVerifyInputWhenFocusTarget(false);

        btnExcel_1.setText("Ghi File");
        btnExcel_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel_1ActionPerformed(evt);
            }
        });

        btnExcel_2.setText("Đọc File");
        btnExcel_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel_2ActionPerformed(evt);
            }
        });

        lblChiTiet_ChiTietHoaDon2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblChiTiet_ChiTietHoaDon2.setForeground(colorText);
        lblChiTiet_ChiTietHoaDon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ShoesManager/images/Button Menu/150_50/Hóa đơn.png"))); // NOI18N

        btnExcel_4.setText("Đọc từ Database");
        btnExcel_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel_4ActionPerformed(evt);
            }
        });

        lblChiTiet_ChiTietHoaDon3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblChiTiet_ChiTietHoaDon3.setForeground(colorText);
        lblChiTiet_ChiTietHoaDon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ShoesManager/images/Button Menu/150_50/Nhập hàng.png"))); // NOI18N

        btnExcel_3.setText("Ghi File");
        btnExcel_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel_3ActionPerformed(evt);
            }
        });

        btnExcel_5.setText("Đọc từ Database");
        btnExcel_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel_5ActionPerformed(evt);
            }
        });

        btnExcel_6.setText("Đọc File");
        btnExcel_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel_6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pThongTinLayout = new javax.swing.GroupLayout(pThongTin);
        pThongTin.setLayout(pThongTinLayout);
        pThongTinLayout.setHorizontalGroup(
            pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pThongTinLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinLayout.createSequentialGroup()
                        .addComponent(lblChiTiet_ChiTietHoaDon3)
                        .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pThongTinLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnExcel_3)
                                .addGap(33, 33, 33)
                                .addComponent(btnExcel_6))
                            .addGroup(pThongTinLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnExcel_5))))
                    .addGroup(pThongTinLayout.createSequentialGroup()
                        .addComponent(lblChiTiet_ChiTietHoaDon2)
                        .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pThongTinLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnExcel_1)
                                .addGap(33, 33, 33)
                                .addComponent(btnExcel_2))
                            .addGroup(pThongTinLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnExcel_4)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pThongTinLayout.setVerticalGroup(
            pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pThongTinLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblChiTiet_ChiTietHoaDon2))
                    .addGroup(pThongTinLayout.createSequentialGroup()
                        .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcel_1)
                            .addComponent(btnExcel_2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcel_4)))
                .addGap(27, 27, 27)
                .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblChiTiet_ChiTietHoaDon3))
                    .addGroup(pThongTinLayout.createSequentialGroup()
                        .addGroup(pThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcel_3)
                            .addComponent(btnExcel_6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcel_5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pChiTiet.setBackground(colorPanel_Center);
        pChiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(colorPanel_Top, 5));
        pChiTiet.setPreferredSize(new java.awt.Dimension(880, 580));

        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblThongTin);

        tblThongTin1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblThongTin1);

        lblChiTiet_ChiTietHoaDon.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblChiTiet_ChiTietHoaDon.setForeground(colorText);
        lblChiTiet_ChiTietHoaDon.setText("Chi Tiết");

        lblChiTiet_ChiTietHoaDon1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblChiTiet_ChiTietHoaDon1.setForeground(colorText);
        lblChiTiet_ChiTietHoaDon1.setText("Thông Tin");

        javax.swing.GroupLayout pChiTietLayout = new javax.swing.GroupLayout(pChiTiet);
        pChiTiet.setLayout(pChiTietLayout);
        pChiTietLayout.setHorizontalGroup(
            pChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pChiTietLayout.createSequentialGroup()
                .addGroup(pChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pChiTietLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)))
                    .addGroup(pChiTietLayout.createSequentialGroup()
                        .addGroup(pChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pChiTietLayout.createSequentialGroup()
                                .addGap(305, 305, 305)
                                .addComponent(lblChiTiet_ChiTietHoaDon1))
                            .addGroup(pChiTietLayout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(lblChiTiet_ChiTietHoaDon)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pChiTietLayout.setVerticalGroup(
            pChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChiTiet_ChiTietHoaDon1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChiTiet_ChiTietHoaDon)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pCenterLayout = new javax.swing.GroupLayout(pCenter);
        pCenter.setLayout(pCenterLayout);
        pCenterLayout.setHorizontalGroup(
            pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCenterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pCenterLayout.setVerticalGroup(
            pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCenterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(pChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pCenter, java.awt.BorderLayout.CENTER);

        pTop.setBackground(colorPanel_Top);
        pTop.setPreferredSize(new java.awt.Dimension(1280, 70));
        getContentPane().add(pTop, java.awt.BorderLayout.NORTH);

        menuTaiKhoan.setText("Tài khoản");

        menuTaiKhoan_ThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ShoesManager/images/user.png"))); // NOI18N
        menuTaiKhoan_ThongTin.setText("Thông tin");
        menuTaiKhoan_ThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuTaiKhoan_ThongTinMouseReleased(evt);
            }
        });
        menuTaiKhoan.add(menuTaiKhoan_ThongTin);

        menuTaiKhoan_DangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ShoesManager/images/logout.png"))); // NOI18N
        menuTaiKhoan_DangXuat.setText("Đăng xuất");
        menuTaiKhoan_DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuTaiKhoan_DangXuatMouseReleased(evt);
            }
        });
        menuTaiKhoan.add(menuTaiKhoan_DangXuat);

        menubar.add(menuTaiKhoan);

        menuThanhCongcu.setText("Ẩn thanh công cụ");
        menuThanhCongcu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThanhCongcuMouseClicked(evt);
            }
        });
        menubar.add(menuThanhCongcu);

        MenuMauNen.setText("Màu nền");

        buttonGroup_MauNen.add(rdbtnThongTin_MauCam);
        rdbtnThongTin_MauCam.setSelected(true);
        rdbtnThongTin_MauCam.setText("Màu cam/ trắng");
        rdbtnThongTin_MauCam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rdbtnThongTin_MauCamMouseReleased(evt);
            }
        });
        rdbtnThongTin_MauCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnThongTin_MauCamActionPerformed(evt);
            }
        });
        MenuMauNen.add(rdbtnThongTin_MauCam);

        buttonGroup_MauNen.add(rdbtnThongTin_MauDen);
        rdbtnThongTin_MauDen.setText("Màu đen/ đen");
        rdbtnThongTin_MauDen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rdbtnThongTin_MauDenMouseReleased(evt);
            }
        });
        rdbtnThongTin_MauDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnThongTin_MauDenActionPerformed(evt);
            }
        });
        MenuMauNen.add(rdbtnThongTin_MauDen);

        buttonGroup_MauNen.add(rdbtnThongTin_Mautrang);
        rdbtnThongTin_Mautrang.setText("Màu trắng/ xanh");
        rdbtnThongTin_Mautrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rdbtnThongTin_MautrangMouseReleased(evt);
            }
        });
        rdbtnThongTin_Mautrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnThongTin_MautrangActionPerformed(evt);
            }
        });
        MenuMauNen.add(rdbtnThongTin_Mautrang);

        menubar.add(MenuMauNen);

        menuTroVe.setText("Trở về");
        menuTroVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTroVeMouseClicked(evt);
            }
        });
        menubar.add(menuTroVe);

        menuThoat.setText("Thoát");
        menuThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThoatMouseClicked(evt);
            }
        });
        menubar.add(menuThoat);

        setJMenuBar(menubar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbtnThongTin_MautrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnThongTin_MautrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnThongTin_MautrangActionPerformed

    private void rdbtnThongTin_MauDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnThongTin_MauDenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnThongTin_MauDenActionPerformed

    private void rdbtnThongTin_MauCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnThongTin_MauCamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnThongTin_MauCamActionPerformed

    private void rdbtnThongTin_MauCamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbtnThongTin_MauCamMouseReleased
        Memory.colorThemes =  new Color(250, 160, 100);
        Memory.colorThemes_2 = new Color(255, 255, 255);
        Memory.colorText = new Color(0, 0, 0);
        colorPanel_Top = Memory.colorThemes;
        colorPanel_Center = Memory.colorThemes_2;
        colorText = Memory.colorText;
        setTextColor("đen");
        System.out.println("da thay doi mau nen thanh cam trang");        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnThongTin_MauCamMouseReleased

    private void rdbtnThongTin_MauDenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbtnThongTin_MauDenMouseReleased
        // TODO add your handling code here:
        Memory.colorThemes =  new Color(0, 0, 0);
        Memory.colorThemes_2 = new Color(0, 0, 0);
        Memory.colorText = new Color(255, 255, 255);
        colorPanel_Top = Memory.colorThemes;
        colorPanel_Center = Memory.colorThemes_2;
        colorText = Memory.colorText;
        setTextColor("trắng");
        System.out.println("da thay doi mau nen thanh den");
    }//GEN-LAST:event_rdbtnThongTin_MauDenMouseReleased

    private void rdbtnThongTin_MautrangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbtnThongTin_MautrangMouseReleased
        // TODO add your handling code here:
        Memory.colorThemes =  new Color(255, 255, 255);
        Memory.colorThemes_2 = new Color(131,189,246);
        Memory.colorText = new Color(0, 0, 0);
        colorPanel_Top = Memory.colorThemes;
        colorPanel_Center = Memory.colorThemes_2;
        colorText = Memory.colorText;
        setTextColor("đen");
        System.out.println("da thay doi mau nen thanh trang");
    }//GEN-LAST:event_rdbtnThongTin_MautrangMouseReleased

    private void menuThanhCongcuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThanhCongcuMouseClicked
        // TODO add your handling code here:
        if ( Memory.flag_Menu ) {
            pTop.setVisible(false);
            menuThanhCongcu.setText("Hiện thanh công cụ");
            Memory.flag_Menu = false;
        }
        else {
            pTop.setVisible(true);
            menuThanhCongcu.setText("Ẩn thanh công cụ");
            Memory.flag_Menu = true;
        }
    }//GEN-LAST:event_menuThanhCongcuMouseClicked

    private void menuTroVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTroVeMouseClicked
        // TODO add your handling code here:
        Home home;
        try {
            home = new Home();
            home.setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }//GEN-LAST:event_menuTroVeMouseClicked

    private void menuTaiKhoan_ThongTinMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTaiKhoan_ThongTinMouseReleased

        // TODO add your handling code here:
        UserInfor ui = new UserInfor();
        ui.setVisible(true);
    }//GEN-LAST:event_menuTaiKhoan_ThongTinMouseReleased

    private void menuTaiKhoan_DangXuatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTaiKhoan_DangXuatMouseReleased
        // TODO add your handling code here:
        Login lg;
        try {
            lg = new Login();
            lg.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuTaiKhoan_DangXuatMouseReleased

    private void menuThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThoatMouseClicked
        // TODO add your handling code here:
        Question_YesNO Q = new Question_YesNO("Bạn có muốn thoát không?");
        Q.setVisible(true);
        
    }//GEN-LAST:event_menuThoatMouseClicked

    private void btnExcel_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel_1ActionPerformed
        // TODO add your handling code here:
        ChonFile cf = new ChonFile(this, true);
        cf.setVisible(true);
        writeFileExcel_HD();
    }//GEN-LAST:event_btnExcel_1ActionPerformed

    private void btnExcel_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel_2ActionPerformed
        // TODO add your handling code here:
        ChonFile cf = new ChonFile(this, true);
        cf.setVisible(true);
        String[] s = Memory.filechoose.split("\\.");
        if (s[1].equals("xls")) {
            readFileExcel_HD();
            actionButtondisplayHD();
            actionButtondisplayChiTietHD();
        }
        else {
            JOptionPane.showConfirmDialog(null, "File Không đúng hãy chọn file excel\nvd:abd.xls", "404", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcel_2ActionPerformed

    private void btnExcel_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel_4ActionPerformed
        try {
            list_HD.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            list_CTHD.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        actionButtondisplayChiTietHD();
        actionButtondisplayHD();
    }//GEN-LAST:event_btnExcel_4ActionPerformed

    private void btnExcel_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel_3ActionPerformed
        // TODO add your handling code here:
        ChonFile cf = new ChonFile(this, true);
        cf.setVisible(true);
        writeFileExcel_PN();
    }//GEN-LAST:event_btnExcel_3ActionPerformed

    private void btnExcel_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel_5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            list_PN.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            list_CTPN.docDB();
        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        actionButtondisplayChiTietPN();
        actionButtondisplayPN();
    }//GEN-LAST:event_btnExcel_5ActionPerformed

    private void btnExcel_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel_6ActionPerformed
        // TODO add your handling code here:
        ChonFile cf = new ChonFile(this, true);
        cf.setVisible(true);
        String[] s = Memory.filechoose.split("\\.");
        if (s[1].equals("xls")) {
            readFileExcel_PN();
            actionButtondisplayPN();
            actionButtondisplayChiTietPN();
        }
        else {
            JOptionPane.showConfirmDialog(null, "File Không đúng hãy chọn file excel\nvd:abd.xls", "404", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcel_6ActionPerformed

    
    
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
        
        if ( iKey != 1) {
            for (int i  = 0 ; i < strArr_Top.length ; i++) {
                listLblTop[i].setVisible(false);
            }
        }
        
        switch (iKey) {
            case 2:
                listLblTop[6].setVisible(true);
                listLblTop[5].setVisible(true);
                listLblTop[4].setVisible(true);
                break;
            case 3:
                listLblTop[6].setVisible(true);
                listLblTop[3].setVisible(true);
                break;
            case 4:
                listLblTop[6].setVisible(true);
                listLblTop[2].setVisible(true);
                break;
            case 5:
                listLblTop[6].setVisible(true);
                listLblTop[1].setVisible(true);
                break;
            case 6:
                listLblTop[6].setVisible(true);
                listLblTop[0].setVisible(true);
                break;
        }
    }
    
    private JPanel createPanel_LblTop(String[] strArr_Top) {
        JPanel Panel = new JPanel();
        listLblTop = new JLabel[10];
        
        Panel.setLayout(new FlowLayout(0,30,10));
        Panel.setBackground(colorPanel_Top);
        
        for (int i=0 ; i < strArr_Top.length ; i++) {
            listLblTop[i] = new JLabel(new ImageIcon("./src/ShoesManager/images/Button Menu/150_50/"+strArr_Top[i]+".png"));
            listLblTop[i].setName(strArr_Top[i]);
            listLblTop[i].setOpaque(true);
            listLblTop[i].addMouseListener(this);
            listLblTop[i].setBackground(colorPanel_Top);
            
            Panel.add(listLblTop[i]);
        }
        
        return Panel;
    }
    
    public void setTextColor(String Mau){
        
        lblChiTiet_ChiTietHoaDon.setForeground(colorText);
        lblChiTiet_ChiTietHoaDon1.setForeground(colorText);
        
        //-----------------------Đổi màu cho Panel
        pTop.setBackground( colorPanel_Top );
        pCenter.setBackground( colorPanel_Center );
        pChiTiet.setBackground( colorPanel_Center );
        pThongTin.setBackground( colorPanel_Center );
        
        //---------------------list lbl top
        for (int i=0 ; i < strArr_Top.length ; i++) {
            listLblTop[i].setBackground( colorPanel_Top );
        }
        
        //------------------------0Doi963 màu khung
        pThongTin.setBorder(BorderFactory.createLineBorder(colorPanel_Top, 5) );
        pChiTiet.setBorder(BorderFactory.createLineBorder(colorPanel_Top, 5) );
    }   
    
    public void colordefault(){
        Color color;
        color = new Color(250, 160, 100);
        if (Memory.colorThemes.getRGB() == color.getRGB() )
            rdbtnThongTin_MauCam.setSelected(true);
        color = new Color(0, 0, 0);
        if (Memory.colorThemes.getRGB() == color.getRGB() )
            rdbtnThongTin_MauDen.setSelected(true);
        color = new Color(255, 255, 255);
        if (Memory.colorThemes.getRGB() == color.getRGB() )
            rdbtnThongTin_Mautrang.setSelected(true);
    }
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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Excel().setVisible(true);
            }
        });
    }

    
    private void createVectorHeaderHD() {
        if (model.getRowCount()==0) {
            Vector<String> header = new Vector();
            header.add("Mã HĐ");
            header.add("Mã KH");
            header.add("Mã NV");
            header.add("Mã KM");
            header.add("Ngày Bán");
            header.add("Tổng Tiền");
            
            model = new DefaultTableModel(header, 0){
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        }
    }
    
    private void actionButtondisplayHD() {
        model = new DefaultTableModel();
        
        createVectorHeaderHD();
        for (int i=0 ; i < list_HD.getNumbHoaDon() ; i++) {
            HoaDonDTO hd = new HoaDonDTO();
            
            hd = list_HD.getInfor(i);
            
            createVectorHeaderHD();
            
            Vector row=new Vector();
            row.add(hd.getStrMaHD());
            row.add(hd.getStrMaKH());
            row.add(hd.getStrMaNV());
            row.add(hd.getStrMaKM());
            row.add(hd.getStrNgayBan());
            row.add(hd.getTongTien());
            
            model.addRow(row);
        }
        
        tblThongTin.setModel(model);
        tblThongTin.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblThongTin.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
    private void createVectorHeaderChiTietHD() {
        if (modelChiTiet.getRowCount()==0) {
            Vector<String> header = new Vector();
            header.add("Mã Sản Phẩm");
            header.add("Mã Hóa Đơn");
            header.add("Số Lượng");
            header.add("Giá Bán");
            header.add("Mã Khuyến Mãi");
            header.add("Tỉ Lệ KM");
            modelChiTiet = new DefaultTableModel(header, 0) {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        }
    }
    
    private void actionButtondisplayChiTietHD() {
        actionButtondisplayChiTietHD("null");
    }
    
    private void actionButtondisplayChiTietHD(String strMaHD) {
        modelChiTiet = new DefaultTableModel();
        
        createVectorHeaderChiTietHD();
        for (int i=0 ; i < list_CTHD.getNumbChiTietHD() ; i++) {
            ChiTietHDDTO hd = new ChiTietHDDTO();
            
            hd = list_CTHD.getInfor(i);
            
            createVectorHeaderChiTietHD();
            
            if ( hd.getStrMaHD().equalsIgnoreCase(strMaHD) || 
                    strMaHD.equals("null")) {
                
                Vector row=new Vector();
                row.add(hd.getStrMaGiay());
                row.add(hd.getStrMaHD());
                row.add(hd.getiSoLuong());
                row.add(hd.getiGiaBan());
                row.add(hd.getStrMaGiay());
                modelChiTiet.addRow(row);
            }
        }
        
        tblThongTin1.setModel(modelChiTiet);
    }
    
    
    //phieu nhap=================================================================================
    private void createVectorHeaderPN() {
        if (model.getRowCount()==0) {
            Vector<String> header = new Vector();
            header.add("Mã PN");
            header.add("Mã NCC");
            header.add("Mã NV");
            header.add("Ngày Nhập");
            header.add("Tổng Tiền");
            
            model = new DefaultTableModel(header, 0){
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };;
        }
    }
    
    private void actionButtondisplayPN() {
        model = new DefaultTableModel();
        
        createVectorHeaderPN();
        for (int i=0 ; i < list_PN.getNumb() ; i++) {
            PhieuNhapDTO hd = new PhieuNhapDTO();
            
            hd = list_PN.getInfor(i);
            
            createVectorHeaderPN();
            
            Vector row=new Vector();
            row.add(hd.getStrMaPN());
            row.add(hd.getStrMaNCC());
            row.add(hd.getStrMaNV());
            row.add(hd.getStrNgayNhap());
            row.add(hd.getTongTien());
            
            model.addRow(row);
        }
       
        
        tblThongTin.setModel(model);
        
    }
    private void createVectorHeaderChiTietPN() {
        if (modelChiTiet.getRowCount()==0) {
            Vector<String> header = new Vector();
            header.add("Mã Sản Phẩm");
            header.add("Mã Phiếu Nhập");
            header.add("Số Lượng");
            header.add("Giá Nhập");
            modelChiTiet = new DefaultTableModel(header, 0) {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        }
    }
    
    private void actionButtondisplayChiTietPN() {
        actionButtondisplayChiTietPN("null");
    }
    
    private void actionButtondisplayChiTietPN(String strMaHD) {
        modelChiTiet = new DefaultTableModel();
        
        createVectorHeaderChiTietPN();
        for (int i=0 ; i < list_CTPN.getNumbChiTietPN() ; i++) {
            ChiTietPNDTO hd = new ChiTietPNDTO();
            
            hd = list_CTPN.getInfor(i);
            
            createVectorHeaderChiTietPN();
            
            if ( hd.getStrMaPN().equalsIgnoreCase(strMaHD) || 
                    strMaHD.equals("null")) {
                
                Vector row=new Vector();
                row.add(hd.getStrMaGiay());
                row.add(hd.getStrMaPN());
                row.add(hd.getiSoLuong());
                row.add(hd.getiGiaNhap());
                modelChiTiet.addRow(row);
            }
        }
        
        tblThongTin1.setModel(modelChiTiet);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuMauNen;
    private javax.swing.JToggleButton btnExcel_1;
    private javax.swing.JToggleButton btnExcel_2;
    private javax.swing.JToggleButton btnExcel_3;
    private javax.swing.JToggleButton btnExcel_4;
    private javax.swing.JToggleButton btnExcel_5;
    private javax.swing.JToggleButton btnExcel_6;
    private javax.swing.ButtonGroup buttonGroup_MauNen;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblChiTiet_ChiTietHoaDon;
    private javax.swing.JLabel lblChiTiet_ChiTietHoaDon1;
    private javax.swing.JLabel lblChiTiet_ChiTietHoaDon2;
    private javax.swing.JLabel lblChiTiet_ChiTietHoaDon3;
    private javax.swing.JMenu menuTaiKhoan;
    private javax.swing.JMenuItem menuTaiKhoan_DangXuat;
    private javax.swing.JMenuItem menuTaiKhoan_ThongTin;
    private javax.swing.JMenu menuThanhCongcu;
    private javax.swing.JMenu menuThoat;
    private javax.swing.JMenu menuTroVe;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel pCenter;
    private javax.swing.JPanel pChiTiet;
    private javax.swing.JPanel pThongTin;
    private javax.swing.JPanel pTop;
    private javax.swing.JRadioButtonMenuItem rdbtnThongTin_MauCam;
    private javax.swing.JRadioButtonMenuItem rdbtnThongTin_MauDen;
    private javax.swing.JRadioButtonMenuItem rdbtnThongTin_Mautrang;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JTable tblThongTin1;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void mouseClicked(MouseEvent me) {
        JLabel src = (JLabel) me.getSource();
        System.out.println(src.getName() + "is Clicked");
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        JLabel src = (JLabel) me.getSource();
        System.out.println(src.getName() + "is Pressed");
        src.setIcon(new ImageIcon("./src/ShoesManager/images/Button Menu/150_50/"+src.getName()+" click.png"));
         
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        JLabel src = (JLabel) me.getSource();
        System.out.println(src.getName() + "is Entered");
        src.setIcon(new ImageIcon("./src/ShoesManager/images/Button Menu/150_50/"+src.getName()+" hover.png"));
    
        // xử lý nút trở về
        if ( src.getName().equals("Trở về") ) {
            Home home;
            try {
                home = new Home();
                home.setVisible(true);
                setVisible(false);
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        
        if ( src.getName().equals("Khuyến mãi") ) 
                try {
                    KhuyenMai dm;
                    dm = new KhuyenMai();
                    dm.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } 
        
        if ( src.getName().equals("Hóa đơn") ) 
                try {
                    HoaDon hd;
                    hd = new HoaDon();
                    hd.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        if ( src.getName().equals("Nhập hàng") ) 
                try {
                    PhieuNhap hd = new PhieuNhap();
                    hd.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        if ( src.getName().equals("Hàng hóa") ) 
                try {
                    Sanpham hd = new Sanpham();
                    hd.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        if ( src.getName().equals("Thống kê") ) 
                try {
                    ThongKe hd;
                    hd = new ThongKe();
                    hd.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        JLabel src = (JLabel) me.getSource();
        System.out.println(src.getName() + "is Entered");
        src.setIcon(new ImageIcon("./src/ShoesManager/images/Button Menu/150_50/"+src.getName()+" hover.png"));
           
    }

    @Override
    public void mouseExited(MouseEvent me) {
        JLabel src = (JLabel) me.getSource();
        System.out.println(src.getName() + "is Exited");
        src.setIcon(new ImageIcon("./src/ShoesManager/images/Button Menu/150_50/"+src.getName()+".png"));
         
    }
}
