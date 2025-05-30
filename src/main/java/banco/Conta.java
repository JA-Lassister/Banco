package banco;

public abstract class Conta {

    protected double saldo;

    public Conta(double saldoInicial) {
        saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if(valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(double amount) {
        saldo += amount;
        return true;
    }
}