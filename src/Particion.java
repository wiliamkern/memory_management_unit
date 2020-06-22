import java.util.ArrayList;

public class Particion {
	
	private int size;
	private ArrayList<String> memory = new ArrayList<String>();
	private int ultimaMemoria = 0;
	
	
	public Particion(int size){
		this.size = size;
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
	
	
	public boolean verificaAcessoIlegal(Process processo, int postion, int tamanho) {
		if (processo.getRangeFinal() == -1) {
			return false;
		}
		postion = postion-1;
		if ((postion + tamanho) <= (processo.getRangeFinal() - processo.getRangeInicial())) {
			for (int i = 0; i < tamanho; i++) {
				if (!memory.get(postion + i).equals(" ")) {
					// Acesso ilegal de memória
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public void write(Process processo, int postion, String value) {
		if (verificaAcessoIlegal(processo, postion, value.length())) {
			for (int i = 0; i < value.length(); i++) {
				memory.set(postion + i, value.substring(i, i + 1));
			}
		} else {
			System.out.println("Acesso Ilegal de memória");
		}
	}
//test
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
		Others.writer.println("Particion\n");
		for(String texto: memory) {
			Others.writer.print(texto);
		}
	}
	
	
}
