package br.alura.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {

	public static void main(String[] args) throws Exception {	
		
		   HttpClient client = HttpClient.newBuilder()
				     .build();
		
		   HttpRequest request = HttpRequest.newBuilder()
		         .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_z5ilxnsq"))
		         .GET()
		         .build();
		   
		   HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		   
		   System.out.println(response.statusCode());
		   
		   JsonParser parser = new JsonParser();
		   List<Map<String, String>> data = parser.parse(response.body());
		   System.out.println(data.get(0));
		   
		   
	}
	
}
