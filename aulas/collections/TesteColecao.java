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

		if(obj instanceof Aluno){

			Aluno a = (Aluno) obj;

			return this.getNUSP() == a.getNUSP() && this.getNome().equals(a.getNome());
		}

		return false;
	}

	public int hashCode(){

		return getNUSP();
	}

	public int compareTo(Aluno a){
	
		return this.getNome().compareTo(a.getNome());
	}
}

public class TesteColecao {

	public static void preencheCollectionStrings(Collection<String> col){

		col.add("vermelho");
		col.add("verde");
		col.add("azul");
		col.add("amarelo");
		col.add("ciano");
		col.add("magenta");
		col.add("preto");
		col.add("branco");
	}

	public static void preencheCollectionAlunos(Collection<Aluno> col){

		String [] nomes = { "Paulo", "Juliana", "Caio", "Bruna", "Fernando", "Mariana", "Xavier", "Paula" };
		int [] numeros = { 3000, 3004, 3100, 3247, 3305, 3382, 3405, 3499 };

		for(int i = 0; i < nomes.length; i++){

			Aluno a = new Aluno(nomes[i], numeros[i]);
			col.add(a);
		}
	}

	public static <T> void percorre(Collection<T> col){

		Iterator<T> it = col.iterator();

		System.out.print("Coleção: [");

		while(it.hasNext()){

			T elemento = it.next();
			System.out.print(" " + elemento + (it.hasNext() ? "," : ""));
		}

		System.out.println(" ]");
	}

	public static <T> void verifica(Collection<T> col, T elemento){

		System.out.println("Coleção contem '" + elemento + "'? " + col.contains(elemento));
	}

	public static <T> void testList(List<T> list, T e){

		int n = list.size();

		System.out.println("elemento no índice 0: " + list.get(0));
		System.out.println("elemento no índice " + (n - 1) + ": " + list.get(n - 1));
		System.out.println("indice do elemento '" + e + "': " + list.indexOf(e));
		System.out.println("removendo elemento no índice " + (n / 2) + ": " + list.remove(n / 2));
	}

	public static <T> void testSortedSet(SortedSet<T> set, T a, T b){

		System.out.println("menor elemento: " + set.first());
		System.out.println("maior elemento: " + set.last());
		System.out.println("subconjunto no intervalo ['" + a + "', '" + b + "'): " + set.subSet(a, b));
	}
	
	public static void testeColecaoStrings(){

		Collection<String> col = new ArrayList<>(); // experimente trocar o tipo da coleção e observe os efeitos da troca

		preencheCollectionStrings(col);	// adição
		percorre(col);			// iteração

		System.out.println();

		System.out.println("Inserção repetida: " + col.add("amarelo"));
		System.out.println("Inserção repetida: " + col.add("amarelo"));
		System.out.println("Inserção repetida: " + col.add("amarelo"));
		System.out.println("Inserção repetida: " + col.add("verde"));
		System.out.println("Inserção repetida: " + col.add("verde"));
		System.out.println("Inserção repetida: " + col.add("preto"));
		
		System.out.println();		

		percorre(col);

		System.out.println();

		// verificação

		verifica(col, "verde");
		verifica(col, "marrom");
		verifica(col, "amarelo");

		// remoção

		System.out.println();

		System.out.println("Remoção: " + col.remove("verde"));
		System.out.println("Remoção: " + col.remove("azul"));
		System.out.println("Remoção: " + col.remove("marrom"));

		System.out.println();

		percorre(col);

		System.out.println();

		if(col instanceof List){
		
			testList((List<String>) col, "magenta");
			System.out.println();
		}

		if(col instanceof SortedSet){
		
			testSortedSet((SortedSet<String>) col, "ciano", "vermelho");
			System.out.println();
		}

		percorre(col);
	}

	public static void testeColecaoAlunos(){

		Collection<Aluno> col = new ArrayList<>(); // experimente trocar o tipo da coleção e observe os efeitos da troca

		preencheCollectionAlunos(col);	// adição
		percorre(col);			// iteração

		System.out.println();
	
		System.out.println("Inserção repetida: " + col.add(new Aluno("Paulo", 3000)));
		System.out.println("Inserção repetida: " + col.add(new Aluno("Juliana", 3004)));

		System.out.println();
		
		percorre(col);

		System.out.println();

		// verificação

		verifica(col, new Aluno("Paulo", 3000));
		verifica(col, new Aluno("Felipe", 3500));
		verifica(col, new Aluno("Juliana", 3004));

		System.out.println();

		if(col instanceof List){
		
			testList((List<Aluno>) col, new Aluno("Bruna", 3247));
			System.out.println();
		}

		if(col instanceof SortedSet){
		
			testSortedSet((SortedSet<Aluno>) col, new Aluno("F", 0), new Aluno("P", 0));
			System.out.println();
		}

		percorre(col);
	}

	public static void main(String [] args){

		testeColecaoStrings();
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println();		
		testeColecaoAlunos();
	}
}