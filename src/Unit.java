import java.util.ArrayList;
import java.util.Scanner;

public class Unit {

	public static void main(String[] args) {

		try {

			System.out.println("--------------------- Memory Management Unit Control -----------------------");
			System.out.println("|                                                                          |");
			System.out.println("| * Escolha o algoritmo de gerenciamento de parti��es vari�veis!           |");
			System.out.println("|     1. First-Fit                                                         |");
			System.out.println("|     2. Best-Fit                                                          |");
			System.out.println("|     3. Worst-Fit                                                         |");
			System.out.println("|     4. Circular-fit                                                      |");
			System.out.println("|                                                                          |");
			System.out.println("----------------------------------------------------------------------------");

			Others data = new Others();

			Scanner scan = new Scanner(System.in);
			String valueCommand = scan.nextLine();
			ArrayList<Process> processList = new ArrayList<Process>();

			int command = Integer.parseInt(valueCommand);

			if (command > 0 && command < 5) { // verifica se a op��o escolhida � v�lida para um dos gerenciamentos de
												// parti��es vari�veis

				switch (command) {

				case (1):
					System.out.println("A aloca��o de mem�ria ser� por First-Fit"); // executa o gerenciamento de mem�ria por First-fit
					data.createFile(); // cria o memoria.txt
					processList = data.ImportDATA();
					break;
				case (2):
					System.out.println("A aloca��o de mem�ria ser� por Best-Fit"); // executa o gerenciamento de mem�ria por Best-Fit
					data.createFile(); // cria o memoria.txt
					processList = data.ImportDATA();
					break;
				case (3):
					System.out.println("A aloca��o de mem�ria ser� por Worst-Fit"); // executa o gerenciamento de mem�ria por worst-fit
					data.createFile(); // cria o memoria.txt
					processList = data.ImportDATA();
					break;
				case (4):
					System.out.println("A aloca��o de mem�ria ser� por Circular-fit"); // executa o gerenciamento de mem�ria por circular-fit
					data.createFile(); // cria o memoria.txt
					processList = data.ImportDATA();
					break;
				}

			} else {
				// caso for um valor fora do intervalo dispara uma exception
				throw new Exception();
			}

		} catch (Exception ex) { // exception que executa inicia a main novamente informando que o valor inserido
									// era inv�lido
			System.out.println("Comando inv�lido, insira um comando v�lido!");
			main(args);
		}
	}
}