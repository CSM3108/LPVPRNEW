import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 2 numbers to add : ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String addUrl = "http://localhost:8000/add?a=" + a + "&b=" + b;
        URL url = new URL(addUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String response = "";
        String inputLine;

        while((inputLine = in.readLine()) != null) {
            response += inputLine;
            response += "\n";
        }

        System.out.println("Response from server : " + response);

        in.close();
        scanner.close();
    }
}