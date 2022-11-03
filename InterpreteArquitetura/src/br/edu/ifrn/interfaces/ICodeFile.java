package br.edu.ifrn.interfaces;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public interface ICodeFile {
	public ArrayList<String> leitorLimpador(File file) throws IOException;
}
