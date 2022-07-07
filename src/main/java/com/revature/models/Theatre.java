package com.revature.models;

import java.util.ArrayList;
import java.util.List;

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
	
}
