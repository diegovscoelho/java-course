package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        Vehicle vehicle = new Vehicle(carModel);

        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        String pickTime = sc.nextLine();
        LocalDateTime start = LocalDateTime.parse(pickTime, formatter);

        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        String retTime = sc.nextLine();
        LocalDateTime finish = LocalDateTime.parse(retTime, formatter);

        CarRental cr = new CarRental(start, finish, vehicle);

        System.out.print("Enter price per hour: ");
        Double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        Double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

    }
}