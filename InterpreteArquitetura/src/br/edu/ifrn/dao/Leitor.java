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
			
			linha = linha.replace(",", "");
			linha = linha.replace("$zero", "0");
			linha = linha.replace("$at", "1");
			
			linha = linha.replace("$v0", "2");
			linha = linha.replace("$v1", "3");
			
			linha = linha.replace("$a0", "4");
			linha = linha.replace("$a1", "5");
			linha = linha.replace("$a2", "6");
			linha = linha.replace("$a3", "7");
			
			linha = linha.replace("$t0", "8");
			linha = linha.replace("$t1", "9");
			linha = linha.replace("$t2", "10");
			linha = linha.replace("$t3", "11");
			linha = linha.replace("$t4", "12");
			linha = linha.replace("$t5", "13");
			linha = linha.replace("$t6", "14");
			linha = linha.replace("$t7", "15");
			
			linha = linha.replace("$s0", "16");
			linha = linha.replace("$s1", "17");
			linha = linha.replace("$s2", "18");
			linha = linha.replace("$s3", "19");
			linha = linha.replace("$s4", "20");
			linha = linha.replace("$s5", "21");
			linha = linha.replace("$s6", "22");
			linha = linha.replace("$s7", "23");
			
			linha = linha.replace("$t8", "24");
			linha = linha.replace("$t9", "25");
			
			linha = linha.replace("$k0", "26");
			linha = linha.replace("$k1", "27");			
			linha = linha.replace("$gp", "28");
			linha = linha.replace("$sp", "29");
			linha = linha.replace("$fp", "31");
			linha = linha.replace("$ra", "31");			
			
			linha = linha.replace("$", "");
			linha = linha.replace("$zero", " 0");
			
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
			System.out.println(linha); //EXIBIR LINHAS LIMPAS 

		}
		sc.close();
		return linhas;

	}
	
	public ArrayList<String> coverteHexadecimal(ArrayList<String> linhas){
		ArrayList<String> linhasHexadecimal = new ArrayList<>();
		String[] linhaQuebrada = new String[8];
		
		for (String linha: linhas) {
			if (linha.length() == 32) {	
				linhaQuebrada[0] = linha.substring(0, 4); // 0 - 4
				linhaQuebrada[0] = Integer.toString(Integer.parseInt(linhaQuebrada[0], 2), 16);
				
				linhaQuebrada[1] = linha.substring(4, 8); // 4 - 8
				linhaQuebrada[1] = Integer.toString(Integer.parseInt(linhaQuebrada[1], 2), 16);
				
				linhaQuebrada[2] = linha.substring(8, 12); // 8 - 12
				linhaQuebrada[2] = Integer.toString(Integer.parseInt(linhaQuebrada[2], 2), 16);
				
				linhaQuebrada[3] = linha.substring(12, 16); // 12 - 16
				linhaQuebrada[3] = Integer.toString(Integer.parseInt(linhaQuebrada[3], 2), 16);
				
				linhaQuebrada[4] = linha.substring(16, 20); // 16 - 20	
				linhaQuebrada[4] = Integer.toString(Integer.parseInt(linhaQuebrada[4], 2), 16);
				
				linhaQuebrada[5] = linha.substring(20, 24); // 20 - 24
				linhaQuebrada[5] = Integer.toString(Integer.parseInt(linhaQuebrada[5], 2), 16)
						;
				linhaQuebrada[6] = linha.substring(24, 28); // 24 - 28
				linhaQuebrada[6] = Integer.toString(Integer.parseInt(linhaQuebrada[6], 2), 16);
				
				linhaQuebrada[7] = linha.substring(28, 32); // 28 - 32
				linhaQuebrada[7] = Integer.toString(Integer.parseInt(linhaQuebrada[7], 2), 16);
				
				String a = linhaQuebrada[0].concat(linhaQuebrada[1].concat(linhaQuebrada[2].concat(linhaQuebrada[3].concat(linhaQuebrada[4]).concat(linhaQuebrada[5]).concat(linhaQuebrada[6].concat(linhaQuebrada[7])))));
				linhasHexadecimal.add(a);
			} 
			else {
				linhasHexadecimal.add(linha);
			}
		}
		return linhasHexadecimal;
	}

	
}
