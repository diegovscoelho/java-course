package application;

import model.services.BrazilInterestService;
import model.services.InterestService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = input.nextDouble();
        System.out.print("Months: ");
        int months = input.nextInt();

        InterestService interestService = new BrazilInterestService(2.0);

        System.out.println(String.format("%. 2f", interestService.payment(amount, months)));
    }
}