package br.edu.ifrn.dao;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifrn.interfaces.ICodeFile;

/*ManipuladorArquivo*/

public class DAOCodeFile implements ICodeFile {

	@Override
	public ArrayList<String> leitor(File file) throws IOException {
		Scanner sc = new Scanner(file);
		String linha ="";
		int indexComentarioInicio;
		ArrayList<String> linhas = new ArrayList<>();
		
		while (sc.hasNextLine()) {
			linha = sc.nextLine();
			
			//RETIRANDO CARACTERE ESPECIAIS
			linha = linha.replace("$", ""); 
			linha = linha.replaceAll(",", "");
			linha = linha.replaceAll("zero", " 0");
			linha = linha.stripIndent(); // TIRANDO INDENTAÇÃO
			
			// REMOVER OS LINHA COMENTADAS E COMENTARIOS NAS OUTRAS LINHAS 
			indexComentarioInicio = linha.lastIndexOf("#");				
			if ((0 > indexComentarioInicio  && linha.length() > 0) || indexComentarioInicio > 1 ){			
				if (indexComentarioInicio > 1) {
					linha = linha.substring(0, indexComentarioInicio); 
					linhas.add(linha);
					/*System.out.println(linha);*/
				} else {
					linhas.add(linha);
					/*System.out.println(linha);*/
				}				
			}
				
						
		}
		sc.close();
		return linhas;
		
	}
	
	
	public ArrayList<String> transformeBinario(ArrayList<String> linhasLimpas) throws IOException {
		ArrayList<String> linhas = new ArrayList<>();
		for (String linha: linhasLimpas) {
			
			// TRANSFORMAR NUMEROS INTEIROS EM DECIMAL
			linha = linha.replace("0", converteDecimalParaBinario(0));
			linha = linha.replace("1", converteDecimalParaBinario(1));
			linha = linha.replace("2", converteDecimalParaBinario(2));
			linha = linha.replace("3", converteDecimalParaBinario(3));
			linha = linha.replace("4", converteDecimalParaBinario(4));
			linha = linha.replace("5", converteDecimalParaBinario(5));
			linha = linha.replace("6", converteDecimalParaBinario(6));
			linha = linha.replace("7", converteDecimalParaBinario(7));
			linha = linha.replace("8", converteDecimalParaBinario(8));
			linha = linha.replace("9", converteDecimalParaBinario(9));
			
			// FUNÇÕES
			
			linha = linha.replace("addiu","001001");
			linha = linha.replace("addi","001000");
			linha = linha.replace("add", "000000");
			linhas.add(linha);
		}
		return linhas; // Linhas de comando em binario c/ espaço	 	
	}	
	
	
	//OK - VERIFICADO
	public static String converteDecimalParaBinario(int valor) {
        int qtd = 5;
        StringBuilder pattern = new StringBuilder();
        for(int i=0; i<qtd; i++) {
            pattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(Integer.parseInt(Integer.toBinaryString(valor)));
    } 
}
