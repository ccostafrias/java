public class Questao10 {

	public static void metodoB() {

		throw new RuntimeException("Erro");
	}

	public static void metodoA() {
        
		metodoB();
	}

	public static void main(String[] args) {

		try {
			metodoA();
		} 
		catch (RuntimeException e) {
			System.out.println("Exceção capturada");
		}
	}
}
