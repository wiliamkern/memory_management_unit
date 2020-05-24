import java.util.Scanner;

public class Unit {

	public static void main(String[] args) {

		System.out.println("--------------------- Memory Management Unit Control -----------------------");
		System.out.println("|                                                                          |");
		System.out.println("| * Escolha o algoritmo algoritmos de gerenciamento de partições variáveis |");
		System.out.println("|     1. First-Fit                                                         |");
		System.out.println("|     2. Best-Fit                                                          |");
		System.out.println("|     3. Worst-Fit                                                         |");
		System.out.println("|     4. Circular-fit                                                      |");
		System.out.println("|                                                                          |");
		System.out.println("----------------------------------------------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		int command = scan.nextInt();
		
		if(command > 0 && command < 5) { // verifica se a opção escolhida é válida para um dos gerenciamentos de partições variáveis
			
			switch(command) { 
			
			case(1):
				System.out.println("A alocação de memória será por First-Fit");
				break;
			case(2):
				System.out.println("A alocação de memória será por Best-Fit");
				break;
			case(3):
				System.out.println("A alocação de memória será por Worst-Fit");
				break;
			case(4):
				System.out.println("A alocação de memória será por Circular-fit");
				break;			
			}
			
		}else {
			System.out.println("Comando inválido"); // caso for um valor fora do intervalo executa a main novamente
			main(args);
		}
		
	}

}