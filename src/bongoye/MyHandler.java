package bongoye;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler implements HttpHandler {

    static String serverWebPath = "D:/JavaProjects/server/src/bongoye/web";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        /////////
        InputStream is = exchange.getRequestBody();
        StringBuilder sb = new StringBuilder();

        new BufferedReader(new InputStreamReader(is)).lines().forEach((String s) -> sb.append(s + "\n"));
        String[] s1 = exchange.getRequestURI().toString().split("\n");
        System.out.println("["+s1[0]+"]");

        if (s1[0] == "/" || s1[0] == "//" || s1[0].length() == 1)
            s1[0] = "/index.html";
        /////////
        
        String response = reader.read(serverWebPath + s1[0]);
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}

class reader {
    public static String read(String filePath) {
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String output = null;

            while ((output = br.readLine()) != null) {
                str = str + output;
            }

            br.close();
        } catch (Exception e) {
            str = read(MyHandler.serverWebPath+"/error.html");
        }
        return str;
    }
}
