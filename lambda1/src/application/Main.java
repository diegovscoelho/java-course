package application;

import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 80.90));
        list.add(new Product("Mouse", 49.90));

        double min = 100.00;

        Predicate<Product> pred = p -> p.getPrice() >= min;

        list.removeIf(pred);

        for(Product p : list) {
            System.out.println(p);
        }
    }

}