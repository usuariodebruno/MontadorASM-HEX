package br.edu.ifrn.dao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class MontadorBinario {
	int i;

	// OK - VERIFICADO
	private static String converteDecimalParaBinario(int valor) {
		int qtd = 5;
		StringBuilder pattern = new StringBuilder();
		for (int i = 0; i < qtd; i++) {
			pattern.append("0");
		}
		DecimalFormat df = new DecimalFormat(pattern.toString());
		return df.format(Integer.parseInt(Integer.toBinaryString(valor)));

	}

	// PADRAO BINARIO
	public ArrayList<String> transformeBinario(ArrayList<String> linhasLimpas) throws IOException {
		ArrayList<String> linhas = new ArrayList<>();
		for (String linha : linhasLimpas) {
			linha = linha.toLowerCase();

			// System.out.println(linha); // EXIBIR LINHAS LIMPAS

			String[] arraySeparadoporespaco = linha.split(" "); // SEPARAR COMANDOS POR ESPAÇO
			linhas.add(montadorBinario(arraySeparadoporespaco)); // RETORNO BINARIO E ROTULOS

		}
		return linhas;
	}

	private String montadorBinario(String[] arraySeparadoporespaco) {
		++i; // CONTADOR LINHA DO DOC

		// FAMILIA R
		// -------------------------------------------------------------------------------------------------------
		// ADD - R
		if (arraySeparadoporespaco[0].equalsIgnoreCase("add")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			
			System.out.println("####################### \n");			
			System.out.println("ADD - LINHA: " + i);
			System.out.println(Arrays.toString(arraySeparadoporespaco));
			
			System.out.println("RS " + arraySeparadoporespaco[1]);	
			
			int rs = Integer.parseInt(arraySeparadoporespaco[1]);	
			System.out.println("----------");
			
			
			System.out.println("RT " + arraySeparadoporespaco[2]);
			int rt = Integer.parseInt(arraySeparadoporespaco[2]);	
			System.out.println("----------");

			System.out.println("RD " + arraySeparadoporespaco[3]);
			int rd = Integer.parseInt(arraySeparadoporespaco[3]);	
			System.out.println("----------");
			
			arraySeparadoporespaco[1] = converteDecimalParaBinario(rd); // RD
			arraySeparadoporespaco[2] = converteDecimalParaBinario(rs); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(rt); // RT
			
			String add = "100000"; // ADD
			
			System.out.println("RD " + arraySeparadoporespaco[1]);
			System.out.println("RS " + arraySeparadoporespaco[2]);
			System.out.println("RT " + arraySeparadoporespaco[3]);
			
			System.out.println(arraySeparadoporespaco[0].concat(arraySeparadoporespaco[2]
					.concat(arraySeparadoporespaco[3].concat(arraySeparadoporespaco[1].concat("00000".concat(add))))));
			
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[2]
					.concat(arraySeparadoporespaco[3].concat(arraySeparadoporespaco[1].concat("00000".concat(add)))));
		}

		// ADDU - R
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("addu")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100001"; // ADDU
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// BASTARDOS
		// -------------------------------------------------------------------------------------------------------
		// DIV
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("div")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = "0000000000";
			String add = "011010"; // DIV
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// DIVU
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("divu")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = "0000000000";
			String add = "011011"; // DIVU
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// AND
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("and")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100100"; // AND
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// MUL
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("mul")) {
			arraySeparadoporespaco[0] = "011100"; // SPECIAL2
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "000010"; // MUL
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// MULT
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("mult")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = "0000000000";
			String add = "011000"; // MULT
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// MULTU
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("multu")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = "0000000000";
			String add = "011001"; // MULTU
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// NOP
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("nop")) {
			return String.format("%032d", "0");
		}

		// NOR
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("nor")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100111"; // NOR
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// OR
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("or")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100101"; // OR
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// SLL
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("sll")) {
			arraySeparadoporespaco[0] = "000000".concat("00000"); // SPECIAL + 5zeroBinario
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "000000"; // SLL
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// SLT
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("slt")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RS
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RT
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "101010"; // SLT
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// SLTU
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("sltu")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RS
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RT
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "101011"; // SLTU
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// SRA
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("sra")) {
			arraySeparadoporespaco[0] = "000000".concat("00000"); // SPECIAL + 5zeroBinario
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // SA
			String add = "000011"; // SRA
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// SRL
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("srl")) {
			arraySeparadoporespaco[0] = "000000".concat("0000").concat("0"); // SPECIAL + 4zeroBinario + R
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // SA
			String add = "000010"; // SRL
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat(add))));
		}

		// SUB
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("sub")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100010"; // SUBCode
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}

		// SUBU
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("subu")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RS
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100011"; // SUBU
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}
		// XOR
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("xor")) {
			arraySeparadoporespaco[0] = "000000"; // SPECIAL
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[1])); // RS
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[2])); // RT
			arraySeparadoporespaco[3] = converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3])); // RD
			String add = "100110"; // XOR
			return arraySeparadoporespaco[0].concat(arraySeparadoporespaco[1]
					.concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3].concat("00000".concat(add)))));
		}
		// SYSCALL
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("syscall")) {
			String code = String.format("%020d", 0);
			arraySeparadoporespaco[0] = "000000".concat(code); // SPECIAL + code
			String add = "001100"; // SYSCALL CODE
			return arraySeparadoporespaco[0].concat(add);
		}

		// FAMILIA I
		// -------------------------------------------------------------------------------------------------------
		// ADDI - I

		else if (arraySeparadoporespaco[0].equalsIgnoreCase("addi")) {
			arraySeparadoporespaco[0] = "001000";	 // ADDI 		
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];	
			
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}

		// ADDIU - I
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("addiu")) {
			arraySeparadoporespaco[0] = "001001"; // ADDIU			
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];				
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT				
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));

		}

		// ANDI - I
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("andi")) {
			arraySeparadoporespaco[0] = "001100"; // ANDI
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];				
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT				
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}

		// ORI - I
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("ori")) {
			arraySeparadoporespaco[0] = "001101";
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];				
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT				
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}

		// SLTI - I
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("slti")) {
			arraySeparadoporespaco[0] = "001010";
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];				
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT				
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}

		// SLTIU - I
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("sltiu")) {
			arraySeparadoporespaco[0] = "001011";
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];				
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT				
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}

		// XORI - I
		else if (arraySeparadoporespaco[0].equalsIgnoreCase("xori")) {
			arraySeparadoporespaco[0] = "001110";
			String RS = arraySeparadoporespaco[1];	
			String RT = arraySeparadoporespaco[2];				
			arraySeparadoporespaco[1] = converteDecimalParaBinario(Integer.parseInt(RT)); // RT				
			arraySeparadoporespaco[2] = converteDecimalParaBinario(Integer.parseInt(RS)); // RS
			int immediate = Integer.parseInt(converteDecimalParaBinario(Integer.parseInt(arraySeparadoporespaco[3]))); // immediate
			arraySeparadoporespaco[3] = String.format("%016d", immediate); // IMMEDIATE - ZEROS A ESQUERDA
			return arraySeparadoporespaco[0].concat(
					arraySeparadoporespaco[1].concat(arraySeparadoporespaco[2].concat(arraySeparadoporespaco[3])));
		}

		else {
			return arraySeparadoporespaco[0];
		}
	}

}
