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
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (id != null && id == other.id)
			return true;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movieItems == null) {
			if (other.movieItems != null)
				return false;
		} else if (!movieItems.equals(other.movieItems))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", customer=" + customer
				+ ", movieItems=" + movieItems + "]";
	}

	
	
}
