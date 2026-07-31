import java.util.*;

public class Questao2 {

	public static <T extends Comparable<T>> List<T> metodo(List<T> lista){

		List<T> resultado = new ArrayList<>();
		Set<T> set = new HashSet<>();

		for(T x : lista) set.add(x);
		for(T x : set) resultado.add(x);

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
		numbers.add(0);
		numbers.add(5);
		numbers.add(9);
		numbers.add(1);
		numbers.add(-4);
		numbers.add(12);
		numbers.add(27);
		numbers.add(32);
		numbers.add(59);
		numbers.add(900);

		for(Integer x : numbers) System.out.println(x);

		System.out.println("-------------------");

		List<Integer> coiso = metodo(numbers);

		for(Integer x : coiso) System.out.println(x);
	}
}
