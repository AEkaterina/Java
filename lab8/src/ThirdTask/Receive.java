package ThirdTask;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
    private DatagramSocket socket;
    private byte[] message = new byte[10];

    public Receive(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void receiveMessage() throws IOException {
        socket.receive(new DatagramPacket(message, 10));   //дождаться получения дейтаграммы и отправить в пакет
        String mes = new String(message);
        System.out.println(mes);
    }

    public static void main(String[] args) throws IOException {
        Receive receive = new Receive(5319);
        while (true) {
            receive.receiveMessage();
        }
    }
}
