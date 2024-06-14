package Controller;

import Model.Client;
import Model.HibernateUties;


import View.ChatRoom;
import View.Login;
import View.Regester;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) {
        Login login = new Login();
        Regester regester = new Regester();
        ChatRoom chatRoom = new ChatRoom();
        Client client = new Client(chatRoom);

        Control control = new Control(login,regester,chatRoom, client);
        login.setVisible(true);
        try {
            client.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
