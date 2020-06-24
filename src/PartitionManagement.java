import java.util.ArrayList;

public class PartitionManagement {

	static private ArrayList<Process> processos;

	static private ArrayList<Process> processosES;

	final static public String firstFit = "firstFit";

	final static public String worstFit = "worstFit";

	final static public String bestFit = "bestFit";

	final static public String circularFit = "circularFit";

	private static String tipoAlocacao = "";
	
	private static int LastPosition = 0; // variv�vel para controle do circular fit verificar a partir da ultima parti��o

	public String getTipoAlocacao() {
		return tipoAlocacao;
	}

	public static void setTipoAlocacao(String tipoAlocacao) {
		PartitionManagement.tipoAlocacao = tipoAlocacao;
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
	private static Partition getParticionFirstFit(Process processo) {
		for (Partition particao : MemoryManagement.getParticoes()) {
			if (particao.getEspacoLivre() >= processo.getSizeRequired()) {
				return particao;
			}
		}
		return null;
	}

	// Executa o best fit pra pegar uma particao
	private static Partition getParticionBestFit(Process processo) {
		int espacoEficiente = 99999999;
		Partition particionEficiente = null;
		for (Partition particao : MemoryManagement.getParticoes()) {
			if (particao.getEspacoLivre() >= processo.getSizeRequired() && particao.getEspacoLivre() < espacoEficiente) {
				particionEficiente = particao;
				espacoEficiente = particao.getEspacoLivre();
			}
		}
		return particionEficiente;
	}

	// Executa o worst fit pra pegar uma particao
	private static Partition getParticionWorstFit(Process processo) {
		int espacoEficiente = 0;
		Partition particionEficiente = null;
		for (Partition particao : MemoryManagement.getParticoes()) {
			if (particao.getEspacoLivre() >= processo.getSizeRequired() && particao.getEspacoLivre() > espacoEficiente) {
				particionEficiente = particao;
				espacoEficiente = particao.getEspacoLivre();
			}
		}
		return particionEficiente;
	}

	// Executa o circular fit pra pegar uma particao
	private static Partition getParticionCircularFit(Process processo) {
		ArrayList<Partition> particao = MemoryManagement.getParticoes();
		Boolean control = false; // variavel de controle para aloca��o
		int restantes = 0;		
		
		for (int x = 0; x < particao.size(); x++) {	// primeira checagem olhando da ultima parti��o usada at� o final das parti��es
		
			if (particao.get(x).getEspacoLivre() >= processo.getSizeRequired() && particao.get(x).getPartitionNumber() > LastPosition)  {
				LastPosition = particao.get(x).getPartitionNumber(); // guarda particao da ultima inser��o
				control = true; 
				return particao.get(x);
			}
			if(control == false && particao.size() == x) {
				
				restantes = particao.size() - (LastPosition -1); // segunda checagem para pegar apenas do 0 at� a posi��o que foi a ultima
				
				for (int i = 0; i < restantes; x++) {	
					
					if (particao.get(x).getEspacoLivre() >= processo.getSizeRequired())  {
						LastPosition = particao.get(x).getPartitionNumber(); // guarda particao da ultima inser��o
						control = true; 
						return particao.get(x);
					}
					if(control == false && particao.size() == x) {
						return null;	// quando n�o teve mem�ria de amanho suficiente livre							
					}												
				}
				return null;								
			}												
			
		}
		return null;
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
		PartitionManagement.processos = processos;
	}

}
