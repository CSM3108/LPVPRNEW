import java.io.*;
import java.net.*;
import java.time.Instant;
import java.time.ZoneId;

public class Master {
    public static void main(String[] args) {
        System.out.println("=== Time Daemon (Master) Running ===");

        try(ServerSocket serverSocket = new ServerSocket(6000)) {
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Polling a slave");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                long masterTime = System.currentTimeMillis();
                System.out.println("Master Time: " + Instant.ofEpochMilli(masterTime).atZone(ZoneId.systemDefault()));

                long slaveTime = in.readLong();
                System.out.println("Received Slave Time: " + Instant.ofEpochMilli(slaveTime).atZone(ZoneId.systemDefault()));

                long averageTime = (masterTime + slaveTime) / 2;
                long masterOffset = averageTime - masterTime;
                long slaveOffset = averageTime - slaveTime;

                out.writeLong(slaveOffset);

                System.out.println("Master Time after sync : " + Instant.ofEpochMilli(masterTime + masterOffset).atZone(ZoneId.systemDefault()));
                System.out.println("Slave Time after sync : " + Instant.ofEpochMilli(slaveTime + slaveOffset).atZone(ZoneId.systemDefault()));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
