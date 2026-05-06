package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try{
            ServerInterface obj = new ServerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("OperationService", obj);

            System.out.println("=== Server Started ===");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
