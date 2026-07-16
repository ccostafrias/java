import java.util.*;

// versão 2: uso do mecanismo para tratamento de exceções presente na linguagem.

public class Media_v2 {

	private static Scanner scanner = new Scanner(System.in);

	public static double leDouble() throws Exception{

		// se o valor lido estiver fora do intervalo esperado
		// lançamos uma exceção. É uma forma muito melhor de
		// sinalizar a quem chamou o método que algo inesperado
		// aconteceu, sem sobrecarregar o papel do retorno do
		// método. Como agora o método pode, eventualmente, lançar
		// exceções do tipo Exception, a declaração do método
		// deve indicar isso através do "throws".

		double x = scanner.nextDouble();

		if(x < 0.0 || x > 10.0) throw new Exception("nota fora do intervalo: " + x);

		return x;
	}

	public static void media(){

		// Com o uso do mécanismo para tratamento de exceções, é
		// possível conseguir uma boa separação das linhas de código 
		// responsáveis pela "lógica principal" daquelas responsáveis 
		// por tratar as situações inesperadas e excepcionais.

		try{

		        double a = leDouble();
		        double b = leDouble();
		        double c = leDouble();
			double media = (a + b + c) / 3.0;

                	System.out.println("Media = " + media);
		}
		catch(Exception e){

			// Se uma exceção do tipo Exception for lançada
			// durante a execução do código dentro do bloco
			// try acima, então a execução do bloco acima é 
			// interrompida imediatamente, e este bloco catch
			// executado. Após a finalização do bloco catch,
			// a execução do método atual prossegue normalmente.

			e.printStackTrace();
			System.out.println("Parece que o valor de nota digitado está fora do intervalo esperado. Vamos começar de novo...");
			media();
		}

		System.out.println("Fim - media");
	}

        public static void main(String [] args){

		media();
		System.out.println("Fim - main");
        }
}

