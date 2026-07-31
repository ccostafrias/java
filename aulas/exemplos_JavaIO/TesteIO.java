import java.io.*;
import java.util.zip.*;

public class TesteIO {

	public static void testeOutputStream(String nomeArquivo) {

		System.out.println("Escrevendo para o arquivo '" + nomeArquivo + "'...");

		OutputStream out = null;

		try{
			out = new FileOutputStream(nomeArquivo);

			for(int i = 0; i < 256; i++){

				out.write(i);
			}
		}
		catch(FileNotFoundException e){
		
			System.out.println("Problema ao abrir arquivo.");
		}
		catch(IOException e){
			
			System.out.println("Problema ao escrever no arquivo.");
		}
		finally {

			try {
				if(out != null) out.close();
			}
			catch(IOException o){
		
				System.out.println("Problema ao fechar o arquivo.");		
			}
		}
	}

	public static void testeInputStream(String nomeArquivo) throws IOException {

		System.out.println("Lendo conteúdo do arquivo '" + nomeArquivo + "'...");

		InputStream in = new FileInputStream(nomeArquivo);

		int b = in.read();

		while(b >= 0){

			System.out.println("byte lido: " + b);
			b = in.read();
		}

		in.close();
	}

	public static void copia(String origem, String destino) throws IOException {

		System.out.println("Copiando conteúdo do arquivo '" + origem + "' para o arquivo '" + destino + "'...");

		InputStream in = new FileInputStream(origem);
		OutputStream out = new FileOutputStream(destino);

		for(int b = in.read(); b >= 0; b = in.read()){

			out.write(b);
		}

		in.close();		
		out.close();
	}

	public static void copia_em_bloco(String origem, String destino) throws IOException {

		System.out.println("Copiando conteúdo do arquivo '" + origem + "' para o arquivo '" + destino + "'");

		byte [] buffer = new byte[4096];
		InputStream in = new FileInputStream(origem);
		OutputStream out = new FileOutputStream(destino);

		int n = 0;

		while( (n = in.read(buffer, 0, buffer.length)) > 0 ) {

			System.out.println("copiando bloco de " + buffer.length + " bytes.");
			out.write(buffer, 0, n);
		}

		in.close();		
		out.close();
	}

	public static void testeWriter(String nomeArquivo) throws IOException {

		System.out.println("Escrevendo (writer) para o arquivo '" + nomeArquivo + "'...");

		Writer out = new FileWriter(nomeArquivo);

		out.write('c');
		out.write('a');
		out.write('s');
		out.write('a');
		out.write('\n');
		out.write('b');
		out.write('a');
		out.write('r');
		out.write('c');
		out.write('o');
		out.write('\n');
		out.write('a');
		out.write('v');
		out.write('i');
		out.write('ã');
		out.write('o');
		out.write('\n');

		out.close();
	}

	public static void testeReader(String nomeArquivo) throws IOException {

		System.out.println("Lendo (reader) conteúdo do arquivo '" + nomeArquivo + "'...");

		Reader in = new FileReader(nomeArquivo);

		int b = in.read();

		while(b >= 0){

			System.out.println("carectere lido: " + ((char)b) + " (" + b  + ")");
			b = in.read();
		}

		in.close();
	}

	public static void main(String [] args){

		String opcao = args.length > 0 ? args[0] : "write";
		String nomeArquivo = args.length > 1 ? args[1] : "arquivo";
		String nomeArquivoDest = args.length > 2 ? args[2] : "arquivo_copia";

		try{
			if(opcao.equals("write")) testeOutputStream(nomeArquivo);
			if(opcao.equals("read")) testeInputStream(nomeArquivo);
			if(opcao.equals("writec")) testeWriter(nomeArquivo);
			if(opcao.equals("readc")) testeReader(nomeArquivo);
			if(opcao.equals("copy")) copia(nomeArquivo, nomeArquivoDest);
			if(opcao.equals("bcopy")) copia_em_bloco(nomeArquivo, nomeArquivoDest);
		}
		catch(IOException e){

			System.out.println("Exceção de I/O...");
			e.printStackTrace(); 
		}	
	}

}
