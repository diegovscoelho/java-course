package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");

            System.out.print("Common, used or imported (c/u/i): ");
            char type = sc.next().charAt(0);

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();

            sc.nextLine();
            if(type == 'c') {
                products.add(new Product(name, price));
            }  else if(type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.nextLine();
                Date manufactureDate = sdf.parse(date);
                products.add(new UsedProduct(name, price, manufactureDate));
            } else if(type == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }

            System.out.println();
            System.out.println("PRICE TAGS:");
            for(Product product: products) {
                System.out.println(product.priceTag());
            }
        }
    }
}