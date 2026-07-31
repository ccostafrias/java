import java.io.*;
import java.util.zip.*;
import java.util.*;

class Aluno implements Serializable {

	// Se necessário, podemos gerenciar de forma  
	// manual o serialVersionUID da classe.

	//private static final long serialVersionUID = 1L;
	
	private int nUSP;
	private String nome;
	private int x;
	
	public Aluno(String nome, int nUSP){

		this.nome = nome;
		this.nUSP  = nUSP;
	}

	public String toString() {

		return nome + " (" + nUSP + ", " + x + ")";
	}

	public int getNUSP(){

		return nUSP;
	}

	public String getNome(){

		return nome;
	}

	// Se for necessário, podemos customizar a forma como a classe é
	// serializada e deserializada fornecendo implementações para os
	// métodos writeObject e readObject.
	
	/*
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {

		System.out.println("writeObject...");

		out.writeInt(getNUSP());
		out.writeUTF(getNome());
	}
 
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

		System.out.println("readObject...");

		nUSP = in.readInt();
		nome = in.readUTF();
	}
	*/
	
}

public class TesteIO_parte3 {

	public static void testeObjectOutput(String nomeArquivo) throws IOException {

		System.out.println("Escrevendo para o arquivo '" + nomeArquivo + "'...");

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));

		Collection<Aluno> col = new ArrayList<>();

		Aluno a = new Aluno("Fabio", 0x12345678);
		Aluno b = new Aluno("Bianca", 0x00FFFFFF);
		Aluno c = new Aluno("Xavier", 0x00AAAAAA);

		col.add(a);
		col.add(b);
		col.add(c);

		System.out.println(col);
		out.writeObject(col);
		
		out.close();
	}

	public static void testeObjectInput(String nomeArquivo) throws IOException, ClassNotFoundException {

		System.out.println("Lendo conteúdo do arquivo '" + nomeArquivo + "'...");

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo));

		Collection<Aluno> col = (Collection<Aluno>) in.readObject();
		System.out.println(col);

		in.close();
	}

	public static void main(String [] args) {

		String opcao = args.length > 0 ? args[0] : "write";
		String nomeArquivo = args.length > 1 ? args[1] : "arquivo";
	
		try{
			if(opcao.equals("write")) testeObjectOutput(nomeArquivo);
			if(opcao.equals("read")) testeObjectInput(nomeArquivo);
		}
		catch(IOException e){

			System.out.println("Exceção de I/O...");
			e.printStackTrace(); 
		}	
		catch(ClassNotFoundException e){

			System.out.println("Classe desconhecida...");
			e.printStackTrace(); 
		}	
	}
}

