package br.edu.ifrn.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifrn.interfaces.ICodeFile;

/*ManipuladorArquivo*/

public class Leitor implements ICodeFile {

	public ArrayList<String> leitorLimpador(File file) throws IOException {
		Scanner sc = new Scanner(file);
		String linha = "";
		int indexComentarioInicio;
		ArrayList<String> linhas = new ArrayList<>();

		while (sc.hasNextLine()) {
			linha = sc.nextLine();

			// RETIRANDO CARACTERE ESPECIAIS
			linha = linha.replace("$", "");
			linha = linha.replaceAll(",", "");
			linha = linha.replaceAll("zero", " 0");
			linha = linha.stripIndent(); // TIRANDO INDENTAÇÃO

			// REMOVER OS LINHA COMENTADAS E COMENTARIOS NAS OUTRAS LINHAS
			indexComentarioInicio = linha.lastIndexOf("#");
			if ((0 > indexComentarioInicio && linha.length() > 0) || indexComentarioInicio > 1) {
				if (indexComentarioInicio > 1) {
					linha = linha.substring(0, indexComentarioInicio);
					linhas.add(linha);
				} else {
					linhas.add(linha);
				}
			}

		}
		sc.close();
		return linhas;

	}

	public ArrayList<String> coverteHexadecimal(ArrayList<String> linhas){
		ArrayList<String> linhasHexadecimal = new ArrayList<>();
		for (String linha: linhas) {
			if (linha.length() == 32) {	
				linhasHexadecimal.add(Integer.toString(Integer.parseInt(linha, 2), 16));
			} 
			else {
				linhasHexadecimal.add(linha); 
			}
		}
		return linhasHexadecimal;
	}
}
