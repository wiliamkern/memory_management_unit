import java.util.ArrayList;

public class MemoryManagement {
	// Classe com as operações de gerenciamento de memória.
	private static ArrayList<String> memory = new ArrayList<String>();
	private static ArrayList<Particion> particoes = new ArrayList<Particion>();

	public static ArrayList<Particion> getParticoes() {
		return particoes;
	}

	private void iniciarMemória() {
		Particion particion1 = new Particion(50000);
		particoes.add(particion1);
		Particion particion2 = new Particion(50000);
		particoes.add(particion2);
		Particion particion3 = new Particion(40000);
		particoes.add(particion3);
		Particion particion4 = new Particion(60000);
		particoes.add(particion4);
		Particion particion5 = new Particion(10000);
		particoes.add(particion5);
		Particion particion6 = new Particion(90000);
		particoes.add(particion6);
		Particion particion7 = new Particion(80000);
		particoes.add(particion7);
		Particion particion8 = new Particion(20000);
		particoes.add(particion8);
		Particion particion9 = new Particion(30000);
		particoes.add(particion9);
		Particion particion10 = new Particion(70000);
		particoes.add(particion10);
		
		memory = new ArrayList<String>();
		for (int i = 500000; i > 1; i--) {
			memory.add("X");
		}
//		for (int i = 500000; i > 1; i--) {
//			memory.add("");
//		}
//		ultimaMemoria = 500000;
	}

}
