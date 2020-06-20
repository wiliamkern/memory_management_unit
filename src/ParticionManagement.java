import java.util.ArrayList;

public class ParticionManagement {
	
	static private ArrayList<Process>  processos;

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
	
	
	
	
	
	
	
	
	public static void addProcesso(Process processo) {
		processos.add(processo);
	}


	public static ArrayList<Process> getProcessos() {
		return processos;
	}


	public static void setProcessos(ArrayList<Process> processos) {
		ParticionManagement.processos = processos;
	}
	


}
