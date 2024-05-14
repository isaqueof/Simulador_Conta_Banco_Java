package banco;

import java.util.Scanner;

public class ContaTerminal {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Por favor, digite o número da Agência:");
	        String agencia = scanner.nextLine();

	        System.out.println("Por favor, digite o número da Conta:");
	        int numeroConta = scanner.nextInt();
	        scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

	        System.out.println("Por favor, digite o nome do Cliente:");
	        String nomeCliente = scanner.nextLine();

	        System.out.println("Por favor, digite o saldo inicial:");
	        double saldoInicial = scanner.nextDouble();
	        scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextDouble()

	        ContaBancaria conta = new ContaBancaria(numeroConta, agencia, nomeCliente, saldoInicial);

	        System.out.println(conta.obterMensagemBoasVindas());

	        exibirOpcoes(conta, scanner);

	        scanner.close();
	    }
	 
	
	 

	    public static void exibirOpcoes(ContaBancaria conta, Scanner scanner) {
	        boolean continuar = true;
	        while (continuar) {
	            System.out.println("\nEscolha uma opção:");
	            System.out.println("1. Verificar Saldo");
	            System.out.println("2. Depositar");
	            System.out.println("3. Sacar");
	            System.out.println("4. Sair");

	            int opcao = scanner.nextInt();
	            scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

	            switch (opcao) {
	                case 1:
	                    conta.verificarSaldo();
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
	                    continuar = false;
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        }
	    }
}
