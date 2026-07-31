import java.util.*;

public class Questao6 {

	public static double mediana(List<Double> lista){

		int n = lista.size();
		double mediana = lista.get(n / 2);

		if(n % 2 == 0) mediana = (mediana + lista.get(n / 2 - 1)) / 2.0; 

		return mediana;
	}

	public static void main(String [] args) {
		List<Double> numbers = new ArrayList<>();

		numbers.add(-1.0);
		numbers.add(-1.0);
		numbers.add(0.0);
		numbers.add(1.0);
		numbers.add(2.0);
		numbers.add(2.0);
		numbers.add(3.0);
		numbers.add(4.0);

		for(Double x : numbers) System.out.println(x);

		System.out.println("-------------------");

		double coiso = mediana(numbers);
		System.out.println(coiso);
	}
}
