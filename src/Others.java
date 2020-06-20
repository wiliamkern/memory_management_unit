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

			while (input.hasNextLine()) { // l� processo por processo (linha a linha)

				String rowData = String.valueOf(input.nextLine());

				String[] items = rowData.split("\\|"); // slipt no identificador de separa��o |
					// como o split usa regex a | n�o funciona para separador, por isso utilizei a as duas barras invertidas para escapar do regex

				process.pid = Integer.parseInt(items[0]); // l� o identificador do processo
				process.sizeRequired = Double.parseDouble(items[1]); // l� o tamanho requerido
						
				for (int x = 2; x < items.length; x++) { // come�a a ler da posi��o 2 do vetor pois as 2 primeiras sempre s�o o pid e o tamanho que o processo precisa
					
					if(!items[x].equals("-")) {

						Instruction intructionData = new Instruction();
						
						String[] splitInstruction = items[x].split(",");
						
						if(items[0].equals("ES")) {
							intructionData.ES = splitInstruction[0];
							
							processList.add(process);
						}else {
							if(splitInstruction[0].equals("sw")) {
								intructionData.typeOperation = splitInstruction[0];
								intructionData.value = splitInstruction[1];
								intructionData.storagePosition = Integer.parseInt(splitInstruction[2]);
								
								processList.add(process);
							}else {
								intructionData.typeOperation = splitInstruction[0];
								intructionData.storagePosition = Integer.parseInt(splitInstruction[1]);
								
								processList.add(process);
							}
							
							
							//process.processTasks.add(intructionData);
						}
					}
					
					processList.add(process);
				}
			}

			int a = 1;
			return processList.size() > 0 ? processList : new ArrayList<Process>();
		} catch (Exception ex) {
			return new ArrayList<Process>();
		}
	}
}
