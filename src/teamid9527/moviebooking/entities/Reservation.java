package teamid9527.moviebooking.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reservation {

	private Integer id;
	
	private Customer customer;
	
	private Set<MovieItem> movieItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<MovieItem> getMovieItems() {
		return movieItems;
	}

	public void setMovieItems(Set<MovieItem> movieItems) {
		this.movieItems = movieItems;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", customer=" + customer
				+ ", movieItems=" + movieItems + "]";
	}

	
	
}
