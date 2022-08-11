package br.alura.api;

import java.net.URI;

public class Movie {
	private String title;
	private String url;
	private String rating;
	private String year;
	
	Movie(String title, String url, String rating, String year){
		this.title = title;
		this.url = url;
		this.rating = rating;
		this.year = year;
	}
	
	public String get() {
		return "Titulo: " + this.title;
	}
}
