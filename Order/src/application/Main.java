package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();
        Client client = new Client(name, email, sdf.parse(birthDate));
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.nextLine();

        Order order = new Order(new Date(), OrderStatus.valueOf(status));

        System.out.print("How many items in this order? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, price);
            orderItem.setProduct(product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.print("Order moment: " + sdf2.format(order.getMoment()) + "\n");
        System.out.print("Order status: " + order.getStatus() + "\n");
        System.out.print("Client: " + name + " (" + birthDate + ")" + " - " + email + "\n");
        System.out.println("Order items:");
        for (OrderItem item: order.getOrderItems()) {
            System.out.print(item);
        }
        System.out.println("Total price: " + String.format("%.2f", order.total()));


        sc.close();
    }
}