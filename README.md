## Server

A java implemented web server.

## Folder Structure

The workspace contains folder(s):

- `web`: place all html/web files here

## Usage

``` java
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

```

`myHandler` takes care of POST/GET or page requests
## To do

Can't host php directly 
