package br.alura.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teste {

	public static HttpResponse<String> service(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newBuilder().build();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response;
	}

	public static List<Movie> createMovies(HttpResponse<String> response) throws IOException {
		JsonParser parser = new JsonParser();
		List<Map<String, String>> data = parser.parse(response.body());
		List<Movie> movies = new ArrayList<>();

		for (Map<String, String> item : data) {
			Movie movie = new Movie(item.get("title"), item.get("image"), item.get("imDbRating"), item.get("year"));
			movies.add(movie);
		}
		return movies;
	}

	public static void main(String[] args) throws Exception {
		HttpResponse<String> response = service("https://imdb-api.com/en/API/Top250Movies/k_z5ilxnsq");
		System.out.println(response.statusCode());
		List<Movie> movies = createMovies(response);
		
		HTMLGenerator.download(movies);
		HTMLGenerator.generate(movies);
	}
}
