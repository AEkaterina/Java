package FirstTask;

import java.net.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        connection.getLocalHost();
        connection.getByName("www.google.com");
        byte ip[] = {(byte)123, (byte) 162, (byte) 204, (byte) 87};
        connection.getByAddress("Unknown", ip);
        connection.readHTML("https://www.onliner.com");
        connection.getInfo("https://www.onliner.com");
    }
}
