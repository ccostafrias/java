import java.util.*;

public class Questao9 {

	public static void main(String [] args) {

		Collection<String> c = new HashSet<>();

		c.add("carro");
		c.add("avião");
		c.add("barco");

		Iterator<String> it = c.iterator();

		while(it.hasNext()){
		  System.out.print(it.next() + " ");
		}

		System.out.println();
	}
}
