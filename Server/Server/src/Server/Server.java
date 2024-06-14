package Server;

import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Server {
   private  static  final int PORT = 12345;
   private static Set<ClientInfo> clientInfos = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat server started");
        new Server().start();
    }
    public void start() {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            while (true) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                InetSocketAddress clientAddress = new InetSocketAddress(packet.getAddress(), packet.getPort());

                String[] parts = message.split(":", 2);
                String name = parts[0].trim();
                String text = parts.length > 1 ? parts[1].trim() : "";

                synchronized (clientInfos) {
                    clientInfos.add(new ClientInfo(name, clientAddress));
                    for (ClientInfo clientInfo : clientInfos) {
                        if (!clientInfo.getAddress().equals(clientAddress)) {
                            String sendMessage = name + ": " + text;
                            byte[] sendBuf = sendMessage.getBytes();
                            DatagramPacket sendPacket = new DatagramPacket(
                                    sendBuf, sendBuf.length, clientInfo.getAddress().getAddress(), clientInfo.getAddress().getPort());
                            socket.send(sendPacket);
                        }
                    }
                }

                System.out.println("Received from " + name + ": " + text + " from " + clientAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
private static class ClientInfo {
    private String name;
    private InetSocketAddress address;

    public ClientInfo(String name, InetSocketAddress address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInfo that = (ClientInfo) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
}