package br.alura.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Movie {
	private String title;
	private URL url;
	private String rating;
	private String year;
	private File image;
	
	Movie(String title, String url, String rating, String year) throws IOException {
		this.title = title;
		this.url = new URL(url);
		this.rating = rating;
		this.year = year;
		this.image = this.downloadImage();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public URL getURL() {
		return this.url;
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public String getImagePath() {
		return this.image.getPath();
	}
	
	public File downloadImage() {   
		BufferedImage image = null;
		try{
            File fileJPG = new File("./tmp/" + this.title.replaceAll("\\s","") + ".jpg");
            File fileJPEG = new File("./tmp/" + this.title.replaceAll("\\s","") + ".jpeg");
            if(!(fileJPG.exists() || fileJPEG.exists())) {
            	System.out.println(this.title);
	            ImageIO.write(image, "jpg", fileJPG);
	            ImageIO.write(image, "jpeg", fileJPEG);
            }
            return fileJPG;
 
        } catch(IOException e){
            e.printStackTrace();
            return new File("");
        }
	}
	
}
