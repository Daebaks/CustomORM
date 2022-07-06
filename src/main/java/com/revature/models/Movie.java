package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name = "movie_title", nullable = false)
	private String movieTitle;
	
	@Column(name = "movie_type", nullable = false)
	private String movieType;
	
	@Column(name = "movie_duration_min", nullable = false)
	private int movieDurationMin;
	
	@Column(name = "ticket_price", nullable = false)
	private double ticketPrice;
	
	@Column(name = "movie_release_year", nullable = false)
	private int releasedYear;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public int getMovieDurationMin() {
		return movieDurationMin;
	}

	public void setMovieDurationMin(int movieDurationMin) {
		this.movieDurationMin = movieDurationMin;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	public Movie() {
		super();
	}

	public Movie(int movieId, String movieTitle, String movieType, int movieDurationMin, double ticketPrice,
			int releasedYear) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieType = movieType;
		this.movieDurationMin = movieDurationMin;
		this.ticketPrice = ticketPrice;
		this.releasedYear = releasedYear;
	}

	public Movie(String movieTitle, String movieType, int movieDurationMin, double ticketPrice, int releasedYear) {
		super();
		this.movieTitle = movieTitle;
		this.movieType = movieType;
		this.movieDurationMin = movieDurationMin;
		this.ticketPrice = ticketPrice;
		this.releasedYear = releasedYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieDurationMin, movieId, movieTitle, movieType, releasedYear, ticketPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return movieDurationMin == other.movieDurationMin && movieId == other.movieId
				&& Objects.equals(movieTitle, other.movieTitle) && Objects.equals(movieType, other.movieType)
				&& releasedYear == other.releasedYear
				&& Double.doubleToLongBits(ticketPrice) == Double.doubleToLongBits(other.ticketPrice);
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieType=" + movieType
				+ ", movieDurationMin=" + movieDurationMin + ", ticketPrice=" + ticketPrice + ", releasedYear="
				+ releasedYear + "]";
	}
	
	
	
}
