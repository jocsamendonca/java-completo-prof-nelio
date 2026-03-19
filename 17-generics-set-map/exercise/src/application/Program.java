package application;

import entities.Students;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    static void main() {
        Scanner sc = new Scanner(System.in);

        Set<Students> std = new HashSet<>();

        System.out.print("How many students for course A? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            std.add(new Students(sc.nextInt()));
            sc.nextLine();
        }

        System.out.print("How many students for course B? ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            std.add(new Students(sc.nextInt()));
            sc.nextLine();
        }

        System.out.print("How many students for course C? ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            std.add(new Students(sc.nextInt()));
            sc.nextLine();
        }

        System.out.println(std.size());
        System.out.println(std);

        sc.close();
    }
}