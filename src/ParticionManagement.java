import java.util.ArrayList;

public class ParticionManagement {

	public void firstFit(ArrayList<Process> processos) {
		for (Process process : processos) {
			process.setParticao(getBestParticionFirstFit(process));
			process.executar();
		}
	}
	
	
	//Executa o first fit pra pegar uma particao
	private Particion getBestParticionFirstFit(Process processo) {
		
		
		return null;
	}

}
