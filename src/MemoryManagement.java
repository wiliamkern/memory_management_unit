import java.util.ArrayList;

public class MemoryManagement {
	// Classe com as operações de gerenciamento de memória.
	private static ArrayList<String> memory = new ArrayList<String>(); // arraylist do tipo string para simular a memória
	private static ArrayList<Partition> partitions = new ArrayList<Partition>(); // arraylist do tipo partição para manipular as partições da memória

	public static ArrayList<Partition> getParticoes() {
		return partitions;
	}
	

	static void startMemory() { // criação as partições
		
		memory = new ArrayList<String>(); // popula os primeiros 50000 bits da memória com o sistema operacional
		for (int i = 500000; i > 1; i--) {
			memory.add("X");
		}
		
		Partition particion1 = new Partition(50000, 0); //partições com tamanhos diferentes para os algoritmos de alocação trabalharem
		partitions.add(particion1);					// as partições criadas fecha os outros 500000 bits que poderão ser usados pelo software
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
		//Printa Lacunas
		for(Partition particao: partitions) {
			particao.printaLacuna();
		}
	}

}
