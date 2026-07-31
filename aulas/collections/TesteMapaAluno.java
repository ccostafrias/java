import java.util.*;

class Aluno implements Comparable<Aluno> {

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

	// A importância dos três métodos abaixo continua
	// a mesma quando instâncias de aluno são armazenadas
	// em mapas como valores associados a alguma chave?
	// Estes métodos serão chamados?
 
	public boolean equals(Object obj){

		System.out.println("\tEQUALS: comparando " + this + " com " + obj); 

		if(obj instanceof Aluno){

			Aluno a = (Aluno) obj;

			return this.getNUSP() == a.getNUSP() && this.getNome().equals(a.getNome());
		}

		return false;
	}

	public int hashCode(){

		System.out.println("\tHASHCODE: " + this); 

		return getNUSP();
	}

	public int compareTo(Aluno a){

		System.out.println("\tCOMPARE_TO: comparando " + this + " com " + a); 
	
		return this.getNome().compareTo(a.getNome());
	}
}

public class TesteMapaAluno {

	public static void preenche(Map<Integer, Aluno> map){

		String [] nomes = { "Paulo", "Juliana", "Caio", "Bruna", "Fernando", "Mariana", "Xavier", "Paula" };
		int [] numeros = { 3000, 3004, 2100, 3247, 7305, 9382, 8405, 1499 };

		for(int i = 0; i < nomes.length; i++){

			Aluno a = new Aluno(nomes[i], numeros[i]);
			map.put(a.getNUSP(), a);
		}
	}

	public static <K, V> void percorre(Map<K, V> map){

		Collection<K> keys = map.keySet();
		
		Iterator<K> it = keys.iterator();

		while(it.hasNext()){

			K chave = it.next();
			V valor = map.get(chave);
			System.out.println("chave = " + chave + ", valor = " + valor);
		}
	}

	public static <K, V> void verifica(Map<K, V> map, K chave){

		System.out.print(">>>>> Mapa contem a chave'" + chave + "'? " + map.containsKey(chave));
		System.out.println(". Valor associado a chave: " + map.get(chave));
	}

	public static void main(String [] args){

		Map<Integer, Aluno> map = (args.length > 0 && "tree".equals(args[0])) ? new TreeMap<>() : new HashMap<>();

		preenche(map);	// adição
		percorre(map);	// iteração

		System.out.println("------------------------------------------------------");

		map.put(3000, new Aluno("Paulo (2)", 3000));
		map.put(3004, new Aluno("Juliana (2)", 3004));
		
		percorre(map);

		System.out.println("------------------------------------------------------");

		// verificação

		verifica(map, 3000);
		verifica(map, 3500);
		verifica(map, 3004);

		System.out.println("------------------------------------------------------");
		
		// A verificação da existência de um objeto diretamente pelo seu valor, e não pela chave associada, será eficiente?  
		System.out.println(map.containsValue(new Aluno("Bruna", 3247)));
	}
}