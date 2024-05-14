package banco;

import java.util.Scanner;

public class ContaBancaria {

    private int numeroConta;
    private String agencia;
    private String nomeCliente;
    private double saldo;
    
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    
   

    public ContaBancaria(int numeroConta, String agencia, String nomeCliente, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldoInicial;
    }
    
    public String obterMensagemBoasVindas() {
        return "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque.";
    }


    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    public void verificarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = null;

        System.out.println("Bem-vindo ao Banco XYZ!");
        System.out.println("Digite o saldo inicial da conta:");
        double saldoInicial = scanner.nextDouble();
        conta = new ContaBancaria(saldoInicial);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Verificar saldo");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o saldo inicial da nova conta:");
                    double novoSaldoInicial = scanner.nextDouble();
                    conta = new ContaBancaria(novoSaldoInicial);
                    System.out.println("Nova conta criada com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o valor para depósito:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o valor para saque:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    conta.verificarSaldo();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
