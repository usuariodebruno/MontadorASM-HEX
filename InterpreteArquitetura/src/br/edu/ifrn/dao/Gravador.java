/**
 * 
 */
package br.edu.ifrn.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Bruno Almeida 22 de nov. de 2022 20171014040001
 */

public class Gravador {
	public boolean gravador(ArrayList<String> arquivo) throws IOException {
		
		//LENDO PATH E ORGANIZANDO A CASA 
		File path = new File("C:\\Users\\20171014040001\\Desktop\\txtSaída.txt");
		FileWriter wt = new FileWriter(path);
		BufferedWriter bwt = new BufferedWriter(wt);
		int cont = 0;
		
		// GRAVAR LINHA A LINHA NO TXT
		for (String a : arquivo) {
			bwt.write(a+"\n");
			cont++;
		}		
		
		bwt.flush();bwt.close();
		if (cont == arquivo.size()) {return true;}else {return false;}	
	}
}
