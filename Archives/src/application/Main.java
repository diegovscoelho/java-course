package application;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String regex = "[,]";

        System.out.println("Enter a csv file path: ");
        String csvPath = sc.nextLine();
        String path = "C:/Users/T-GAMER/Desktop/Codes/Backend/Sources";

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            boolean success = new File(path + "/out").mkdir();

            if(success) {
                System.out.println("Diretório criado com sucesso");
                String line = br.readLine();

                File summary = new File(path + "/out/summary.csv");

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "/out/summary.csv"))) {
                    while(line != null) {
                        String[] parts = line.split(regex, 2);
                        bw.write(String.join(",", parts));

                        bw.newLine();
                        line = br.readLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}