package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2]) ));
                line = br.readLine();
            }

            List<String> emails = list.stream()
                            .filter(e -> e.getSalary() > salary)
                                .map(e -> e.getEmail())
                                    .sorted()
                                        .toList();

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
            emails.forEach(System.out::println);

            double sum = list.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                        .map(e -> e.getSalary())
                            .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary whose name starts with 'M': " + String.format("%.2f", sum));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}