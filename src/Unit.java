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

			System.out.print("->"); // seta para indicar o local de por a op��o
			
			Others data = new Others();

			Scanner scan = new Scanner(System.in);
			String valueCommand = scan.nextLine();
			//ArrayList<Process> processList = new ArrayList<Process>();

			int command = Integer.parseInt(valueCommand);
			
			if (command > 0 && command < 5) { // verifica se a op��o escolhida � v�lida para um dos gerenciamentos de
												// parti��es vari�veis
				data.createFile(); // cria o memoria.txt
				switch (command) {

				case (1):
					MemoryManagement.startMemory();
					System.out.println("A aloca��o de mem�ria ser� por First-Fit"); // executa o gerenciamento de mem�ria por First-fit
					PartitionManagement.setTipoAlocacao(PartitionManagement.firstFit);
					
					PartitionManagement.setProcessos(data.ImportDATA());
					break;
				case (2):
					MemoryManagement.startMemory();
					System.out.println("A aloca��o de mem�ria ser� por Best-Fit"); // executa o gerenciamento de mem�ria por Best-Fit
					PartitionManagement.setTipoAlocacao(PartitionManagement.bestFit);

					PartitionManagement.setProcessos(data.ImportDATA());
					break;
				case (3):
					MemoryManagement.startMemory();
					System.out.println("A aloca��o de mem�ria ser� por Worst-Fit"); // executa o gerenciamento de mem�ria por worst-fit
					PartitionManagement.setTipoAlocacao(PartitionManagement.worstFit);

					PartitionManagement.setProcessos(data.ImportDATA());
					break;
				case (4):
					MemoryManagement.startMemory();
					System.out.println("A aloca��o de mem�ria ser� por Circular-fit"); // executa o gerenciamento de mem�ria por circular-fit
					PartitionManagement.setTipoAlocacao(PartitionManagement.circularFit);
					
					PartitionManagement.setProcessos(data.ImportDATA());
					break;
				}

			} else {
				// caso for um valor fora do intervalo dispara uma exception
				throw new Exception();
			}
			PartitionManagement.alocaProcessos();
			MemoryManagement.escreveMemoria();
			Others.writer.close();
		} catch (Exception ex) { // exception que executa inicia a main novamente informando que o valor inserido
									// era inv�lido, chamando a main novamente e reiniciando a execu��o do software
			//ex.printStackTrace();
			System.out.println("Comando inv�lido, insira um comando v�lido!");
			main(args);
		}
	}
}