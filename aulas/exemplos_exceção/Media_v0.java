import java.util.*;

// versão inicial: sem uso do mecanismo para tratamento de exceções.

public class Media_v0 {

	private static Scanner scanner = new Scanner(System.in);

	// metodo que encapsula o uso do objeto do tipo scanner.
	
	public static double leDouble(){

		return scanner.nextDouble();
	}

	public static void media(){

		// note como a "lógica principal" está misturada com a
		// "lógica para tratamento de erro" ao longo do método.

                double a = leDouble();
        
                if( a < 0 || a > 10.0 ){

                        System.out.println("Nota fora do intervalo.");
                        System.exit(1);
                }

                double b = leDouble();

                if( b < 0 || b > 10.0 ){

                        System.out.println("Nota fora do intervalo");
                        System.exit(1);
                }

                double c = leDouble();

                if( c < 0 || c > 10.0 ){

                        System.out.println("Nota fora do intervalo");
                        System.exit(1);
                }

		double media = (a + b + c) / 3.0;

                System.out.println("Media = " + media);
	}

        public static void main(String [] args){

		media();
		System.out.println("Fim!");
        }
}

