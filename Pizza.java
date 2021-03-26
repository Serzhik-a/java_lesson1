package ru.home;

import java.util.Scanner;

public class Pizza {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you wanna pizza? y/n: ");
        String inputstring = scanner.nextLine();
        switch (inputstring.toLowerCase()) {
            case ("y"): {
                System.out.println("I`m a cooking now");
                Thread.sleep(5000);
                System.out.println("Your pizza is ready! Bon apetite.");
                break;
            }
            case ("n"): {
                System.out.println("Goodbye!");
                break;
            }
            default:
                System.out.println("Incorrect input");
        }
    }
}
