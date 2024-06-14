package View;

import Model.Client;
import Model.HibernateUties;
import Model.User;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class ChatRoom extends javax.swing.JFrame {
    private String newnickname;


    public ChatRoom() {
        initComponents();
    }

    public ChatRoom(Client client) {
        this.client = client;
        initComponents();
    }


    public String getNewnickname() {
        return newnickname;
    }

    public void setNewnickname(String newnickname) {
        this.newnickname = newnickname;
    }

    int width = 204;


    int height = 469;
    int width_1 = 630;
    int height_1 = 70;
    boolean isMenuOpen = false;
    boolean isMenuOpen_1 = false;
    private Client client ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String id_hash;

    public String getId_hash() {
        return id_hash;
    }

    public void setId_hash(String id_hash) {
        this.id_hash = id_hash;
    }

    private String id ;


    void OpenMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                jPanel2.setSize(200, 10); // Set size of jPanel2
                jLabel1.setSize(180,120);
                jLabel2.setSize(200,40);
                jLabel3.setBounds(0,150,200,50);
                jLabel4.setBounds(0,200,200,50);
                jLabel5.setBounds(0,350,200,50);
                jPanel3.setSize(200,10);
                jLabel6.setBounds(0,250,200,50);



                if (!isMenuOpen) {
                    for (int i = 0; i <= width; i++) {
                        jPanel_menu.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    isMenuOpen = true;
                } else {
                    for (int i = width; i >= 0; i--) {
                        jPanel_menu.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    isMenuOpen = false;
                }
            }
        }).start();
    }
    void OpenMenuBar_1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!isMenuOpen_1) {
                    for (int i = 0; i <= height_1; i++) {
                        jPanel_1.setSize(width_1, i);

                        jPanel_1.setLocation(jPanel_1.getX(), 485 - i); // Dịch chuyển xuống
                        jPanel_1.revalidate();
                        jPanel_1.repaint(); // Cập nhật giao diện người dùng
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    isMenuOpen_1 = true;
                } else {
                    for (int i = height_1; i >= 0; i--) {

                        jPanel_1.setSize(width_1, i);
                        jPanel_1.setLocation(jPanel_1.getX(), 485 - i); // Dịch chuyển lên
                        jPanel_1.revalidate();
                        jPanel_1.repaint(); // Cập nhật giao diện người dùng
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    isMenuOpen_1 = false;
                }
            }
        }).start();
    }

    void CloseMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isMenuOpen) {
                    for (int i = width; i > 0; i--) {
                        jPanel_menu.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    isMenuOpen = false;
                }
            }
        }).start();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel_menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel_1 = new JPanel();
        button_1 = new JLabel("");
        button_2 = new JLabel("");
        button_3 = new JLabel("");

        jLabel = new JLabel("X");
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextArea1.setEditable(false);
        jTextArea1.setContentType("text/html");
        jTextArea1.setEditorKit(new HTMLEditorKit());
        jTextArea1.setDocument(new HTMLDocument());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLabel.setBounds(190,0,40,40);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\lamdt\\Downloads\\icons8-avatar-70.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel_menu.add(jLabel);

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel3.setText("Thông tin cá nhân");

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel4.setText("Thay đổi Avatar");

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel5.setText("Đăng xuất");

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel_1.setBounds(5, 415, 630, 0);
        jPanel_1.setBackground(new java.awt.Color(35, 232, 210, 92));
        jPanel_1.setLayout(null); // Sử dụng layout null để thiết lập vị trí thủ công cho các nút
        this.add(jPanel_1);

        button_1.setBounds(10, 10, 50, 50);
        button_2.setBounds(70, 10, 50, 50);
        button_3.setBounds(130, 10, 50, 50);
        jPanel_1.setBackground(Color.PINK);
        jPanel_1.add(button_1);
        button_1.setIcon(new ImageIcon("src/main/java/Image/icons8-image-file-62.png"));
        button_2.setIcon(new ImageIcon("src/main/java/Image/icons8-file-62.png"));
        button_3.setIcon(new ImageIcon("src/main/java/Image/icons8-kiss-_-_-58.png"));
        jPanel_1.add(button_2);
        jPanel_1.add(button_3);

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel6.setText("Thay đổi nickname");

        javax.swing.GroupLayout jPanel_menuLayout = new javax.swing.GroupLayout(jPanel_menu);
        jPanel_menu.setLayout(jPanel_menuLayout);
        jPanel_menuLayout.setHorizontalGroup(
                jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_menuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_menuLayout.setVerticalGroup(
                jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_menuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menuLayout.createSequentialGroup()
                                        .addContainerGap(261, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(174, 174, 174)))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\lamdt\\Downloads\\icons8-menu-30.png")); // NOI18N


        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("");

        jButton1.setText("");
        jButton1.setIcon( new ImageIcon("src/main/java/Image/icons8-files-40.png"));

        jButton2.setText("GỬI");


        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel_menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())

        );


        pack();

        // Thêm MouseListener tại đây
        jLabel7.addMouseListener(mouseListener);
        jLabel.addMouseListener(mouseListener);
        jButton1.addMouseListener(mouseListener);
        jLabel6.addMouseListener(mouseListener);
        jLabel4.addMouseListener(mouseListener);
        jLabel5.addMouseListener(mouseListener);
        button_1.addMouseListener(mouseListener);
        button_2.addMouseListener(mouseListener);
        jLabel3.addMouseListener(mouseListener);

    }


    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == jLabel7) {
                OpenMenuBar();
            }
            if (e.getSource() == jButton1) {
                OpenMenuBar_1();
            }
            if (e.getSource() == jLabel) {
                CloseMenuBar();
            }
            else if (e.getSource() == jLabel6) {
                handleNicknameChange();
            } else if (e.getSource()==jLabel3) {
                if(BCrypt.checkpw(id_hash,id)){
                    Session session = HibernateUties.getFACTORY().openSession();
                    User user = session.get(User.class,id);
                    String first_name = user.getFirst_name();
                    String last_name = user.getLast_name();
                    String email = id_hash;
                    String message = String.format("FirstName: %s\nlastName: %s\nEmail: %s", first_name, last_name, email);
                    JOptionPane.showMessageDialog(null,message," ", JOptionPane.INFORMATION_MESSAGE);

                }
               ;



            } else if(e.getSource()==jLabel4){
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\lamdt\\OneDrive\\Pictures");
                FileNameExtensionFilter filenameFilter = new FileNameExtensionFilter("hinh anh" ,"jng","png");
                fileChooser.setFileFilter(filenameFilter);
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.showOpenDialog(ChatRoom.this);
                File file = fileChooser.getSelectedFile();
                jLabel1.setIcon(new ImageIcon(file.getAbsolutePath()));
                Session session  = HibernateUties.getFACTORY().openSession();
                User user = session.get(User.class,id);
                session.getTransaction().begin();
                user.setAvatar(file.getAbsolutePath());
                session.save(user);
                session.getTransaction().commit();
                session.close();


            }
            else if(e.getSource()==jLabel5){
                dispose();
            } else if (e.getSource()==button_1) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\lamdt\\OneDrive\\Pictures");
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("hình ảnh", "png","jng");
                fileChooser.setFileFilter(fileNameExtensionFilter);
                int x = fileChooser.showDialog(ChatRoom.this,"Chọn ảnh");
            }
            else if(e.getSource()==button_2){
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\lamdt\\OneDrive\\Documents");
                 int x = fileChooser.showOpenDialog(ChatRoom.this);

            }


        }
        private void handleNicknameChange() {
            String newNickName = JOptionPane.showInputDialog(null, "Thay đổi nick name:", "");
            if (newNickName != null && !newNickName.trim().isEmpty()) {
                jLabel2.setText(newNickName); // Update the label to show the new nickname
                Session session = HibernateUties.getFACTORY().openSession();
                session.getTransaction().begin();
                User user = session.get(User.class, id);
                user.setFirst_name(newNickName);
                session.update(user);
                session.getTransaction().commit();
                session.close();

                // Update the client name
                setNewnickname(newNickName);
            } else {
                System.out.println("No nickname entered or cancelled.");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };

    public static void main(String args[]) {
        setLookAndFeel("Windows");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatRoom().setVisible(true);
            }
        });
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JPanel getjPanel_1() {
        return jPanel_1;
    }

    public void setjPanel_1(JPanel jPanel_1) {
        this.jPanel_1 = jPanel_1;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public JLabel getButton_1() {
        return button_1;
    }

    public void setButton_1(JLabel button_1) {
        this.button_1 = button_1;
    }

    public JLabel getButton_2() {
        return button_2;
    }

    public void setButton_2(JLabel button_2) {
        this.button_2 = button_2;
    }

    public JLabel getButton_3() {
        return button_3;
    }

    public void setButton_3(JLabel button_3) {
        this.button_3 = button_3;
    }

    public JPanel getjPanel_menu() {
        return jPanel_menu;
    }

    public void setjPanel_menu(JPanel jPanel_menu) {
        this.jPanel_menu = jPanel_menu;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextPane getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextPane jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    private static void setLookAndFeel(String lookAndFeel) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (lookAndFeel.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private JPanel jPanel_1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private JLabel jLabel;
    private JLabel button_1 ;
    private JLabel button_2;
    private JLabel button_3;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextArea1;
    private javax.swing.JTextField jTextField1;
}
