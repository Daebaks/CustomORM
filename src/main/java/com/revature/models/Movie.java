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
	
}
