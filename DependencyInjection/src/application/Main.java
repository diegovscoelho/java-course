package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        Integer number = input.nextInt();
        input.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        String dateString = input.nextLine();
        LocalDate date = LocalDate.parse(dateString, formatter);

        System.out.print("Valor do contrato: ");
        Double totalValue = input.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Entre com o número de parcelas: ");
        Integer numInstallments = input.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, numInstallments);

        System.out.println("Parcelas:");
        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        input.close();
    }
}
