package application;

import entities.Employee;
import entities.OutsorcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data:");

            System.out.print("Outsorced (y/n)? ");
            sc.nextLine();
            String outsorced = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hours: ");
            Integer hours = sc.nextInt();

            System.out.print("Value per hours: ");
            Double valuePerHour = sc.nextDouble();

            if(outsorced.equals("y")) {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                employees.add(new OutsorcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else if(outsorced.equals("n")) {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        sc.nextLine();
        System.out.println("PAYMENTS:");
        for (Employee employee: employees) {
            System.out.println(employee.getName() + " - $" + String.format("%.2f", employee.payment()));
        }

        sc.close();
    }
}