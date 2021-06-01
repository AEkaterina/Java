package ThirdTask;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Send {
    private DatagramSocket socket;

    public Send (int port) throws SocketException {
        socket = new DatagramSocket();
    }

    public void sendMessage(String message, int port) throws IOException {
        DatagramPacket mes = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getLocalHost(), port);
        socket.send(mes);       //отправить дейтаграмму, упаков в пакет
    }

    public static void main(String[] args) throws IOException {
        Send s = new Send(2097);
        s.sendMessage("Hello!", 5319);
    }
}
