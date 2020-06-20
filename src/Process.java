import java.util.ArrayList;

public class Process {

	public int pid; // Identificador do processo

	public double sizeRequired; // tamanho de aloca��o requerido pelo processo

	ArrayList<Instruction> processTasks = new ArrayList<Instruction>(); // instru��es a serem executadas pelo processo

	private int rangeInicial;

	private int rangeFinal;

	private Particion particao;

	public Particion getParticao() {
		return particao;
	}

	public void setParticao(Particion particao) {
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
			if (instrucao.getES().equals("ES")) {
				try {
					instrucao.setES("");
					Process novoProcesso = (Process) this.clone();
					ParticionManagement.addProcesso(novoProcesso);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				if (instrucao.typeOperation.equals("sw")) {
					particao.write(this, instrucao.getStoragePosition(), instrucao.getValue());
				} else {
					particao.read(this, instrucao.getStoragePosition());
				}
				processTasks.remove(instrucao);
			}
		}
		return true;
	}

}
