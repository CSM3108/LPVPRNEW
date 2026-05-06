import java.io.*;
import java.net.*;

public class ProcessOne {
    public static void main(String[] args) throws Exception {
        String machine2IP = "localhost";
        ServerSocket server = new ServerSocket(6001);

        String token = "TOKEN";

        System.out.println("Process 1: Token present, entering Critical Section");
        Thread.sleep(2000);

        System.out.println("Process 1: Work done, passing token to Process 2");
        Socket socket = new Socket(machine2IP, 6002);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(token);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        token = in.readUTF();

        System.out.println("Process 1: Token received back, ring complete " + token);
        server.close();
        socket.close();
    }
}
