package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
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

		// Criar dados de testes
		criarContasTeste();

		while (true) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD);
			System.out.println("╔══════════════════════════════════════════════════════╗");
			System.out.println("║                                                      ║");
			System.out.println("║" + Cores.TEXT_WHITE_BOLD + "                BANCO DO GENERATION                   "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║                                                      ║");
			System.out.println("╠══════════════════════════════════════════════════════╣");
			System.out.println("║                                                      ║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            1 - Criar Conta                           "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            2 - Listar todas as Contas                "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            3 - Buscar Conta por Numero               "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            4 - Atualizar Dados da Conta              "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            5 - Apagar Conta                          "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            6 - Sacar                                 "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            7 - Depositar                             "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            8 - Transferir valores entre Contas       "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            9 - Consulta por nome do titular          "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║" + Cores.TEXT_YELLOW + "            0 - Sair                                  "
					+ Cores.TEXT_YELLOW_BOLD + "║");
			System.out.println("║                                                      ║");
			System.out.println("╚══════════════════════════════════════════════════════╝");
			System.out.print(Cores.TEXT_WHITE_BOLD + "  Entre com a opção desejada: " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();

			} catch (InputMismatchException e) {
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

				procurarContaPorNumero();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW + "\nAtualizar dados da Conta\n" + Cores.TEXT_RESET);

				atualizarConta();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW + "\nApagar a Conta\n" + Cores.TEXT_RESET);

				deletarConta();
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW + "\nSaque\n" + Cores.TEXT_RESET);

				sacar();
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW + "\nDepósito\n" + Cores.TEXT_RESET);

				depositar();
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW + "\nTransferência entre Contas\n" + Cores.TEXT_RESET);

				transferir();
				keyPress();
				break;

			case 9:
				System.out.println(Cores.TEXT_YELLOW + "\nConsulta por nome do titular\n" + Cores.TEXT_RESET);

				listarPorTitular();
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
		System.out.println("║" + Cores.TEXT_WHITE + " Projeto Desenvolvido por: Felipe Oliveira Lopes      "
				+ Cores.TEXT_YELLOW + "║");
		System.out.println("║" + Cores.TEXT_WHITE + " Generation Brasil - generation@generation.org        "
				+ Cores.TEXT_YELLOW + "║");
		System.out.println("║" + Cores.TEXT_WHITE + " https://github.com/Felipe-Lopes-code                 "
				+ Cores.TEXT_YELLOW + "║");
		System.out.println("╚══════════════════════════════════════════════════════╝\n" + Cores.TEXT_RESET);
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	public static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 123, 1, "Luizinho Gonzaga", 100000.0f, 1000.0f));
		contaController
				.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 123, 1, "Andorinha Goose", 120000.0f, 14));
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

		System.out.println("Digite o saldo conta: ");
		
		float saldo = Float.parseFloat(leia.nextLine());

		switch (tipo) {

		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = Float.parseFloat(leia.nextLine());
			leia.nextLine();

			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da conta: ");
			float aniversario = Integer.parseInt(leia.nextLine());
			leia.nextLine();

			contaController.cadastrar(
					new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de cont inválida!" + Cores.TEXT_RESET);
		}
	}

	public static void procurarContaPorNumero() {
		System.out.println("Digite o número da conta: ");
		int numero = Integer.parseInt(leia.nextLine());

		contaController.procurarPoNumero(numero);
	}

	public static void deletarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = Integer.parseInt(leia.nextLine());

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {
			// Confirmação da exclusão

			System.out.printf("\nTem certeza que deseja excluir a conta número %d (S/N)? ", numero);
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S"))
				contaController.deletar(numero);
			else
				System.out.println("Operação cancelada!");
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!\n", numero);
		}
	}

	public static void atualizarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = Integer.parseInt(leia.nextLine());

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {

			// Obtém os dados atuais da ocnta
			int agencia = conta.get().getAgencia();
			String titular = conta.get().getTitular();
			int tipo = conta.get().getTipo();
			float saldo = conta.get().getSaldo();

			// Atualiza a agência ou mantém o valor atual
			System.out.printf("Agência atual: %d"
					+ "%nDigite o número da nova agência (Pressione ENTER para manter o valor atual)", agencia);
			String entrada = leia.nextLine();

			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);

			// Atualiza o titular ou mantém o valor atual
			System.out.printf(
					"Titular atual: %s" + "%nDigite o nome do novo titular (Pressione ENTER para manter o valor atual)",
					titular);
			entrada = leia.nextLine();

			titular = entrada.isEmpty() ? titular : entrada;

			// Atualiza o saldo ou mantém o valor atual
			System.out.printf("Saldo atual: %.2f" + "%nDigite o novo saldo (Pressione ENTER para manter o valor atual)",
					saldo);
			entrada = leia.nextLine();

			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));

			switch (tipo) {
			case 1 -> {
				ContaCorrente contaCorrente = (ContaCorrente) conta.get();
				float limite = contaCorrente.getLimite();

				// Atualiza o limite ou mantém o valor atual
				System.out.printf(
						"Limite atual: %.2f" + "%nDigite o novo limite (Pressione ENTER para manter o valor atual)",
						limite);
				entrada = leia.nextLine();

				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",", "."));

				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));

			}
			case 2 -> {
				ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
				int aniversario = contaPoupanca.getAniversario();

				// Atualiza o aniversário ou mantém o valor atual
				System.out.printf("Dia do aniversário atual: %d"
						+ "%nDigite o novo limite (Pressione ENTER para manter o valor atual)", aniversario);
				entrada = leia.nextLine();

				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada.replace(",", "."));

				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));

			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo da conta é inválido!" + Cores.TEXT_RESET);

			}
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}

	}

	public static void sacar() {
		System.out.println("Digite o número da conta: ");
		int numero = Integer.parseInt(leia.nextLine());

		System.out.println("Digite o valor do saque: ");
		float valor = Float.parseFloat(leia.nextLine());
		leia.nextLine();
		contaController.sacar(numero, valor);
	}

	public static void depositar() {
		System.out.println("Digite o número da conta: ");
		int numero = Integer.parseInt(leia.nextLine());

		System.out.println("Digite o valor do depósito: ");
		float valor = Float.parseFloat(leia.nextLine());
		leia.nextLine();

		contaController.depositar(numero, valor);
	}

	public static void transferir() {
		System.out.println("Digite o número da conta de origem: ");
		int numeroOrigem = Integer.parseInt(leia.nextLine());

		System.out.println("Digite o número da conta de destino: ");
		int numeroDestino = Integer.parseInt(leia.nextLine());

		System.out.println("Digite o valor da transferência: ");
		float valor = Float.parseFloat(leia.nextLine());
		leia.nextLine();

		contaController.transferir(numeroOrigem, numeroDestino, valor);
	}

	public static void listarPorTitular() {
		System.out.println("Digite o nome titular da conta: ");
		String titular = leia.nextLine();
		leia.nextLine();

		contaController.listarPorTitular(titular);
	}

}