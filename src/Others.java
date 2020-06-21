import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Others {

	public ArrayList<Process> ImportDATA() {
		try {

			System.out.println("Importando arquivo dos processos...");
			Scanner input = new Scanner(
					new File("C:\\Users\\Wiliam Kern Franco\\git\\memory_management_unit\\src\\Files\\processos2.txt")); // faz
																															// a
																															// leitura
																															// do
																															// arquivo

			ArrayList<Process> processList = new ArrayList<Process>();
			Process process = new Process();
			Instruction instruction = new Instruction();

			while (input.hasNextLine()) { // lê processo por processo (linha a linha)

				String rowData = String.valueOf(input.nextLine());

				String[] items = rowData.split("\\|"); // slipt no identificador de separação |
				// como o split usa regex a | não funciona para separador, por isso utilizei a
				// as duas barras invertidas para escapar do regex

				process.pid = Integer.parseInt(items[0]); // lê o identificador do processo
				process.sizeRequired = Double.parseDouble(items[1]); // lê o tamanho requerido

				for (int x = 2; x < items.length; x++) { // começa a ler da posição 2 do vetor pois as 2 primeiras
															// sempre são o pid e o tamanho que o processo precisa

					if (!items[x].equals("-")) {

						Instruction instructionData = new Instruction();

						String[] splitInstruction = items[x].split(","); // split dos dados de instruções do processo,
																			// quebrando cada instrução pelas virgulas

						// verifica o tipo de operação 
						if (splitInstruction[0].equals("ES")) { // populando os dados para ES
							instructionData.ES = splitInstruction[0];

							process.processTasks.add(instructionData);
						} else {
							if (splitInstruction[0].equals("sw")) { // populando os dados para sw
								instructionData.typeOperation = splitInstruction[0];
								instructionData.value = splitInstruction[1];
								instructionData.storagePosition = Integer.parseInt(splitInstruction[2]);

								process.processTasks.add(instructionData);
							} else { // populando as variaveis para lw
								instructionData.typeOperation = splitInstruction[0];
								instructionData.storagePosition = Integer.parseInt(splitInstruction[1]);

								process.processTasks.add(instructionData);
							}
						}
					}
				}

				processList.add(process);
			}
			System.out.println("Dados de processos importados com sucesso!!");
			System.out.println(
					processList.size() > 0 ? "***Total de " + processList.size() + " processos foram encontrados***"
							: "Arquivo de processos está vazio");
			System.out.println("--------------------------------------------");

			return processList.size() > 0 ? processList : new ArrayList<Process>();
		} catch (Exception ex) {
			System.out.println("Arquivo de processos não encontrado!"); // caso não encontrar o aquivo ele cai na
																		// exception que vai retornar uma lista vazia
			return new ArrayList<Process>();
		}
	}

	public void createFile() {

		try {

			System.out.println("--------------------------------------------");
			System.out.println("Criando o arquivo memoria.txt");

			PrintWriter writer = new PrintWriter("memoria.txt", "UTF-8"); // cria o arquivo memoria.txt
			writer.println("The first line");
			writer.println("The second line");
			writer.close();

			System.out.println("Arquivo memoria.txt criado com Sucesso!!");
			System.out.println("--------------------------------------------");

		} catch (Exception ex) {
			System.out.println("Não foi possível criar o arquivo memoria.txt");
			System.out.println("--------------------------------------------");
		}

	}
}
