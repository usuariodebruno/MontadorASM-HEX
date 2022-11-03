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
		ArrayList<String> linhasLimpas = new ArrayList<>();
		
		DAOCodeFile dao = new DAOCodeFile();
		linhasLimpas = dao.leitorLimpador(file);
		linhasLimpas = dao.transformeBinario(linhasLimpas);
		
		
		for (String linha: linhasLimpas) {
			System.out.println(linha);
		}
		
				

	}

}
