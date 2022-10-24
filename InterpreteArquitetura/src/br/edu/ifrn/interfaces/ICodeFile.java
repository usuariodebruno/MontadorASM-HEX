package br.edu.ifrn.interfaces;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public interface ICodeFile {
	public ArrayList<String> leitor(File file) throws IOException;
}
