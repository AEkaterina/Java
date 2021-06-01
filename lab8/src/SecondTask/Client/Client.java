package SecondTask.Client;

public class Client {
    private static final String IPAddress = "localhost";
    private static final int port = 4004;

    public static void main(String[] args) {
        new ClientThread(IPAddress, port);
    }
}
