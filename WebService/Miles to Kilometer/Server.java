import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

public class Server {

    public static void main(String[] args) throws Exception {

        HttpServer server =
                HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/convert", new MilesHandler());

        server.setExecutor(null);

        System.out.println("=== Miles Converter Running ===");

        server.start();
    }
}