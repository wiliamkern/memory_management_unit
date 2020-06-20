import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Others {

	public ArrayList<Process> ImportDATA() {
		try {

			System.out.println("Importando arquivo dos processos...");
			Scanner input = new Scanner(
					new File("C:\\Users\\Wiliam Kern Franco\\git\\memory_management_unit\\src\\Files\\processos1.txt")); // faz a leitura do arquivo

			ArrayList<Process> processList = new ArrayList<Process>();
			Process process = new Process();
			Instruction instruction = new Instruction();

			while (input.hasNextLine()) { // lê processo por processo (linha a linha)

				String rowData = String.valueOf(input.nextLine());

				String[] items = rowData.split("\\|"); // slipt no identificador de separação |
					// como o split usa regex a | não funciona para separador, por isso utilizei a as duas barras invertidas para escapar do regex

				process.pid = Integer.parseInt(items[0]); // lê o identificador do processo
				process.sizeRequired = Double.parseDouble(items[1]); // lê o tamanho requerido
						
				for (int x = 2; x < items.length; x++) { // começa a ler da posição 2 do vetor pois as 2 primeiras sempre são o pid e o tamanho que o processo precisa
					
					if(!items[x].equals("-")) {

						Instruction instructionData = new Instruction();
						
						String[] splitInstruction = items[x].split(",");
						
						if(splitInstruction[0].equals("ES")) {
							instructionData.ES = splitInstruction[0];
							
							process.processTasks.add(instructionData);
						}else {
							if(splitInstruction[0].equals("sw")) {
								instructionData.typeOperation = splitInstruction[0];
								instructionData.value = splitInstruction[1];
								instructionData.storagePosition = Integer.parseInt(splitInstruction[2]);
								
								process.processTasks.add(instructionData);
							}else {
								instructionData.typeOperation = splitInstruction[0];
								instructionData.storagePosition = Integer.parseInt(splitInstruction[1]);
								
								process.processTasks.add(instructionData);
							}
						}
					}
				}
				processList.add(process);
			}

			return processList.size() > 0 ? processList : new ArrayList<Process>();
		} catch (Exception ex) {
			return new ArrayList<Process>();
		}
	}
}
