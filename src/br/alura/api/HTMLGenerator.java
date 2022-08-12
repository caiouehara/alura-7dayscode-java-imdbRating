package br.alura.api;

import java.io.Writer;
import java.util.List;

public class HTMLGenerator {
	private Writer writer;
	
	HTMLGenerator(Writer writer) {
		this.writer = writer;
	}
	
	public void generate(List<Movie> list) {
		
	}
}
