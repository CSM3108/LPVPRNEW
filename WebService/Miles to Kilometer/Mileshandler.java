import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.*;

public class MilesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getQuery();

        double miles =
                Double.parseDouble(query.split("=")[1]);

        double km = miles * 1.609;

        String response =
                "Kilometers = " + km;

        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();

        os.write(response.getBytes());

        os.close();
    }
}