package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double valorBaseParcela = contract.getTotalValue() / months;

        double parcelaCapitalizada;
        Installment installment;

        for (int i = 1; i <= months; i++) {
            parcelaCapitalizada = onlinePaymentService.paymentFee(valorBaseParcela);
            parcelaCapitalizada += onlinePaymentService.interest(parcelaCapitalizada, i);

            contract.getInstallment().add(new Installment(contract.getDate().plusMonths(i), parcelaCapitalizada));
        }
    }
}
