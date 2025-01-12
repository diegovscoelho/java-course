package application;

import entities.Pagadores;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pagadores> pagadores = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ic = sc.next().charAt(0);

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();

            if (ic == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                pagadores.add(new PessoaFisica(name, annualIncome, healthExpenditures));
            } else if (ic == 'c') {
                System.out.print("Number of employees: ");
                Integer employeeNum = sc.nextInt();
                pagadores.add(new PessoaJuridica(name, annualIncome, employeeNum));
            }
        }

            System.out.println();
            System.out.println("TAXES PAID: ");
            double sum = 0;
            for(Pagadores pagador: pagadores) {
                System.out.println(pagador.getName() + ": $" + String.format("%.2f", pagador.calcImposto()));
                sum += pagador.calcImposto();
            }

            System.out.println();
            System.out.println("TOTAL TAXES: ");
            System.out.println("$" + sum);
    }
}
