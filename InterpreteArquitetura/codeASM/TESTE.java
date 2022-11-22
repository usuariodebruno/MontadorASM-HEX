package br.edu.ifrn.dao;

public class TESTE {

	public static void main(String[] args) {
		String s = "00100001000000000000000101101000";
		int i = Integer.parseInt (s, 2);
		String x = String.format ("%08X", i);
		System.out.println (x);
	}

}
