package application;


import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        int numero = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double valor = sc.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();
        sc.nextLine();

        Contract obj = new Contract(numero, data, valor);

        ContractService service = new ContractService(new PaypalService());

        service.processContract(obj, n);

        System.out.println("PARCELAS: ");
        for (Installment installment : obj.getInstallment()) {
            System.out.println(installment.toString());
        }
    }
}