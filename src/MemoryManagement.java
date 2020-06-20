import java.util.ArrayList;

public class MemoryManagement {
	// Classe com as opera��es de gerenciamento de mem�ria.
	private ArrayList<String> memory = new ArrayList<String>();
	private static int ultimaMemoria = 0;
	final static int memoriaTotal = 100000;

	private void iniciarMem�ria() {
		memory = new ArrayList<String>();
		for (int i = 500000; i > 1; i--) {
			memory.add("X");
		}
		for (int i = 500000; i > 1; i--) {
			memory.add("");
		}
		ultimaMemoria = 500000;
	}

	// Retorna o final do range do processo
	public static int getRangeProcesso(int quant) {
		if (memoriaTotal < (ultimaMemoria + quant)) {
			System.out.println("Sem mem�ria livre");
			return -1;
		} else {
			ultimaMemoria = ultimaMemoria + quant;
			return ultimaMemoria;
		}
	}

	public boolean verificaAcessoIlegal(Process processo, int postion, int tamanho) {
		if (processo.getRangeFinal() == -1) {
			return false;
		}
		if ((postion + tamanho) < (processo.getRangeFinal() - processo.getRangeInicial())) {
			for (int i = 0; i < tamanho; i++) {
				if (memory.get(postion + i).length() > 0) {
					// Acesso ilegal de mem�ria
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
			System.out.println("Acesso Ilegal de mem�ria");
		}
	}
//
	public String read(Process processo, int postion) {
		String retorno = "";
		if (verificaAcessoIlegal(processo, postion, 4)) {
			for (int i = 0; i < 4; i++) {
				retorno = retorno + memory.get(postion + i);
			}
		}
		return retorno;
	}

}
