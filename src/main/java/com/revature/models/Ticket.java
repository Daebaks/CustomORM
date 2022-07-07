package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {

	//no need to specify as it will be created by default with the name num_tickets
	private int num_tickets;
	
	// customer fk
	@ManyToMany(mappedBy = "ticketHolders", fetch = FetchType.LAZY)
	private List<Customer> customers = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_fk")
	private Movie movieTicket;

	public int getNum_tickets() {
		return num_tickets;
	}

	public void setNum_tickets(int num_tickets) {
		this.num_tickets = num_tickets;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Movie getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(Movie movieTicket) {
		this.movieTicket = movieTicket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customers, movieTicket, num_tickets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(customers, other.customers) && Objects.equals(movieTicket, other.movieTicket)
				&& num_tickets == other.num_tickets;
	}

	@Override
	public String toString() {
		return "Ticket [num_tickets=" + num_tickets + ", customers=" + customers + ", movieTicket=" + movieTicket + "]";
	}

	public Ticket(int num_tickets, List<Customer> customers, Movie movieTicket) {
		super();
		this.num_tickets = num_tickets;
		this.customers = customers;
		this.movieTicket = movieTicket;
	}

	public Ticket() {
		super();
	}
	
	
	
	
}
