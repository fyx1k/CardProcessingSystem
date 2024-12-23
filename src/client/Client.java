package client;

import server.CardService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CardService cardService = (CardService) registry.lookup("CardService");

            // Пример операций
            cardService.registerCard("123456", 100.0);
            cardService.addFunds("123456", 50.0);
            cardService.makePayment("123456", 30.0);
            double balance = cardService.getBalance("123456");
            System.out.println("Balance for card 123456: " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
