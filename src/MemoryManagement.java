import java.util.ArrayList;

public class MemoryManagement {
	// Classe com as opera��es de gerenciamento de mem�ria.
	private static ArrayList<String> memory = new ArrayList<String>(); // arraylist do tipo string para simular a mem�ria
	private static ArrayList<Partition> partitions = new ArrayList<Partition>(); // arraylist do tipo parti��o para manipular as parti��es da mem�ria

	public static ArrayList<Partition> getParticoes() {
		return partitions;
	}
	

	static void startMemory() { // cria��o as parti��es
		
		memory = new ArrayList<String>(); // popula os primeiros 50000 bits da mem�ria com o sistema operacional
		for (int i = 500000; i > 1; i--) {
			memory.add("X");
		}
		
		Partition particion1 = new Partition(50000, 0); //parti��es com tamanhos diferentes para os algoritmos de aloca��o trabalharem
		partitions.add(particion1);					// as parti��es criadas fecha os outros 500000 bits que poder�o ser usados pelo software
		Partition particion2 = new Partition(50000, 1);
		partitions.add(particion2);
		Partition particion3 = new Partition(40000, 2);
		partitions.add(particion3);
		Partition particion4 = new Partition(60000, 3);
		partitions.add(particion4);
		Partition particion5 = new Partition(10000, 4);
		partitions.add(particion5);
		Partition particion6 = new Partition(90000, 5);
		partitions.add(particion6);
		Partition particion7 = new Partition(80000, 6);
		partitions.add(particion7);
		Partition particion8 = new Partition(20000, 7);
		partitions.add(particion8);
		Partition particion9 = new Partition(30000, 8);
		partitions.add(particion9);
		Partition particion10 = new Partition(70000, 9);
		partitions.add(particion10);
//		for (int i = 500000; i > 1; i--) {
//			memory.add("");
//		}
//		ultimaMemoria = 500000;
	}
	
	public static void escreveMemoria() {
		for(String texto: memory) {
			Others.writer.println(texto);
		}
		for(Partition particao: partitions) {
			particao.escreveMemoria();
		}
	}

}
