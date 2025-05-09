package banco;

public class ContaCorrente extends Conta {

    private double chequeEspecial;

    public ContaCorrente(double saldoinicial, double chequeEspecial) {
        super(saldoinicial);
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(double saldoinical) {
        this(saldoinical, 0.0);
    }

    public boolean sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            this.saldo -= valor;
            return true;
        }
        else
            return false;
    }
}
