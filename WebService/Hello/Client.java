import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name : ");
        String name = scanner.nextLine();

        String urlString =
                "http://localhost:8000/hello?name=" + name;

        URL url = new URL(urlString);

        HttpURLConnection con =
                (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(con.getInputStream()));

        String response;

        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }

        in.close();
        scanner.close();
    }
}