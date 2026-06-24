package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {

		
		int opcao;
		
		//Criar dados de testes
		criarContasTeste();
				
		while (true) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD);
			System.out.println("╔══════════════════════════════════════════════════════╗");
			System.out.println("║                                                      ║");
			System.out.println("║" + Cores.TEXT_WHITE_BOLD + "                BANCO DO GENERATION                   " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║                                                      ║");
			System.out.println("╠══════════════════════════════════════════════════════╣");
			System.out.println("║                                                      ║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            1 - Criar Conta                           " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            2 - Listar todas as Contas                " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            3 - Buscar Conta por Numero               " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            4 - Atualizar Dados da Conta              " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            5 - Apagar Conta                          " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            6 - Sacar                                 " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            7 - Depositar                             " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            8 - Transferir valores entre Contas       " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            0 - Sair                                  " + Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║                                                      ║");
			System.out.println("╚══════════════════════════════════════════════════════╝");
			System.out.print(Cores.TEXT_WHITE_BOLD + "  Entre com a opção desejada: " + Cores.TEXT_RESET);

			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
				
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número interio entre 0 e 8");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW + "\nCriar Conta\n" + Cores.TEXT_RESET);
				
				cadastrarConta();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW + "\nListar todas as Contas\n" + Cores.TEXT_RESET);
				
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW + "\nConsultar dados da Conta - por número\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW + "\nAtualizar dados da Conta\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW + "\nApagar a Conta\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW + "\nSaque\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW + "\nDepósito\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW + "\nTransferência entre Contas\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_YELLOW + "\n╔══════════════════════════════════════════════════════╗");
		System.out.println("║" + Cores.TEXT_WHITE + " Projeto Desenvolvido por: Felipe Oliveira Lopes      " + Cores.TEXT_YELLOW + "║");
		System.out.println("║" + Cores.TEXT_WHITE + " Generation Brasil - generation@generation.org        " + Cores.TEXT_YELLOW + "║");
		System.out.println("║" + Cores.TEXT_WHITE + " https://github.com/Felipe-Lopes-code                 " + Cores.TEXT_YELLOW + "║");
		System.out.println("╚══════════════════════════════════════════════════════╝\n" + Cores.TEXT_RESET);
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	public static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 123, 1, "Luizinho Gonzaga", 100000.0f, 1000.0f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 123, 1, "Andorinha Goose", 120000.0f, 14));
	}
	
	public static void listarContas() {
		contaController.listarTodas();
	}
	
	public static void cadastrarConta() {
		System.out.println("Digite o número da agência: ");
		int agencia = Integer.parseInt(leia.nextLine());
		
		
		System.out.println("Digite o nome titular da conta: ");
		String titular = leia.nextLine();
		
		System.out.println("Digite o tipo de conta (1 - CC | 2 - CP): ");
		int tipo = Integer.parseInt(leia.nextLine());
		
		System.out.println("Digite o saldo conta: ");;
		float saldo = Float.parseFloat(leia.nextLine());
		
		switch(tipo) {
		
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = Float.parseFloat(leia.nextLine());
			leia.nextLine();
			
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da conta: ");
			float aniversario = Integer.parseInt(leia.nextLine());
			leia.nextLine();
			
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de cont inválida!" + Cores.TEXT_RESET);
		}
	}
	
}