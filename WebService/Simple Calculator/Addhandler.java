import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.*;


public class Addhandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();

        String[] args = query.split("&");

        int a = Integer.parseInt(args[0].split("=")[1]);
        int b = Integer.parseInt(args[1].split("=")[1]);

        int result = a + b;
        String response = "Addition result = " + result;

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());

        os.close();
    }
}
