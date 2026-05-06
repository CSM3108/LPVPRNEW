package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    int add(int a, int b) throws RemoteException;

    int subtract(int a, int b) throws RemoteException;

    int multiply(int a, int b) throws RemoteException;

    float divide(int a, int b) throws RemoteException;

    int powerCalculation(int a) throws RemoteException;

    float celsiusToFahrenheit(float c) throws RemoteException;

    float milesToKilometers(float m) throws RemoteException;

    String echoServer(String name) throws RemoteException;

    String stringComparison(String a, String b) throws RemoteException;

    int vowelCount(String s) throws RemoteException;

    int factorial(int a) throws RemoteException;
}
