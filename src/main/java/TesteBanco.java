import banco.*;
import java.util.Scanner;

public class TesteBanco {

    public static int resposta;

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Criando uma nova conta. Digite o saldo inicial:");
        Conta conta = new Conta(sc.nextDouble());

        do {
            System.out.println("\nDigite o número referente a operação que deseja realizar.");
            System.out.println("1 - Depositar.");
            System.out.println("2 - Sacar.");
            System.out.println("0 - Sair.");
            resposta = sc.nextInt();
            switch (resposta){
                case 1:
                    System.out.println("Digite o valor que deseja depositar: ");
                    conta.depositarValor(sc.nextDouble());
                    System.out.println("O saldo da conta é R$ " + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("\nO saldo da conta é R$ " + conta.getSaldo() + "\n");
                    System.out.println("Digite o valor que deseja sacar: ");
                    if (!conta.sacar(sc.nextDouble()))
                        System.out.println("Não foi possível realizar a operação. Valor maior do que o saldo.");
                    System.out.println("O saldo da conta é R$ " + conta.getSaldo());
                    break;
                case 0:
                    break;
            }
        } while (resposta != 0);
    }
}

