package ShoesManager.GUI;

import ShoesManager.BUS.TaiKhoanBUS;
import ShoesManager.DTO.TaiKhoanDTO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener {

    public Login() throws Exception {
        initComponents();
        
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
    
    public void initComponents() throws Exception {
        list_TK = new TaiKhoanBUS();
        
        Arial = new Font("Arial", Font.PLAIN, 15);
        Memory.colorText = new Color(0, 0, 0);
        Memory.colorThemes_2 = new Color(255, 255, 255);
        colorPanel_L = Memory.colorThemes_2;
        Memory.colorThemes = new Color(250, 160, 100);
        colorPanel_R = Memory.colorThemes;

        iconClose = new ImageIcon("./src/ShoesManager/images/cross.png");
        iconLogo = new ImageIcon("./src/ShoesManager/images/Logo.png");
        pLeft = new JPanel();
        pRight = new JPanel();
        btnExit = new JButton(iconClose);
        lblLogo = new JLabel(iconLogo);
        lblName = new JLabel(new ImageIcon("./src/ShoesManager/images/user.png") );
        lblPass = new JLabel(new ImageIcon("./src/ShoesManager/images/password.png") );
        tfName = new JTextField();
        pfPass = new JPasswordField();
        lblImage = new JLabel(new ImageIcon("./src/ShoesManager/images/Poster/Poster_1.png"));
        pRadioButtons = createPanel_RadioButton(3);
        lblLogin = new JLabel("Đăng nhập", SwingConstants.CENTER);
        
        // Jframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // chia theo tỉ lệ 4:3 x 187
        this.setSize(748, 561);
        this.setLayout(new GridLayout(0, 2));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);

        this.add(pLeft);
        this.add(pRight);

        //-----------------------------Panel Left-------------------------------
        pLeft.setLayout(null);
        pLeft.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black));
        pLeft.setBackground(colorPanel_L);
        //w=374,h=561

        //rb1.setBounds(60);
        pLeft.add(lblImage);
        pLeft.add(pRadioButtons);

//        lblImage.setBackground(colorPanel_L);
        lblImage.setBackground(Color.YELLOW);
        lblImage.setBounds(20, 20, 335, 500);
        lblImage.setOpaque(true);

        pRadioButtons.setBounds(50, 515, 274, 30);

        //---------------------------- Panel Right------------------------------
        pRight.setLayout(null);
        pRight.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
        pRight.setBackground(colorPanel_R);

        pRight.add(btnExit);
        pRight.add(lblLogo);
        pRight.add(tfName);
        pRight.add(pfPass);
        pRight.add(lblName);
        pRight.add(lblPass);
        pRight.add(lblLogin);

        btnExit.setBounds(350, 1, 24, 24);
        btnExit.setBackground(colorPanel_R);
        btnExit.setForeground(colorPanel_R);
        btnExit.setOpaque(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnClose();
            }
        });

        lblName.setBounds(90, 285, 30, 30);
        lblPass.setBounds(90, 335, 30, 30);
        
        tfName.setBounds(130, 285, 150, 30);
        tfName.setFont(Arial);
        tfName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        tfName.setOpaque(false);
        tfName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_ENTER) {
                    pfPass.requestFocus();
                }
            }
        });

        pfPass.setBounds(130, 335, 150, 30);
        pfPass.setFont(Arial);
        pfPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        pfPass.setOpaque(false);
        pfPass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_ENTER) {
                    actionButton_Login();
                }
            }
        });
        
        lblLogin.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        lblLogin.setBounds(60, 415, 260, 40);
        lblLogin.setBackground(new java.awt.Color(241, 196, 15));
        lblLogin.setOpaque(true);
        lblLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                actionButton_Login();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                lblLogin.setBackground(colorPanel_R);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                lblLogin.setBackground(new java.awt.Color(241, 196, 15));
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lblLogin.setBackground(new java.awt.Color(243, 156, 18));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lblLogin.setBackground(new java.awt.Color(241, 196, 15));
            }
        });

        lblLogo.setBounds(90, 60, 200, 200);
        lblLogo.setBackground(Color.BLACK);
        
        time = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("thời gian chạy");
                for (int i = 0 ; i < radiobuttons.length ; i++) {
                    if (radiobuttons[i].isSelected()) {
                            if ( i == radiobuttons.length - 1)
                                i = -1;
                            setButtonImageIcon(i+1);
                            radiobuttons[i+1].setSelected(true);
                            break;
                        }
                }
            }
        });
        time.start();
        //-----------------------End---------------------------------------------
    }

    public void setButtonImageIcon(int iNumb){
        String url = "./src/ShoesManager/images/Poster/Poster_";
        
        // lấy Number
        int iNumber = iNumb + 1;
        
        // thêm đuôi vào url
        url += String.valueOf(iNumber) + ".png";
        
        // hiển thị ảnh theo Number đã lấy
        lblImage.setIcon(new ImageIcon(url));   
    }
    
    /**
     * @param iNumbRadioBtn truyền số lượng các Radio button vào
     * @return JPanel với 1 list RadioButton
     */
    private JPanel createPanel_RadioButton(int iNumbRadioBtn) {
        JPanel Panel = new JPanel();
        radiobuttons = new JRadioButton[3];
        buttongroup = new ButtonGroup();

        Panel.setLayout(new FlowLayout());
        Panel.setBackground(colorPanel_L);

        for (int i = 0; i < iNumbRadioBtn; i++) {
            radiobuttons[i] = new JRadioButton();
            radiobuttons[i].setName("radiobutton " + i);
            radiobuttons[i].addActionListener((ActionListener) this);
            radiobuttons[i].setBackground(colorPanel_L);
            
            
            buttongroup.add(radiobuttons[i]);
            Panel.add(radiobuttons[i]);
        }
        radiobuttons[0].setSelected(true);
        
        return Panel;
    }
    
    /**
     * Xử lý đăng nhập
     * nếu đăng nhập thành công sẽ chuyển sang trang home
     */
    public Boolean actionButton_Login() {
        TaiKhoanDTO tk = new TaiKhoanDTO();
        
        tk.setStrTenDangNhap(tfName.getText());
        tk.setStrMatKhau(new String( pfPass.getPassword()) );
//        
        if ( list_TK.kiemTraDangNhap(tk) ) {
            System.out.println("Đăng nhập thành công");
            // ghi dữ liệu vào bộ nhớ
            Memory.maNV = tk.getStrTenDangNhap();
            
            Memory.iCapBac = list_TK.getCapBac_Ten(tk.getStrTenDangNhap());
            Memory.flag_Menu = true;
            // chuyển trang
            
            try {
                Home home = new Home();
                home.setVisible(true);
                time.stop();
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println("Lỗi " + e.getMessage());
            }
            return true;
        }
        
        // nếu đăng nhập sai thì xóa mật khẩu cũ 
        // và điền lại mật khẩu mới
        System.out.println("Đăng nhập thất bại");
        pfPass.setText("");
        pfPass.requestFocus();
        return false;
    }

    /**
     * xừ lý phần thay đổi hình ảnh khi click vào radio button
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        JRadioButton src = (JRadioButton) ae.getSource();
//        System.out.println(src.getName());
        String url = "./src/ShoesManager/images/Poster/Poster_";
        
        // cắt chuỗi để lấy số dằng sau: radiobutton Number
        String[] srcName = src.getName().split(" ");
        // lấy Number
        int iNumber = Integer.parseInt(srcName[1]) + 1;
        
        // thêm đuôi vào url
        url += String.valueOf(iNumber) + ".png";
        
        // hiển thị ảnh theo Number đã lấy
        lblImage.setIcon(new ImageIcon(url));
        System.out.println(url);
    }

    private void actionBtnClose() {
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        new Login().setVisible(true);
    }

//    private
    private Font Arial;
    private TaiKhoanBUS list_TK;
    private Color colorPanel_L, colorPanel_R;
    private JPanel pLeft, pRight, pRadioButtons;
    private JButton btnExit;
    private ImageIcon iconClose, iconLogo;
    private JLabel lblLogo, lblName, lblPass, lblLogin;
    private JLabel lblImage;
    private JTextField tfName;
    private JPasswordField pfPass;
    private JRadioButton[] radiobuttons;
    private ButtonGroup buttongroup;
    private Timer time;
//    private TaiKhoanBUS list_TK;
//    End.
}
