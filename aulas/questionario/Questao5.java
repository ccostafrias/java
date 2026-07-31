import java.util.*; 

class Pessoa {

	private String nome;

	public Pessoa(String nome) {
        
		this.nome = nome;
	}

	public String getNome(){

		return nome;
	}
}

public class Questao5 { 

	public static void main(String [] args){ 

		Collection<Pessoa> pessoas = new HashSet<>();

		pessoas.add(new Pessoa("Ana"));
		pessoas.add(new Pessoa("Ana"));

		System.out.println(pessoas.size());
	}
}

