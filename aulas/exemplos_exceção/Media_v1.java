import java.util.*;

// versão 1: algumas melhorias em relação à versão anterior.

public class Media_v1 {

	private static Scanner scanner = new Scanner(System.in);

	// verificação do intervalo da nota é movida para este método.
	// Resolve o problema da redundância do versão anteior, mas...

	public static double leDouble(){

		// se o valor lido estiver fora do intervalo esperado
		// devolvemos um valor negativo (que não representa um
		// valor de nota válido). Assim, quem faz a chamada a 
		// este método consegue verficar se a leitura foi bem
		// sucedida ou não. Note que estamos sobrecarregando o
		// papel do valor devolvido pelo método, o que não é
		// uma boa ideia.

		double x = scanner.nextDouble();

		if(x < 0.0 || x > 10.0) return -1;

		return x;
	}

	public static void erro(){

		System.out.println("Nota fora do intervalo.");
		System.exit(1);
	}

	public static void media(){

		// ...ainda há mistura da "lógica principal" com a 
		// "lógica para tratamento de erro" neste método.

                double a = leDouble();
		if(a < 0) erro();
        
                double b = leDouble();
		if(b < 0) erro();

                double c = leDouble();
		if(c < 0) erro();

		double media = (a + b + c) / 3.0;
                System.out.println("Media = " + media);
	}

        public static void main(String [] args){

		media();
		System.out.println("Fim!");
        }
}

