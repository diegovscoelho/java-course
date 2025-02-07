package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setC = new HashSet<>();
        Scanner input = new Scanner(System.in);

        System.out.print("How many students for course A? ");
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            Integer student = input.nextInt();
            setA.add(student);
        }

        System.out.print("How many students for course B? ");
        n = input.nextInt();
        for(int i = 0; i < n; i++) {
            Integer student = input.nextInt();
            setB.add(student);
        }

        System.out.print("How many students for course C? ");
        n = input.nextInt();
        for(int i = 0; i < n; i++) {
            Integer student = input.nextInt();
            setC.add(student);
        }

        Set<Integer> totalSet = new HashSet<>(setA);
        totalSet.addAll(setB);
        totalSet.addAll(setC);

        System.out.println("Total students: " + totalSet.size());

        input.close();
    }
}