package application;

import entities.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String path = "C:/Users/T-GAMER/Desktop/Codes/Backend/Sources/out.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<User> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new User(username, moment));

                line = br.readLine();
            }

            System.out.println("Users: " + set.size());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}