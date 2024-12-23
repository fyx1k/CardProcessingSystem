package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CardService extends Remote {
    void registerCard(String cardNumber, double balance) throws RemoteException;
    void addFunds(String cardNumber, double amount) throws RemoteException;
    void makePayment(String cardNumber, double amount) throws RemoteException;
    double getBalance(String cardNumber) throws RemoteException;
}