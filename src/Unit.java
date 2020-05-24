import java.util.Scanner;

public class Unit {

	public static void main(String[] args) {

		System.out.println("--------------------- Memory Management Unit Control -----------------------");
		System.out.println("|                                                                          |");
		System.out.println("| * Escolha o algoritmo algoritmos de gerenciamento de parti��es vari�veis |");
		System.out.println("|     1. First-Fit                                                         |");
		System.out.println("|     2. Best-Fit                                                          |");
		System.out.println("|     3. Worst-Fit                                                         |");
		System.out.println("|     4. Circular-fit                                                      |");
		System.out.println("|                                                                          |");
		System.out.println("----------------------------------------------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		int command = scan.nextInt();
		
		if(command > 0 && command < 5) { // verifica se a op��o escolhida � v�lida para um dos gerenciamentos de parti��es vari�veis
			
			switch(command) { 
			
			case(1):
				System.out.println("A aloca��o de mem�ria ser� por First-Fit");
				break;
			case(2):
				System.out.println("A aloca��o de mem�ria ser� por Best-Fit");
				break;
			case(3):
				System.out.println("A aloca��o de mem�ria ser� por Worst-Fit");
				break;
			case(4):
				System.out.println("A aloca��o de mem�ria ser� por Circular-fit");
				break;			
			}
			
		}else {
			System.out.println("Comando inv�lido"); // caso for um valor fora do intervalo executa a main novamente
			main(args);
		}
		
	}

}