import java.util.Scanner;

public class Unit {

	public static void main(String[] args) {

		System.out.println("--------------------- Memory Management Unit Control -----------------------");
		System.out.println("|                                                                          |");
		System.out.println("| * Escolha o algoritmo algoritmos de gerenciamento de partições variáveis!|");
		System.out.println("|     1. First-Fit                                                         |");
		System.out.println("|     2. Best-Fit                                                          |");
		System.out.println("|     3. Worst-Fit                                                         |");
		System.out.println("|     4. Circular-fit                                                      |");
		System.out.println("|                                                                          |");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("TESTE aaa");

		Scanner scan = new Scanner(System.in);
		String valueCommand = scan.nextLine();

		try {

			int command = Integer.parseInt(valueCommand);

			if (command > 0 && command < 5) { // verifica se a opção escolhida é válida para um dos gerenciamentos de
												// partições variáveis

				switch (command) {

				case (1):
					System.out.println("A alocação de memória será por First-Fit"); // executa o gerenciamento de
																					// memória por First-fit
					break;
				case (2):
					System.out.println("A alocação de memória será por Best-Fit"); // executa o gerenciamento de memória
																					// por Best-Fit
					break;
				case (3):
					System.out.println("A alocação de memória será por Worst-Fit"); // executa o gerenciamento de
																					// memória por worst-fit
					break;
				case (4):
					System.out.println("A alocação de memória será por Circular-fit"); // executa o gerenciamento de
																						// memória por circular-fit
					break;
				}

			} else {
				// caso for um valor fora do intervalo dispara uma exception
				throw new Exception();
			}

		} catch (Exception ex) { // exception que executa inicia a main novamente informando que o valor inserido era inválido
			System.out.println("Comando inválido, insira um comando válido!"); 
			main(args);
		}
	}
}