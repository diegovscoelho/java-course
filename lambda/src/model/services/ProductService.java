package model.services;

import entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product> list, Predicate<Product> criteria) {
        double sum = 0.0;
        for(Product p : list) {
            if(p.getName().charAt(0) == 'T') {
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
