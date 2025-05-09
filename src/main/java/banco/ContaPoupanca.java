package banco;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(double saldoinicial, double rendimento) {
        super(saldoinicial);
        taxaRendimento = rendimento;
    }
}
