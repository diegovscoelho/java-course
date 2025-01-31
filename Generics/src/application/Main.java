package application;

import services.PrintService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        PrintService ps = new PrintService();

        System.out.print("How many values? ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int value = input.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println(ps.first());

        input.close();
    }
}