package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    protected ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        System.out.println("Request received: " + a + " + " + b);
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        System.out.println("Request received: " + a + " - " + b);
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        System.out.println("Request received: " + a + " x " + b);
        return a * b;
    }

    @Override
    public float divide(int a, int b) throws RemoteException {
        System.out.println("Request received: " + a + " / " + b);
        if(b == 0) throw new IllegalArgumentException("zero cannot be used as denominator");
        return (float)a / b;
    }

    @Override
    public int powerCalculation(int a) throws RemoteException {
        return (int)Math.pow(2, a);
    }

    @Override
    public float celsiusToFahrenheit(float c) throws RemoteException {
        return ((float)9/5 * c) + 32;
    }

    @Override
    public float milesToKilometers(float m) throws RemoteException {
        return (float)(m * 1.6);
    }

    @Override
    public String echoServer(String name) throws RemoteException {
        return "Hello " + name;
    }

    @Override
    public String stringComparison(String a, String b) throws RemoteException {
        return a.compareTo(b) > 0 ? a : b;
    }

    @Override
    public int vowelCount(String s) throws RemoteException {
        int count = 0;
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    @Override
    public int factorial(int a) throws RemoteException {
        if(a < 0) throw new IllegalArgumentException("cannot calculate factorial of negative numbers");
        int fact = 1;
        for(int i=1; i<=a; i++){
            fact *= i;
        }
        return fact;
    }
}
