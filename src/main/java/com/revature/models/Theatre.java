package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {

	@Id
	@Column(name = "theatre_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	
	@Column(name = "num_seats", nullable = false)
	private int numOfSeats;
	
	@Column(name = "curr_movie", nullable = false)
	private String currMovie;
	
	@Column(name = "movie_menu", nullable = false)
	private List<Movie> movieMenu;
	
	@ManyToMany(mappedBy = "theatreHolder", fetch = FetchType.LAZY)
	private List<Movie> movies = new ArrayList<>();

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getCurrMovie() {
		return currMovie;
	}

	public void setCurrMovie(String currMovie) {
		this.currMovie = currMovie;
	}

	public List<Movie> getMovieMenu() {
		return movieMenu;
	}

	public void setMovieMenu(List<Movie> movieMenu) {
		this.movieMenu = movieMenu;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currMovie, movieMenu, movies, numOfSeats, theatreId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return Objects.equals(currMovie, other.currMovie) && Objects.equals(movieMenu, other.movieMenu)
				&& Objects.equals(movies, other.movies) && numOfSeats == other.numOfSeats
				&& theatreId == other.theatreId;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", numOfSeats=" + numOfSeats + ", currMovie=" + currMovie
				+ ", movieMenu=" + movieMenu + ", movies=" + movies + "]";
	}

	public Theatre(int theatreId, int numOfSeats, String currMovie, List<Movie> movieMenu, List<Movie> movies) {
		super();
		this.theatreId = theatreId;
		this.numOfSeats = numOfSeats;
		this.currMovie = currMovie;
		this.movieMenu = movieMenu;
		this.movies = movies;
	}

	public Theatre(int numOfSeats, String currMovie, List<Movie> movieMenu, List<Movie> movies) {
		super();
		this.numOfSeats = numOfSeats;
		this.currMovie = currMovie;
		this.movieMenu = movieMenu;
		this.movies = movies;
	}

	public Theatre() {
		super();
	}
	
	
	
}
