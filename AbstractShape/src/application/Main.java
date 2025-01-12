package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data:");
            System.out.print("Rectangle or circle (r/c)? ");
            char shape = sc.next().charAt(0);

            System.out.print("Color (BLACK/BLUE/RED): ");
            sc.nextLine();
            String color = sc.nextLine();

            if(shape == 'r') {
                System.out.print("Width: ");
                Double width = sc.nextDouble();
                System.out.print("Height: ");
                Double height = sc.nextDouble();

                shapes.add(new Rectangle(Color.valueOf(color), width, height));
            } else if(shape == 'c') {
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();
                shapes.add(new Circle(Color.valueOf(color), radius));
            }
        }

        System.out.println();
        System.out.println("SHAPE AREAS:");
        for(Shape shape: shapes) {
            System.out.printf("%.2f%n", shape.area());
        }
    }
}