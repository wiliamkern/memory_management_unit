import java.util.ArrayList;

public class Process {

	public int pid; // Identificador do processo

	public double sizeRequired; // tamanho de aloca��o requerido pelo processo

	ArrayList<Instruction> processTasks = new ArrayList<Instruction>(); // instru��es a serem executadas pelo processo

	private int rangeInicial;

	private int rangeFinal;

	private Partition particao;

	public Partition getParticao() {
		return particao;
	}

	public void setParticao(Partition particao) {
		this.particao = particao;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getSizeRequired() {
		return sizeRequired;
	}

	public void setSizeRequired(int sizeRequired) {
		this.sizeRequired = sizeRequired;
	}

	public ArrayList<Instruction> getProcessTasks() {
		return processTasks;
	}

	public void setProcessTasks(ArrayList<Instruction> processTasks) {
		this.processTasks = processTasks;
	}

	public double getRangeInicial() {
		return rangeInicial;
	}

	public double getRangeFinal() {
		return rangeFinal;
	}

	private void getRanges() {
		rangeFinal = particao.getRangeProcesso((int) sizeRequired);
		rangeInicial = rangeFinal - (int) sizeRequired;
	}

	boolean executar() {
		getRanges();
		for (Instruction instrucao : processTasks) {
			if ("ES".equals(instrucao.getES())) {
				instrucao.setES("");
				// Process novoProcesso = this.clone();
				PartitionManagement.addProcessoES(this);
			} else {
				if (instrucao.typeOperation != null && instrucao.typeOperation.equals("sw")) {
					particao.write(this, instrucao.getStoragePosition(), instrucao.getValue());
				} else {
					particao.read(this, instrucao.getStoragePosition());
				}
				instrucao.processado = true;
			}
		}
		return true;
	}

}
