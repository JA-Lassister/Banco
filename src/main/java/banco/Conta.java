package banco;

public class Conta {

    private double saldo;

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

    public void depositarValor(double amount) {
        saldo += amount;
    }
}