import java.io.*;
import java.util.zip.*;

public class TesteIO_parte2 {

	public static void testeDataOutput(String nomeArquivo) throws IOException {

		System.out.println("Escrevendo para o arquivo '" + nomeArquivo + "'...");

		DataOutputStream out = new DataOutputStream(new FileOutputStream(nomeArquivo));

		out.writeInt(16777215);
		out.writeInt(65535);
		out.writeDouble(Math.PI);
		out.writeBoolean(true);
		out.writeBoolean(false);
		out.writeUTF("Uma cadeia de caracteres");

		out.close();
	}

	public static void testeDataInput(String nomeArquivo) throws IOException {

		System.out.println("Lendo conteúdo do arquivo '" + nomeArquivo + "'...");

		DataInputStream in = new DataInputStream(new FileInputStream(nomeArquivo));

		int x = in.readInt();
		int y = in.readInt();
		double pi = in.readDouble();
		boolean b1 = in.readBoolean();
		boolean b2 = in.readBoolean();
		String s = in.readUTF();

		System.out.println("int: " + x + ", " + y);
		System.out.println("double: " + pi);
		System.out.println("boolean: " + b1 + ", " + b2);
		System.out.println("String: '" + s + "'");

		in.close();
	}

	public static void testeBufferedReader(String nomeArquivo) throws IOException {
	
		BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));

		String linha = null;

		while ( (linha = in.readLine()) != null ){
		
			System.out.println("linha: '" + linha + "'");
		}

		in.close();
	}

	public static void main(String [] args) {

		String opcao = args.length > 0 ? args[0] : "write";
		String nomeArquivo = args.length > 1 ? args[1] : "arquivo";
	
		try{
			if(opcao.equals("write")) testeDataOutput(nomeArquivo);
			if(opcao.equals("read")) testeDataInput(nomeArquivo);
			if(opcao.equals("buff")) testeBufferedReader(nomeArquivo);
		}
		catch(IOException e){

			System.out.println("Exceção de I/O...");
			e.printStackTrace(); 
		}	
	}

}
