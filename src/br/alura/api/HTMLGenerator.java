package br.alura.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

	public static void download(List<Movie> list) {
		for(Movie movie : list) {
			try {
				movie.downloadImage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void generate(List<Movie> movies) throws FileNotFoundException {
		File out = new File("./index.html");
		PrintWriter writer = new PrintWriter(out);
		
		writer.println("<html><body>");
		for(Movie movie : movies) {
			writer.println("<h3>" + movie.getTitle() + "</h3>");
			writer.println(" <img " + " src=\" " + movie.getImagePath() + " \"/> ");
			writer.println("<p>" + movie.getRating() + "</p>");
		}
		writer.println("</html></body>");
		writer.close();
	}
	
}
