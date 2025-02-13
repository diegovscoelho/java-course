package application;

import entities.Product;
import model.services.ProductService;
import util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 80.90));
        list.add(new Product("Mouse", 49.90));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.println("Filtered sum: " + String.format("%.2f", sum));
    }

}