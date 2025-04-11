import banco.*;
import java.util.Scanner;

public class TesteBanco {

    public static int resposta;

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Criando o cliente.\nDigite o nome:");
        String nome = sc.nextLine();
        System.out.println("Digite o sobrenome:");
        String sobrenome = sc.nextLine();
        Cliente cliente = new Cliente(nome, sobrenome);

        System.out.println("Criando uma conta para o cliente " + nome + " " + sobrenome);
        System.out.println("Digite o saldo da conta: ");
        cliente.setConta(new Conta(sc.nextDouble()));
        Conta conta = cliente.getConta();

        do {
            System.out.println("\nDigite o número referente a operação que deseja realizar.");
            System.out.println("1 - Depositar.");
            System.out.println("2 - Sacar.");
            System.out.println("0 - Sair.");
            resposta = sc.nextInt();
            switch (resposta){
                case 1:
                    System.out.println("Digite o valor que deseja depositar: ");
                    conta.depositar(sc.nextDouble());
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("\nO saldo da conta é R$ " + conta.getSaldo() + "\n");
                    System.out.println("Digite o valor que deseja sacar: ");
                    if (!conta.sacar(sc.nextDouble()))
                        System.out.println("Não foi possível realizar a operação. Valor maior do que o saldo.");
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    break;
                case 0:
                    break;
            }
        } while (resposta != 0);
    }
}

