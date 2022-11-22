package br.edu.ifrn.dao;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * @author Bruno Almeida 
 * 24 de out. de 2022
 */

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\20171014040001\\eclipse-workspace\\InterpreteArquitetura\\codeASM\\code.txt");
		ArrayList<String> linhas = new ArrayList<>();
		MontadorBinario montadorBinario = new MontadorBinario();		
		Leitor dao = new Leitor();
		
		linhas = dao.leitorLimpador(file); // LINHAS LIMPAS 
		linhas = montadorBinario.transformeBinario(linhas); // LINHAS EM BINARIO COM ROTULOS
		
		System.out.println("\n################ BINARIO ################\n ");
		for (String linha: linhas) {
			System.out.println(linha);
		}
		
		System.out.println("\n################ HEXADECIMAL ################\n ");
		linhas = dao.coverteHexadecimal(linhas);	
		for (String linha: linhas) {
			System.out.println(linha);
		}
		
				

	}

}
