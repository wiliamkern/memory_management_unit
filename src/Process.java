import java.util.ArrayList;

public class Process {

	public int pid; // Identificador do processo
	
	public double sizeRequired; // tamanho de alocação requerido pelo processo
	
	ArrayList<Instruction> processTasks = new ArrayList<Instruction>(); // instruções a serem executadas pelo processo
	
	private int rangeInicio;
	
	private int rangeFinal;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getSizeRequired() {
		return sizeRequired;
	}

	public void setSizeRequired(double sizeRequired) {
		this.sizeRequired = sizeRequired;
	}

	public ArrayList<Instruction> getProcessTasks() {
		return processTasks;
	}

	public void setProcessTasks(ArrayList<Instruction> processTasks) {
		this.processTasks = processTasks;
	}
	
	public double getRangeInicio() {
		return rangeInicio;
	}
	
	public double getRangeFinal() {
		return rangeFinal;
	}
	
	private void getRanges(){
		rangeFinal = MemoryManagement.getRangeProcesso(sizeRequired);
		rangeInicial= rangeFinal - sizeRequired;
	}
	
}
