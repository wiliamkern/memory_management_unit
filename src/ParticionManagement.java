import java.util.ArrayList;

public class ParticionManagement {

	static private ArrayList<Process> processos;
	
	static private ArrayList<Process> processosES;

	final static public String firstFit = "firstFit";

	final static public String worstFit = "worstFit";

	final static public String bestFit = "bestFit";

	final static public String circularFit = "circularFit";

	private static String tipoAlocacao = "";

	public String getTipoAlocacao() {
		return tipoAlocacao;
	}

	public static void setTipoAlocacao(String tipoAlocacao) {
		ParticionManagement.tipoAlocacao = tipoAlocacao;
	}

	public static void alocaProcessos() {
		processosES = new ArrayList<Process>();
		for (Process process : processos) {
			if (process.getParticao() == null) {
				switch (tipoAlocacao) {
				case (firstFit):
					process.setParticao(getParticionFirstFit(process));
					break;
				case (worstFit):
					process.setParticao(getParticionBestFit(process));
					break;
				case (bestFit):
					process.setParticao(getParticionWorstFit(process));
					break;
				case (circularFit):
					process.setParticao(getParticionCircularFit(process));
					break;
				}
			}
			process.executar();
		}
		
		
		
		for (Process process : processosES) {
			if (process.getParticao() == null) {
				switch (tipoAlocacao) {
				case (firstFit):
					process.setParticao(getParticionFirstFit(process));
					break;
				case (worstFit):
					process.setParticao(getParticionBestFit(process));
					break;
				case (bestFit):
					process.setParticao(getParticionWorstFit(process));
					break;
				case (circularFit):
					process.setParticao(getParticionCircularFit(process));
					break;
				}
			}
			process.executar();
		}
	}

	// Executa o first fit pra pegar uma particao
	private static Particion getParticionFirstFit(Process processo) {
		for (Particion particao : MemoryManagement.getParticoes()) {
			if (particao.getEspacoLivre() > processo.getSizeRequired()) {
				return particao;
			}
		}
		return null;
	}

	// Executa o best fit pra pegar uma particao
	private static Particion getParticionBestFit(Process processo) {
		int espacoEficiente = 99999999;
		Particion particionEficiente = null;
		for (Particion particao : MemoryManagement.getParticoes()) {
			if (particao.getEspacoLivre() > processo.getSizeRequired() && particao.getEspacoLivre() < espacoEficiente) {
				particionEficiente = particao;
				espacoEficiente = particao.getEspacoLivre();
			}
		}
		return particionEficiente;
	}

	// Executa o worst fit pra pegar uma particao
	private static Particion getParticionWorstFit(Process processo) {
		int espacoEficiente = 0;
		Particion particionEficiente = null;
		for (Particion particao : MemoryManagement.getParticoes()) {
			if (particao.getEspacoLivre() > processo.getSizeRequired() && particao.getEspacoLivre() > espacoEficiente) {
				particionEficiente = particao;
				espacoEficiente = particao.getEspacoLivre();
			}
		}
		return particionEficiente;
	}

	// Executa o worst fit pra pegar uma particao
	private static Particion getParticionCircularFit(Process processo) {
		int espacoEficiente = 0;
		Particion particionEficiente = null;
		for (Particion particao : MemoryManagement.getParticoes()) {

		}
		return particionEficiente;
	}

	public static void addProcesso(Process processo) {
		processos.add(processo);
	}
	
	public static void addProcessoES(Process processo) {
		processosES.add(processo);
	}

	public static ArrayList<Process> getProcessos() {
		return processos;
	}

	public static void setProcessos(ArrayList<Process> processos) {
		ParticionManagement.processos = processos;
	}

}
