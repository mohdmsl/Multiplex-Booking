package model;

public class Movies {
	
	private int movieId;
	private String movieLanguage;
	private String movieName;
	
	public Movies(int movieId, String movieName, String movieLanguage) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
	}
	public int getMovieId() {
		return movieId;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
}
