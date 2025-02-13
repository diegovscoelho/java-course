package application;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        String path = "C:\\Users\\T-GAMER\\Desktop\\Codes\\Backend\\Sources\\out.txt";
        List<Product> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String regex = ",";
            String line = br.readLine();
            while(line != null) {

                String[] fields = line.split(regex);

                list.add(new Product(fields[0], Double.parseDouble(fields[1])));

                line = br.readLine();
            }

            double sum = list.stream().mapToDouble(x -> x.getPrice()).sum();
            System.out.println("Average price: " + String.format("%.2f", sum / list.size()));

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> filteredNames = list.stream().filter(p -> p.getPrice() < 420).map(p -> p.getName()).sorted(comp).collect(Collectors.toList());
            filteredNames.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}