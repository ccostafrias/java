import java.util.*;

public class Questao3 {

	public static <T extends Comparable<T>> List<T> metodo(List<T> lista){

		List<T> resultado = new ArrayList<>();

		for(T x : lista) if(!resultado.contains(x)) resultado.add(x);

		return resultado;
	}	

	public static void main(String [] args) {
		List<Integer> numbers = new ArrayList<>();

		numbers.add(2);
		numbers.add(2);
		numbers.add(3);
		numbers.add(1);
		numbers.add(4);
		numbers.add(-1);
		numbers.add(-1);
		numbers.add(0);

		for(Integer x : numbers) System.out.println(x);

		System.out.println("-------------------");

		List<Integer> coiso = metodo(numbers);

		for(Integer x : coiso) System.out.println(x);
	}
}
