package Controller;


import Model.Client;
import Model.HibernateUties;
import Model.User;

import View.ChatRoom;
import View.Login;
import View.Regester;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Control extends JFrame {
   private Login login ;
   private Regester regester ;
   private ChatRoom chatRoom ;
   private Client client ;

       public Control(Login login, Regester regester,ChatRoom chatRoom,Client client ) {
        this.login = login;
        this.regester = regester;
        this.chatRoom = chatRoom;
        this.client = client;


        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==login.getjButton_regester()){
                    regester.setVisible(true);
                    login.setVisible(false);
                }
                if(e.getSource()==regester.getjButton1()){
                    String first_name = String.valueOf(regester.getjTextField_firstname().getText());
                    String last_name = String.valueOf(regester.getjTextField_lastname().getText());
                    String email = String.valueOf(regester.getjTextField_email().getText());
                    String email_hash = BCrypt.hashpw(email,BCrypt.gensalt(10));
                    String password = new String(regester.getjPasswordField_password().getPassword());
                    String password_hash = BCrypt.hashpw(password,BCrypt.gensalt(10));
                    String confirm = new String(regester.getjPasswordField_confirm().getPassword());
                    if(!(password.equals(confirm))){
                      JOptionPane.showMessageDialog(regester,"Mật khẩu không khớp","Vui lòng nhập lại",JOptionPane.ERROR_MESSAGE);
                    }
                    else {

                        try{
                            Session session = HibernateUties.getFACTORY().openSession();
                            session.getTransaction().begin();
                            User user = new User();
                            user.setFirst_name(first_name);
                            user.setLast_name(last_name);
                            user.setEmail(email_hash);
                            user.setPassword(password_hash);
                            session.save(user);
                            session.getTransaction().commit();
                            System.out.println(email_hash);
                            System.out.println(password_hash);
                            JOptionPane.showMessageDialog(regester, "Đăng kí Thành Công", "", JOptionPane.INFORMATION_MESSAGE);
                            regester.setVisible(false);
                            login.setVisible(true);
                            session.close();
                        } catch (Exception ex) {
                          ex.printStackTrace();
                        }
                    }
                }
                if(e.getSource() == login.getjButton_signin()) {
                    String email = String.valueOf(login.getjTextField_username().getText());
                    chatRoom.setId_hash(email);
                    String password = new String(login.getjPasswordField1().getPassword());

                    Session session = HibernateUties.getFACTORY().openSession();
                    Query query = session.createQuery("FROM User");
                    List<User> users = query.getResultList();
                    try {
                        for (User user : users) {
                            if (BCrypt.checkpw(password, user.getPassword()) && BCrypt.checkpw(email, user.getEmail())) {

                                JOptionPane.showMessageDialog(login, "Đăng nhập thành công", "", JOptionPane.INFORMATION_MESSAGE);
                                login.setVisible(false);
                                chatRoom.setVisible(true);
                                if(user.getAvatar()!=null){
                                    String avatar = user.getAvatar();
                                    chatRoom.getjLabel1().setIcon(new ImageIcon(avatar));
                                }
                                client.loadMessage();
                                chatRoom.getjLabel2().setText(user.getFirst_name());
                                client.getName(user.getFirst_name());
                                chatRoom.setId(user.getEmail());
                                break; // Thoát khỏi vòng lặp khi tìm thấy người dùng khớp
                            }
                        }
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(login, "Sai email hoặc mật khẩu", "", JOptionPane.ERROR_MESSAGE);
                    }
                    session.close();
                }
                if(e.getSource()==chatRoom.getjButton2()){
                    client.sendMessage();
                }
                if(e.getSource()==chatRoom.getjTextField1()){
                    client.sendMessage();
                }

            }
        };
        login.getjButton_regester().addActionListener(ac);
        regester.getjButton1().addActionListener(ac);
        login.getjButton_signin().addActionListener(ac);
        chatRoom.getjButton2().addActionListener(ac);
        chatRoom.getjButton2().addActionListener(ac);
        chatRoom.getjTextField1().addActionListener(ac);
    }
}
