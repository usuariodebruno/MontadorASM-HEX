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
		leitorLimpador dao = new leitorLimpador();
		
		linhas = dao.leitorLimpador(file); // LINHAS LIMPAS 
		linhas = montadorBinario.transformeBinario(linhas); // LINHAS EM BINARIO COM ROTULOS
		
		
		
		for (String linha: linhas) {
			System.out.println(linha);
		}
		
				

	}

}
