package br.edu.ifrn.dao;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifrn.interfaces.ICodeFile;

/*ManipuladorArquivo*/

public class DAOCodeFile implements ICodeFile {

	public ArrayList<String> leitorLimpador(File file) throws IOException {
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
	
	// PADRAO BINARIO - FAMILIA I 
	public ArrayList<String> transformeBinario(ArrayList<String> linhasLimpas) throws IOException {				
		ArrayList<String> linhas = new ArrayList<>();		
		for (String linha: linhasLimpas) {
			linha = linha.toLowerCase();			
			System.out.println(linha); // Exibir linha limpas 			
			String [] arraySeparadoporespaco = linha.split(" "); // separar linha por espaço
			
			// COMANDO - FAMILIA I 
			if (arraySeparadoporespaco.length == 4) {
				linhas.add(familyI(arraySeparadoporespaco));
			}
			
		}
		return linhas;
	}

	//OK - VERIFICADO
	private static String converteDecimalParaBinario(int valor) {
        int qtd = 5;
        StringBuilder pattern = new StringBuilder();
        for(int i=0; i<qtd; i++) {
            pattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(Integer.parseInt(Integer.toBinaryString(valor)));
    } 
	
	
	private String familyI(String [] arraySeparadoporespaco) {
		
		// ADDI
		if (arraySeparadoporespaco[0].equalsIgnoreCase("addi")) {				
			arraySeparadoporespaco[0] = "001000"; 
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS					
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
		}
		
		// ADDIU
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("addiu")) {
			arraySeparadoporespaco[0] = "001001"; // ADDIU
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS					
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			//return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}
		
		 // ANDI
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("andi")) {
			arraySeparadoporespaco[0] = "001100"; // ANDI
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS				
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			//return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}
		
		// ORI
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("ori")) {
			arraySeparadoporespaco[0] = "001101"; 
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS					
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			//return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}
		
		// SLTI
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("slti")) {
			arraySeparadoporespaco[0] = "001010"; 
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS					
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			//return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}
		
		// SLTIU
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("sltiu")) {
			arraySeparadoporespaco[0] = "001011"; 
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS					
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			//return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}
		
		//XORI
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("xori")) {
			arraySeparadoporespaco[0] = "001110"; 
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); //RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); //RS					
			int immediate =Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // CALCULANDO IMMEDIATE EM BINARIO 				
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA				
			//return "F ".concat(arraySeparadoporespaco[0].concat(" RT ").concat(arraySeparadoporespaco[1].concat(" RS ").concat(arraySeparadoporespaco[2].concat(" || ").concat(arraySeparadoporespaco[3]))));
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}
		
		else {
			return "j";
		}
	}
	

	
	
}
