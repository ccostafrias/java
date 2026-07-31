import java.util.*;

class Aluno implements Comparable<Aluno>{

	private String nome;
	private int nUSP;

	public Aluno(String nome, int nUSP){

		this.nome = nome;
		this.nUSP  = nUSP;
	}

	public String toString() {

		return nome + " (" + nUSP + ")";
	}

	public int getNUSP(){

		return nUSP;
	}

	public String getNome(){

		return nome;
	}

	// qual a importância dos três métodos abaixo para
	// o adequado funcionamento das coleções Java?

	public boolean equals(Object obj){

		System.out.println("CHAMOU EQUALS");

		if(obj instanceof Aluno){

			Aluno a = (Aluno) obj;

			return this.getNUSP() == a.getNUSP() && this.getNome().equals(a.getNome());
		}

		return false;
	}

	public int hashCode(){

		System.out.println("CHAMOU HASHCODE");

		return getNUSP();
	}

	public int compareTo(Aluno a){

		System.out.println("CHAMOU COMPARE TO");
	
		return this.getNome().compareTo(a.getNome());
	}
}

public class Questao1 {

	public static <T extends Comparable<T>> List<T> metodo(List<T> lista){

		List<T> resultado = new ArrayList<>();
		Set<T> set = new TreeSet<>();

		for(T x : lista) set.add(x);
		for(T x : set) resultado.add(x);

		return resultado;
	}

	public static void main(String [] args) {
		Set<Aluno> alunos = new TreeSet<>();

		alunos.add(new Aluno("Duda", 18130923));
		alunos.add(new Aluno("Caique", 16814380));
		alunos.add(new Aluno("Alan", 12114350));

		System.out.println("=============================================");


		System.out.format("DUDA EXISTE? %s", alunos.contains(new Aluno("Duda", 18130923)) ? "SIM" : "NÃO");

		// for(Integer x : numbers) System.out.println(x);

		// System.out.println("-------------------");

		// List<Integer> coiso = metodo(numbers);

		// for(Integer x : coiso) System.out.println(x);
	}
}