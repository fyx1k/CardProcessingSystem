package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            CardService cardService = new CardServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CardService", cardService);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}