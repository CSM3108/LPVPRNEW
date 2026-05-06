import java.io.*;
import java.net.*;
import java.time.Instant;
import java.time.ZoneId;

public class Slave {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 6000)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // add 2 seconds for simulating clock difference
            long myTime = System.currentTimeMillis() + 2000;
            System.out.println("Current System Time : " + Instant.ofEpochMilli(myTime).atZone(ZoneId.systemDefault()));

            out.writeLong(myTime);
            long offset = in.readLong();

            System.out.println("Sync Time after adjustment : " + Instant.ofEpochMilli(myTime + offset).atZone(ZoneId.systemDefault()));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
