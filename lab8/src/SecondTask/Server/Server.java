package SecondTask.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int port = 4004;
    public static LinkedList<ServerThread> serverThreads = new LinkedList<>();
    public static MessageStory messageStory;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        messageStory = new MessageStory();
        System.out.println("Server is listening on port " + port);
        try {
            while (true) {
                //ожидание клиента
                Socket socket = server.accept();    //ожидание поступления запроса
                try {
                    //создание отдельного потока для обмена данными с соед-ся клиентом и запуск потока
                    serverThreads.add(new ServerThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}
