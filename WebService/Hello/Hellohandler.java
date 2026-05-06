import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.*;

public class HelloHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getQuery();

        String name = query.split("=")[1];

        String response = "Hello " + name;

        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());

        os.close();
    }
}