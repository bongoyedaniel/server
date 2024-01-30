package bongoye;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class server {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 1);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }
}
