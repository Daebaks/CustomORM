package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "movieTicket", fetch = FetchType.LAZY)
	private List<Ticket> tickets = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_fk")
	private List<Theatre> theatreHolder;

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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Theatre> getTheatreHolder() {
		return theatreHolder;
	}

	public void setTheatreHolder(List<Theatre> theatreHolder) {
		this.theatreHolder = theatreHolder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieDurationMin, movieId, movieTitle, movieType, releasedYear, theatreHolder, ticketPrice,
				tickets);
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
				&& releasedYear == other.releasedYear && Objects.equals(theatreHolder, other.theatreHolder)
				&& Double.doubleToLongBits(ticketPrice) == Double.doubleToLongBits(other.ticketPrice)
				&& Objects.equals(tickets, other.tickets);
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieType=" + movieType
				+ ", movieDurationMin=" + movieDurationMin + ", ticketPrice=" + ticketPrice + ", releasedYear="
				+ releasedYear + ", tickets=" + tickets + ", theatreHolder=" + theatreHolder + "]";
	}

	public Movie(int movieId, String movieTitle, String movieType, int movieDurationMin, double ticketPrice,
			int releasedYear, List<Ticket> tickets, List<Theatre> theatreHolder) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieType = movieType;
		this.movieDurationMin = movieDurationMin;
		this.ticketPrice = ticketPrice;
		this.releasedYear = releasedYear;
		this.tickets = tickets;
		this.theatreHolder = theatreHolder;
	}

	public Movie(String movieTitle, String movieType, int movieDurationMin, double ticketPrice, int releasedYear,
			List<Ticket> tickets, List<Theatre> theatreHolder) {
		super();
		this.movieTitle = movieTitle;
		this.movieType = movieType;
		this.movieDurationMin = movieDurationMin;
		this.ticketPrice = ticketPrice;
		this.releasedYear = releasedYear;
		this.tickets = tickets;
		this.theatreHolder = theatreHolder;
	}

	public Movie() {
		super();
	}
	
	
}
