package br.edu.ifrn.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * @author Bruno Almeida 
 * 24 de out. de 2022 
 * 20171014040001
 */

public class Main {
	public static void main(String[] args) throws IOException {
		// DECLARAÇÕES
		File file = new File("C:\\Users\\20171014040001\\eclipse-workspace\\InterpreteArquitetura\\codeASM\\code.txt");
		ArrayList<String> linhas = new ArrayList<>();
		MontadorBinario montadorBinario = new MontadorBinario();
		Gravador gravador = new Gravador();
		Leitor dao = new Leitor();

		linhas = dao.leitorLimpador(file); // LINHAS LIMPAS
		linhas = montadorBinario.transformeBinario(linhas); // LINHAS EM BINARIO COM ROTULOS

		System.err.println("\n################ BINARIO ################\n");
		for (String linha : linhas) {
			System.out.println(linha);
		}

		System.err.println("\n################ HEXADECIMAL ################\n");
		linhas = dao.coverteHexadecimal(linhas);
		for (String linha : linhas) {
			System.out.println(linha);
		}

		// GRAVAR SAIDA EM TXT NA PATH
		if (gravador.gravador(linhas)) {
			System.err.println("\n------------ ARQUIVO SALVO COM SUCESSO!!! ------------\n");
		} else {
			System.err.println(" ERRO AO SALVAR ARQUIVO :$");
		}

	}

}
