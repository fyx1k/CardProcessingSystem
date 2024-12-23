package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CardServiceImpl extends UnicastRemoteObject implements CardService {
    private Map<String, Double> cardBalances;

    protected CardServiceImpl() throws RemoteException {
        cardBalances = new HashMap<>();
    }

    @Override
    public void registerCard(String cardNumber, double balance) throws RemoteException {
        cardBalances.put(cardNumber, balance);
        System.out.println("Card registered: " + cardNumber + " with balance: " + balance);
    }

    @Override
    public void addFunds(String cardNumber, double amount) throws RemoteException {
        cardBalances.put(cardNumber, cardBalances.getOrDefault(cardNumber, 0.0) + amount);
        System.out.println("Funds added to card: " + cardNumber + ", new balance: " + cardBalances.get(cardNumber));
    }

    @Override
    public void makePayment(String cardNumber, double amount) throws RemoteException {
        double currentBalance = cardBalances.getOrDefault(cardNumber, 0.0);
        if (currentBalance >= amount) {
            cardBalances.put(cardNumber, currentBalance - amount);
            System.out.println("Payment made from card: " + cardNumber + ", new balance: " + cardBalances.get(cardNumber));
        } else {
            System.out.println("Insufficient balance for card: " + cardNumber);
        }
    }

    @Override
    public double getBalance(String cardNumber) throws RemoteException {
        return cardBalances.getOrDefault(cardNumber, 0.0);
    }
}