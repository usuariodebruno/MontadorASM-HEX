package br.edu.ifrn.entidades;
/**
 * @author Bruno Almeida 
 * 24 de out. de 2022
 */

public class CodeFile {
	private String caminho;	
	
	public CodeFile(String endereco) {
		super();
		this.caminho = endereco;
	}
	
	public String getEndereco() {
		return caminho;
	}
	public void setEndereco(String endereco) {
		this.caminho = endereco;
	}
	
	
}
