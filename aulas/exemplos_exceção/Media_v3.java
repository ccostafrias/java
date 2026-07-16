import java.util.*;

// versão 3: uso aprimorado do mecanismo para tratamento de exceções presente na linguagem.
// Criamos nossa própria classe para representar uma exceção referente à nota fora do intervalo
// esperado, além de também tratar um outro problema potencial: quando o usuário digita uma entrada
// que não representa um valor double. Note que o tratamento destes dois cenários problemáticos
// é ligeiramente diferente, o que justifica o tratamento específico para cada tipo de exceção.

class NotaForaDoIntervaloException extends Exception {

	// Pergunta: e se a classe base desta classe fosse RuntimeException, ao 
	// invés de Excepion quais seriam as implicâncias desta alteração?

	public NotaForaDoIntervaloException(double d){

		super("nota fora do intervalo: " + d);
	}
}

public class Media_v3 {

	private static Scanner scanner = new Scanner(System.in);

	public static double leDouble() throws NotaForaDoIntervaloException{

		// se o valor lido estiver fora do intervalo esperado, agora
		// lançamos uma exceção do tipo NotaForaDoIntervaloException.
		// Lançar um objeto de exceção de um tipo mais especializado
		// pode ajudar a identificar problemas distintos que requerem
		// tratamentos distintos.

		double x = scanner.nextDouble();

		if(x < 0.0 || x > 10.0) throw new NotaForaDoIntervaloException(x);

		return x;
	}

	public static void media(){

		try{

		        double a = leDouble();
		        double b = leDouble();
		        double c = leDouble();
			double media = (a + b + c) / 3.0;

                	System.out.println("Media = " + media);
		}
		catch(NotaForaDoIntervaloException e){

			System.out.println("Parece que o valor de nota digitado está fora do intervalo esperado. Vamos começar de novo...");
			media();
		}
		catch(InputMismatchException e){

			System.out.println("Parece que o valor digitado não representa um valor double. Vamos começar de novo...");
			scanner.next();
			media();
		}

		System.out.println("Fim - media");
	}

        public static void main(String [] args){

		media();
		System.out.println("Fim - main");
        }
}

