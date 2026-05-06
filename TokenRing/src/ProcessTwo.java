import java.io.*;
import java.net.*;

public class ProcessTwo {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6002);

        System.out.println("Process 2: Waiting for token from Process 1");
        Socket socket = server.accept();

        DataInputStream in = new DataInputStream(socket.getInputStream());
        String token = in.readUTF();

        if(token.equals("TOKEN")){
            System.out.println("Process 2: Token received, entering Critical Section");
            Thread.sleep(2000);
        }

        System.out.println("Process 2: Work done, passing token to Process 2");
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(token);

        server.close();
        socket.close();
    }
}
