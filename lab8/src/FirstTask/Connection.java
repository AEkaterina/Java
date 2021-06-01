package FirstTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Connection {

    InetAddress currentIP = null;

    //ip текущего компа
    public void getLocalHost() {
        try {
            currentIP = InetAddress.getLocalHost();
            //вывод IP-адреса локального компьютера
            System.out.println("IP-> " + currentIP.getHostAddress());
        } catch(UnknownHostException e) {
            //если не найден IP
            System.err.println("Адрес недоступен " + e);
        }
    }

    //ip-адр по имени компьютера
    public void getByName(String host) {
        try {
            InetAddress pageIP = InetAddress.getByName(host);
            System.out.println("google.com-> " + pageIP.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println(e);
        }
    }

    //имя компа по ip-адресу
    public void getByAddress(String name, byte[] addr) {
        try{
            InetAddress pageIP = InetAddress.getByAddress(name, addr);
            System.out.println(pageIP.isReachable(100));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //чтение HTML по URL
    public void readHTML(String URL) {
        try {
            URL url = new URL(URL);
            try(BufferedReader reader = new BufferedReader(new InputStreamReader((url.openStream())))) {
                String HTMLLine = "";
                while ((HTMLLine = reader.readLine()) != null) {
                    System.out.println(HTMLLine);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch(MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    //информация о соединении
    public void getInfo(String UrlName) {
        int timeout = 10_000;
        try {
            URL url = new URL(UrlName);
            final URLConnection connection = url.openConnection();
            //установка таймаута на соединение
            connection.setConnectTimeout(timeout);
            System.out.println(UrlName + " content type: " +
                    "\n" + connection.getContentType() +
                    "\n" + connection.getClass() +
                    "\n" + connection.getContentLength());
            //продолжение извлечения инфы из соединения
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
