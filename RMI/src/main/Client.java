package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ServerInterface stub = (ServerInterface) registry.lookup("OperationService");

            Scanner sc = new Scanner(System.in);
            int choice;

            while(true){
                System.out.println("\n===== MENU =====");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Power of 2");
                System.out.println("6. Celsius to Fahrenheit");
                System.out.println("7. Miles to Kilometers");
                System.out.println("8. Echo Server");
                System.out.println("9. Compare Strings");
                System.out.println("10. Count Vowels");
                System.out.println("11. Factorial");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter two numbers: ");
                        int a1 = sc.nextInt();
                        int b1 = sc.nextInt();
                        System.out.println("Result: " + stub.add(a1, b1));
                        break;

                    case 2:
                        System.out.print("Enter two numbers: ");
                        int a2 = sc.nextInt();
                        int b2 = sc.nextInt();
                        System.out.println("Result: " + stub.subtract(a2, b2));
                        break;

                    case 3:
                        System.out.print("Enter two numbers: ");
                        int a3 = sc.nextInt();
                        int b3 = sc.nextInt();
                        System.out.println("Result: " + stub.multiply(a3, b3));
                        break;

                    case 4:
                        System.out.print("Enter two numbers: ");
                        int a4 = sc.nextInt();
                        int b4 = sc.nextInt();
                        System.out.println("Result: " + stub.divide(a4, b4));
                        break;

                    case 5:
                        System.out.print("Enter number: ");
                        int p = sc.nextInt();
                        System.out.println("Result: " + stub.powerCalculation(p));
                        break;

                    case 6:
                        System.out.print("Enter Celsius: ");
                        float c = sc.nextFloat();
                        System.out.println("Result: " + stub.celsiusToFahrenheit(c));
                        break;

                    case 7:
                        System.out.print("Enter Miles: ");
                        float m = sc.nextFloat();
                        System.out.println("Result: " + stub.milesToKilometers(m));
                        break;

                    case 8:
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.println(stub.echoServer(name));
                        break;

                    case 9:
                        sc.nextLine();
                        System.out.print("Enter first string: ");
                        String s1 = sc.nextLine();
                        System.out.print("Enter second string: ");
                        String s2 = sc.nextLine();
                        System.out.println("Result: " + stub.stringComparison(s1, s2));
                        break;

                    case 10:
                        sc.nextLine();
                        System.out.print("Enter string: ");
                        String str = sc.nextLine();
                        System.out.println("Vowels: " + stub.vowelCount(str));
                        break;

                    case 11:
                        System.out.print("Enter number: ");
                        int n = sc.nextInt();
                        System.out.println("Result: " + stub.factorial(n));
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
