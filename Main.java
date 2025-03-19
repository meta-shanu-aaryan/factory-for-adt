package FactoryADT;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public int intScanner() {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                n = sc.nextInt();
                if (n >= 0) {
                    break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Enter integer value only");
            }
        }
        sc.close();
        return n;
    }

    public double doubleScanner() {
        Scanner sc = new Scanner(System.in);
        double n;
        while (true) {
            try {
                n = sc.nextDouble();
                if (n >= 0) {
                    break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Enter integer value only");
            }
        }

        sc.close();
        return n;
    }

    public static void main(String[] args) {

    }
}
