import banco.*;
import java.util.Scanner;

public class TesteBanco {

    public static int resposta1;
    public static int resposta2;
    public static int resposta3;
    public static int resposta4;
    public static int indice;
    public static int indice2;

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        Banco banco = new Banco();

        do {
            System.out.println("\nDigite o número referente a operação que deseja realizar.");
            System.out.println("1 - Criar novo cliente.");
            System.out.println("2 - Alterar contas de um cliente.");
            System.out.println("0 - Sair.");
            resposta1 = sc.nextInt();
            switch (resposta1){
                case 1:
                    if (banco.getNumeroDeClientes() < 5) {
                        System.out.println("Criando o cliente.\nDigite o nome:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.println("Digite o sobrenome:");
                        String sobrenome = sc.nextLine();
                        Cliente cliente = new Cliente(nome, sobrenome);

                        System.out.println("\nDigite o número referente à operação desejada.");
                        System.out.println("1 - Criar nova conta para o cliente.");
                        System.out.println("2 - Conjugar com uma conta já existente");
                        resposta3 = sc.nextInt();
                        sc.nextLine();

                        switch (resposta3) {
                            case 1:
                                System.out.println("\nDigite o número referente ao tipo de conta a ser criada.");
                                System.out.println("1 - Conta Poupança.");
                                System.out.println("2 - Conta Corrente.");
                                System.out.println("0 - Voltar.");
                                resposta2 = sc.nextInt();
                                sc.nextLine();

                                switch (resposta2) {
                                    case 1:
                                        System.out.println("Criando uma conta poupança para o cliente " + nome + " " + sobrenome);
                                        System.out.println("Digite o saldo da conta: ");
                                        double saldoincial = sc.nextDouble();
                                        System.out.println("Digite a taxa de rendimento: ");
                                        double rendimento = sc.nextDouble();
                                        cliente.adicionarConta(new ContaPoupanca(saldoincial, rendimento));

                                        banco.adicionarCliente(cliente);
                                        break;
                                    case 2:
                                        System.out.println("Criando uma conta corrente para o cliente " + nome + " " + sobrenome);
                                        System.out.println("Digite o saldo da conta: ");
                                        saldoincial = sc.nextDouble();
                                        System.out.println("Digite o valor do cheque especial: ");
                                        double chequeEspecial = sc.nextDouble();
                                        cliente.adicionarConta(new ContaCorrente(saldoincial, chequeEspecial));

                                        banco.adicionarCliente(cliente);
                                        break;
                                    case 0:
                                        break;
                                }
                                break;
                            case 2:
                                if (banco.getNumeroDeClientes() > 0) {
                                    System.out.println("\nDigite o número referente ao cliente com o qual deseja criar uma conta conjugada.");
                                    for (indice = 0; indice < banco.getNumeroDeClientes(); indice++) {
                                        System.out.println("Cliente " + (indice + 1) + " - " + banco.getCliente(indice).getNome()
                                                + " " + banco.getCliente(indice).getSobrenome() + ".");
                                    }
                                    indice = (sc.nextInt() - 1);
                                } else {
                                    System.out.println("Não há clientes.");
                                    break;
                                }

                                if (banco.getCliente(indice).getNumeroDeContas() > 0) {
                                    System.out.println("\nDigite o número referente a conta a conjugar.");
                                    for (indice2 = 0; indice2 < banco.getCliente(indice).getNumeroDeContas(); indice2++) {
                                        System.out.print("Conta " + (indice2 + 1) + " - ");
                                        if (banco.getCliente(indice).getConta(indice2) instanceof ContaCorrente) {
                                            System.out.println("Conta Corrente");
                                        }
                                        else {
                                            System.out.println("Conta Poupança");
                                        }
                                    }
                                    indice2 = (sc.nextInt() - 1);
                                    cliente.adicionarConta(banco.getCliente(indice).getConta(indice2));

                                    banco.adicionarCliente(cliente);
                                } else {
                                    System.out.println("Não há contas.");
                                    break;
                                }
                                break;
                        }
                    }
                    else
                        System.out.println("Número máximo de clientes atingidos");
                    break;
                case 2:
                    if (banco.getNumeroDeClientes() > 0) {
                        System.out.println("\nDigite o número referente ao cliente.");
                        for (indice = 0; indice < banco.getNumeroDeClientes(); indice++) {
                            System.out.println("Cliente " + (indice + 1) + " - " + banco.getCliente(indice).getNome()
                                    + " " + banco.getCliente(indice).getSobrenome() + ".");
                        }
                        indice = (sc.nextInt() - 1);
                    } else {
                        System.out.println("Não há clientes.");
                        break;
                    }
                    
                    System.out.println("\nDigite o número referente a operação que deseja realizar.");
                    System.out.println("1 - Criar nova conta para o cliente.");
                    System.out.println("2 - Alterar contas existentes de um cliente.");
                    System.out.println("0 - Voltar.");
                    resposta3 = sc.nextInt();
                    
                    switch (resposta3) {
                        case 1:
                            System.out.println("\nDigite o número referente ao tipo de conta a ser criada.");
                            System.out.println("1 - Conta Poupança.");
                            System.out.println("2 - Conta Corrente.");
                            System.out.println("0 - Voltar.");
                            resposta4 = sc.nextInt();
                            sc.nextLine();

                            switch (resposta4) {
                                case 1:
                                    System.out.println("Criando uma conta poupança para o cliente " +
                                            banco.getCliente(indice).getNome() + " " + banco.getCliente(indice).getSobrenome());
                                    System.out.println("Digite o saldo da conta: ");
                                    double saldoincial = sc.nextDouble();
                                    System.out.println("Digite a taxa de rendimento: ");
                                    double rendimento = sc.nextDouble();
                                    banco.getCliente(indice).adicionarConta(new ContaPoupanca(saldoincial, rendimento));

                                    break;
                                case 2:
                                    System.out.println("Criando uma conta corrente para o cliente " +
                                            banco.getCliente(indice).getNome() + " " + banco.getCliente(indice).getSobrenome());
                                    System.out.println("Digite o saldo da conta: ");
                                    saldoincial = sc.nextDouble();
                                    System.out.println("Digite o valor do cheque especial: ");
                                    double chequeEspecial = sc.nextDouble();
                                    banco.getCliente(indice).adicionarConta(new ContaCorrente(saldoincial, chequeEspecial));

                                    break;
                                case 0:
                                    break;
                            }
                        case 2:
                            if (banco.getNumeroDeClientes() > 0) {
                                System.out.println("\nDigite o número referente ao cliente.");
                                for (indice = 0; indice < banco.getNumeroDeClientes(); indice++) {
                                    System.out.println("Cliente " + (indice + 1) + " - " + banco.getCliente(indice).getNome()
                                            + " " + banco.getCliente(indice).getSobrenome() + ".");
                                }
                                indice = (sc.nextInt() - 1);
                            } else {
                                System.out.println("Não há outros clientes.");
                                break;
                            }

                            if (banco.getCliente(indice).getNumeroDeContas() > 0) {
                                System.out.println("\nDigite o número referente a conta.");
                                for (indice2 = 0; indice2 < banco.getCliente(indice).getNumeroDeContas(); indice2++) {
                                    System.out.print("Conta " + (indice2 + 1) + " - ");
                                    if (banco.getCliente(indice).getConta(indice2) instanceof ContaCorrente) {
                                        System.out.println("Conta Corrente");
                                    }
                                    else {
                                        System.out.println("Conta Poupança");
                                    }
                                }
                                indice2 = (sc.nextInt() - 1);
                            } else {
                                System.out.println("Não há contas.");
                                break;
                            }
                            do {
                                System.out.println("\nDigite o número referente a operação que deseja realizar.");
                                System.out.println("1 - Depositar.");
                                System.out.println("2 - Sacar.");
                                System.out.println("0 - Voltar.");
                                resposta3 = sc.nextInt();

                                switch (resposta3){
                                    case 1:
                                        System.out.println("Digite o valor que deseja depositar: ");
                                        banco.getCliente(indice).getConta(indice2).depositar(sc.nextDouble());
                                        System.out.println("Saldo atual: R$ " + banco.getCliente(indice).getConta(indice2).getSaldo());
                                        break;
                                    case 2:
                                        System.out.println("\nO saldo da conta é R$ " + banco.getCliente(indice).getConta(indice2).getSaldo() + "\n");
                                        System.out.println("Digite o valor que deseja sacar: ");
                                        if (!banco.getCliente(indice).getConta(indice2).sacar(sc.nextDouble()))
                                            System.out.println("Não foi possível realizar a operação. Saldo insuficiente.");
                                        System.out.println("Saldo atual: R$ " + banco.getCliente(indice).getConta(indice2).getSaldo());
                                        break;
                                    case 0:
                                        break;
                                }
                            } while (resposta3 != 0);
                            break;
                        case 0:
                            break;
                    }
                case 0:
                    break;
            }
        } while (resposta1 != 0);
    }
}