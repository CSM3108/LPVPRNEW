import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;


public class Server {
    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/add", new Addhandler());
        server.setExecutor(null);

        System.out.println("=== Simple Calculator Web Service Running ===");
        server.start();
    }
}
