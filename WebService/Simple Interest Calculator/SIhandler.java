import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.*;

public class SIHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getQuery();

        String[] args = query.split("&");

        double p = Double.parseDouble(args[0].split("=")[1]);
        double r = Double.parseDouble(args[1].split("=")[1]);
        double t = Double.parseDouble(args[2].split("=")[1]);

        double si = (p * r * t) / 100;

        String response = "Simple Interest = " + si;

        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());

        os.close();
    }
}