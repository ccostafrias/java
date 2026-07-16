// classe genérica a ser usada nos exemplos de métodos genéricos.
// Implementa uma lista linear, que utiliza internamente um vetor
// como espaço de armazenamento dos elementos.

class Lista <T> {

	T [] dados;
	int livre;

	@SuppressWarnings("unchecked")
	public Lista(int max){

		dados = (T []) new Object[max];
		livre = 0;
	}

	public void add(T x){

		if(livre < dados.length){

			dados[livre] = x;
			livre++;
		}
		else throw new IllegalStateException("Lista cheia!");
	}

	public int tamanho(){

		return livre;
	}

	public T get(int i){

		if(i < tamanho()){

			return dados[i];
		}
		else throw new IllegalArgumentException("Indice invalido!");
	}

	public T set(int i, T x){

		if(i < tamanho()){

			T old = dados[i];
			dados[i] = x;
			return old;
		}
		else throw new IllegalArgumentException("Indice invalido!");		
	}
}

public class MetodosGenericos {

	// metodo que recebe uma lista generica de elementos do
	// tipo T e imprime o conteudo da lista na saída padrão.

	public static <T> void printGenerico(Lista <T> lista){

		System.out.print("Lista:");

		for(int i = 0; i < lista.tamanho(); i++){

			T elemento = lista.get(i);
			System.out.print(" " + elemento);
		}

		System.out.println();
	}

	// idem, mas com uma declaração alternativa que usa coringa.
	// Esse estilo de declaração pode ser adotado sempre que não
	// for necessário usar a variável de tipo para declarar o tipo
	// de algum parâmetro, variável local, ou o tipo do retorno.

	public static void printGenericoUsandoCoringa(Lista <?> lista){

		System.out.print("Lista:");

		for(int i = 0; i < lista.tamanho(); i++){

			System.out.print(" " + lista.get(i));
		}

		System.out.println();
	}

	// um método não generico que recebe uma lista de Number, e troca os 
	// valores maiores que 'limite' pelo valor 'novo'. Este exemplo serve
	// para ilustrar que este método não pode receber listas cujo tipo dos
	// elementos seja alguma subclasse de Number. Por exemplo, embora Integer 
	// seja subtipo de Number, uma Lista<Integer> não pode ser passada como
	// parâmetro para este método pois não é subtipo de Lista<Number>.

	public static void troca_nao_generico(Lista<Number> lista, Number limite, Number novo){

		for(int i = 0; i < lista.tamanho(); i++){
	
			if(lista.get(i).doubleValue() > limite.doubleValue()) lista.set(i, novo);
		}
	}

	// método que faz a mesma coisa que o anterior, mas agora em versão
	// genérica de fato. Esta versão do método aceita listas cujo tipo
	// dos elementos seja qualquer subclasse de Number.

	public static <T extends Number> void trocaGenerico(Lista<T> lista, T limite, T novo){

		for(int i = 0; i < lista.tamanho(); i++){

			if(lista.get(i).doubleValue() > limite.doubleValue()) lista.set(i, novo);
		}
	}	

	// mesma funcionalidade do método anterior, mas aceitando uma variedade maior
	// para o tipo dos elementos da lista. De fato, este metodo aceita listas de
	// qualquer tipo, desde que o tipo seja comparável consigo mesmo.

	public static <T extends Comparable<T>> void trocaGenericoComparable(Lista<T> lista, T limite, T novo){

		for(int i = 0; i < lista.tamanho(); i++){
	
			if(lista.get(i).compareTo(limite) > 0) lista.set(i, novo);
		}
	}

	public static void teste1(){
	
		Lista<Integer> lista = new Lista<>(100);
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		
		printGenerico(lista);
		
		//troca_nao_generico(lista, 5, -5);		<--- por que esta chamada não compila?
		trocaGenerico(lista, 4, -4);
		trocaGenericoComparable(lista, 2, -2);

		printGenericoUsandoCoringa(lista);
	}

	public static void teste2(){
	
		Lista<Number> lista = new Lista<>(100);
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		
		printGenerico(lista);
		
		troca_nao_generico(lista, 4, -4);
		trocaGenerico(lista, 2, -2);
		// trocaGenericoComparable(lista, 1, -1);	<--- por que esta chamada não compila?
		
		printGenericoUsandoCoringa(lista);
	}

	public static void teste3(){
	
		Lista<String> lista = new Lista<>(100);
		
		lista.add("vermelho");
		lista.add("verde");
		lista.add("azul");
		lista.add("amarelo");
		lista.add("ciano");
		lista.add("magenta");
		lista.add("preto");
		lista.add("branco");
		
		printGenerico(lista);
		trocaGenericoComparable(lista, "magenta", "...");
		printGenericoUsandoCoringa(lista);
	}

	public static void main(String [] args){

		teste1();
		System.out.println("------------------------------------------------------------------");
		teste2();
		System.out.println("------------------------------------------------------------------");
		teste3();
	}
}
