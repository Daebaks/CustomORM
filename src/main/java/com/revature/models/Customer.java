package com.revature.models;

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
import javax.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "username", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "firstname", nullable = false)
	private String firstName;
	
	@Column(name = "lastname", nullable = false)
	private String lastName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	//this is for the junction table
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ticket> tickets;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_fk")
	private List<Ticket> ticketHolders;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Ticket> getTicketHolders() {
		return ticketHolders;
	}

	public void setTicketHolders(List<Ticket> ticketHolders) {
		this.ticketHolders = ticketHolders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, firstName, lastName, password, ticketHolders, tickets, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customerId == other.customerId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(ticketHolders, other.ticketHolders) && Objects.equals(tickets, other.tickets)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", tickets=" + tickets + ", ticketHolders="
				+ ticketHolders + "]";
	}

	public Customer(int customerId, String userName, String firstName, String lastName, String password,
			List<Ticket> tickets, List<Ticket> ticketHolders) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.tickets = tickets;
		this.ticketHolders = ticketHolders;
	}

	public Customer(String userName, String firstName, String lastName, String password, List<Ticket> tickets,
			List<Ticket> ticketHolders) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.tickets = tickets;
		this.ticketHolders = ticketHolders;
	}

	public Customer() {
		super();
	}

	
	
}
