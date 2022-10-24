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
		File file = new File("C:\\Users\\20171014040001\\Desktop\\eclipse-java-2022-09-R-win32-x86_64\\eclipse\\workspace\\InterpreteArquitetura\\codeASM\\code.txt");
		ArrayList<String> linhas = new ArrayList<>();
		
		DAOCodeFile dao = new DAOCodeFile();
		linhas = dao.leitor(file);
		linhas = dao.transformeBinario(linhas);
		
		
		for (String linha: linhas) {
			System.out.println(linha);
		}
		
				

	}

}
