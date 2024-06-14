package Model;

import View.ChatRoom;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private DatagramSocket socket;
    private InetAddress serverAddress;
    private ChatRoom chatRoom;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    private String clientName;


    public Client(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }


    public String getName(String name) {
        this.clientName = name;
        return clientName;
    }






    public void sendMessage() {
        String newnickname = chatRoom.getNewnickname();
        if (newnickname != null) {
            clientName = newnickname;
        }

        String message = chatRoom.getjTextField1().getText();
        if (!message.isEmpty()) {
            try {
                String fullMessage = clientName + " : " + message;
                byte[] buf = fullMessage.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SERVER_ADDRESS), SERVER_PORT);
                socket.send(packet);
                appendMessage("You : " + message, false);
                chatRoom.getjTextField1().setText("");
                saveMessage(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveMessage(String massage){
        try {
            FileWriter fileWriter = new FileWriter("text.txt",true);
            BufferedWriter bf = new BufferedWriter(fileWriter);
            bf.write("You : "+ massage);
            bf.newLine();
            bf.close();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadMessage(){
        try {
            FileReader fileReader = new FileReader("text.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line=bufferedReader.readLine())!=null){
                appendMessage(line,true);

            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void appendMessage(String message, boolean isReceived) {
        String alignment = isReceived ? "left" : "right";
        String styledMessage = String.format("<div style='text-align: %s;'>%s</div>", alignment, message);
        HTMLDocument doc = (HTMLDocument) chatRoom.getjTextArea1().getDocument();
        HTMLEditorKit editorKit = (HTMLEditorKit) chatRoom.getjTextArea1().getEditorKit();
        try {
            editorKit.insertHTML(doc, doc.getLength(), styledMessage, 0, 0, null);
        } catch (BadLocationException | IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        socket = new DatagramSocket();
        serverAddress = InetAddress.getByName(SERVER_ADDRESS);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        chatRoom.getjTextField1().setEditable(true);
        new Thread(() -> {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                while (true) {
                    socket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    appendMessage(message, true);
                    saveMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
