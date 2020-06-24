import java.util.ArrayList;

public class Partition {
	
	private int size;
	private int partitionNumber;
	public int getPartitionNumber() {
		return partitionNumber;
	}

	public void setPartitionNumber(int partitionNumber) {
		this.partitionNumber = partitionNumber;
	}


	private ArrayList<String> memory = new ArrayList<String>();
	private int ultimaMemoria = 0;
	
	
	public Partition(int size, int partitionNumber){
		this.size = size;
		this.partitionNumber = partitionNumber;
		for (int i = 0; i < size; i++) {
			memory.add(" ");
		}
	}
	
	// Retorna o final do range do processo
	public int getRangeProcesso(int quant) {
		if (size < (ultimaMemoria + quant)) {
			System.out.println("Sem memória livre");
			return -1;
		} else {
			ultimaMemoria = ultimaMemoria + quant;
			return ultimaMemoria;
		}
	}
	
	public int getEspacoLivre() {
		return size - ultimaMemoria;
	}
	
	
	public boolean verificaAcessoIlegal(Process processo, int position, int tamanho) {
		if (processo.getRangeFinal() == -1) {
			return false;
		}
//		postion = postion-1;
		if ((position + tamanho) <= (processo.getRangeFinal() - processo.getRangeInicial())) {
			for (int i = 0; i < tamanho; i++) {
				if (!memory.get(position + i).equals(" ")) {
					// Acesso ilegal de memória
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public void write(Process processo, int position, String value) {
		if (verificaAcessoIlegal(processo, position, value.length())) {
			for (int i = 0; i < value.length(); i++) {
				memory.set(position + i, value.substring(i, i + 1));
			}
		} else {
			System.out.println("Acesso Ilegal de memória");
		}
	}

	
	public String read(Process processo, int postion) {
		String retorno = "";
		
		if ((postion + 4) <= (processo.getRangeFinal() - processo.getRangeInicial())) {
			for (int i = 0; i < 4; i++) {
				retorno = retorno + memory.get(postion + i);
			}
		}
		System.out.println(retorno);
		return retorno;
	}
	
	
	public void escreveMemoria() {
		Others.writer.println("Particion Tamanho: " + size);
		for(String texto: memory) {
			Others.writer.println(texto);
		}
	}
	
	
}
