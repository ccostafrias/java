import java.util.*;

// versão 4: praticamente igual à versão 3, mas ilustra também o uso do bloco finally.

class NotaForaDoIntervaloException extends Exception {

	public NotaForaDoIntervaloException(double d){

		super("nota fora do intervalo: " + d);
	}
}

public class Media_v4 {

	private static Scanner scanner = new Scanner(System.in);

	public static double leDouble() throws NotaForaDoIntervaloException{

		double x = scanner.nextDouble();

		if(x < 0.0 || x > 10.0) throw new NotaForaDoIntervaloException(x);

		return x;
	}

	public static void media(){

		try{
			// bloco que cause uma exceção do tipo NullPointerException com ~30% de chance.

			if(Math.random() < 0.3){

				Object o = null;
				o.toString();
			}

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
		finally{

			// Um bloco finally acontece sempre, não importa o que aconteça: 
			// (i) execução normal, em que nenhuma exceção é lançada;
			// (ii) execução que gera o lançamento de uma exceção, capturada por um bloco try;
			// (iii) execução que gera o lançamento de uma exceção, que NÃO é capturada por nenhum bloco try.

			// Pergunta: o que acontece com a execução do programa no cenário (iii)?

			System.out.println("Bloco finally!");
		}

		System.out.println("Fim - media");
	}

        public static void main(String [] args){

		media();
		System.out.println("Fim - main");
        }
}

